package thi.backend.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thi.backend.ecomerce.exception.ProductException;
import thi.backend.ecomerce.exception.UserException;
import thi.backend.ecomerce.model.Review;
import thi.backend.ecomerce.model.User;
import thi.backend.ecomerce.request.ReviewRequest;
import thi.backend.ecomerce.service.ReviewService;
import thi.backend.ecomerce.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class userController {

    @Autowired
    private UserService userService;

    @PostMapping("/profile")
    public ResponseEntity<User> getUserProfileHandler(@RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
