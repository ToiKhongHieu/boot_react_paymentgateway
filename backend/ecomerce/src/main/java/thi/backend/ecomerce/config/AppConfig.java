package thi.backend.ecomerce.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class AppConfig {

    @Bean
    // Cấu hình phiên -> Cấu hình xác thực request -> add filter -> Cấu hình crossorigin
    public SecurityFilterChain SecurityFillterChain(HttpSecurity httpSecurity) throws Exception {
        //IF_REQUIRED ( Mặc định ) : Spring security sẽ tự động tạo phiên đăng nhập
        //NEVER: Không tự động tạo phiên nhưng vẫn sử dụng nếu được tạo
        //STATELESS : Không tự động tạo cũng không sử dụng nếu có
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                //Các yêu cầu '/api/**' phải được xác thực còn các yêu cầu khác thì không
                .authorizeHttpRequests(Authorize -> Authorize.requestMatchers("/api/**").authenticated().anyRequest().permitAll())
                //Thêm bộ lọc Jwt vào trước bộ lọc thông tin cơ bản
                .addFilterBefore(new JwtValidator(), BasicAuthenticationFilter.class)
                .csrf().disable()
                //Cấu hình cross origin
                .cors().configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration cfg = new CorsConfiguration();
                cfg.setAllowedOrigins(Arrays.asList("http://localhost:3000/", "http://localhost:1999/"));
                cfg.setAllowedMethods(Collections.singletonList("*"));
                //Cho phép gửi cookie và thông tin xác thực qua CORS
                cfg.setAllowCredentials(true);
                cfg.setAllowedHeaders(Collections.singletonList("*"));
                //Xác định các header được hiển thị cho trình duyệt
                cfg.setExposedHeaders(Arrays.asList("Authorization"));
                cfg.setMaxAge(3600L);// Thời gian lưu trữ thông tin CORS trong bộ nhớ trình duyệt
                return cfg;
            }
        }).and().httpBasic().and().formLogin();//Cho phép xác thực cơ bản và đăng nhập bằng form
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
