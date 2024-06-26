package thi.backend.ecomerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thi.backend.ecomerce.config.JwtProvider;
import thi.backend.ecomerce.exception.UserException;
import thi.backend.ecomerce.model.Cart;
import thi.backend.ecomerce.model.User;
import thi.backend.ecomerce.repository.UserRepository;
import thi.backend.ecomerce.request.LoginRequest;
import thi.backend.ecomerce.response.AuthResponse;
import thi.backend.ecomerce.service.CartService;
import thi.backend.ecomerce.service.CustomeUserServieceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserRepository userRepository;
    private JwtProvider jwtProvider;
    private PasswordEncoder passwordEncoder;
    private CustomeUserServieceImpl customeUserServiece;
    private CartService cartService;

    public AuthController(UserRepository userRepository, JwtProvider jwtProvider, PasswordEncoder passwordEncoder, CustomeUserServieceImpl customeUserServiece, CartService cartService) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.customeUserServiece = customeUserServiece;
        this.cartService = cartService;
    }

    //Lấy thông tin -> Check trùng -> Tạo authentication -> Add vào contextHolder để quản lý -> tạo AuthResponse(jwt,msg) để trả về
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {
        String email = user.getEmail();
        String password = user.getPassWord();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        User isEmailExist = userRepository.findByEmail(email);

        if (isEmailExist != null) {
            throw new UserException("Email is Already Used With Another Account");
        }

        User createdUser = new User();
        createdUser.setEmail(email);
        createdUser.setPassWord(passwordEncoder.encode(password));
        createdUser.setFirstName(firstName);
        createdUser.setFirstName(lastName);

        User savedUser = userRepository.save(createdUser);
        Cart cart = cartService.createCart(savedUser);

        // Tạo một đối tượng xác thực với thông tin người dùng đã lưu.
        Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassWord());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Tạo JWT dựa trên thông tin xác thực.
        String token = jwtProvider.generateToken(authentication);

        // Tạo đối tượng phản hồi chứa JWT và thông điệp thành công.
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("Signup Success");

        // Trả về phản hồi với JWT và trạng thái HTTP là CREATED.
        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String passWord = loginRequest.getPassWord();

        Authentication authentication = authenticate(email, passWord);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("Signup Success");
        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
    }

    private Authentication authenticate(String email, String passWord) {
        UserDetails userDetails = customeUserServiece.loadUserByUsername(email);
        if (userDetails == null) {
            throw new BadCredentialsException("Invalid Username...");
        }
        if (!passwordEncoder.matches(passWord, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid Password...");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}
