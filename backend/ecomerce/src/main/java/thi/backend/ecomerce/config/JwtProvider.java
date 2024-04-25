package thi.backend.ecomerce.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtProvider {
    //Khóa bí mật giải mã jwt
    SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes()/*Sinh chuỗi ngẫu nhiên*/);

    public String generateToken(Authentication auth) {
        String jwt = Jwts.builder().setIssuedAt(new Date())//Thiết lập thời gian phát hành token
                .setExpiration(new Date(new Date().getTime() + 846000000))//thời hạn 15p
                .claim("email", auth.getName())//Thêm thông tin ng dùng vào token
                .signWith(key).compact();//Ký & mã hóa vs key

        return jwt;
    }

    public String getEmailFromToken(String jwt) {
        jwt = jwt.substring(7);

        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
        String email = String.valueOf(claims.get("email"));

        return email;
    }
}
