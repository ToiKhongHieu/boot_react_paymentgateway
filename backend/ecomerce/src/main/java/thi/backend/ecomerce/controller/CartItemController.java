package thi.backend.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thi.backend.ecomerce.exception.CartItemException;
import thi.backend.ecomerce.exception.ProductException;
import thi.backend.ecomerce.exception.UserException;
import thi.backend.ecomerce.model.Cart;
import thi.backend.ecomerce.model.User;
import thi.backend.ecomerce.request.AddItemRequest;
import thi.backend.ecomerce.response.ApiResponse;
import thi.backend.ecomerce.service.CartItemService;
import thi.backend.ecomerce.service.UserService;

@RestController
@RequestMapping("/api/cart_item")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UserService userService;

    @DeleteMapping("/{cartItemId}")
//    @io.swagger.annotations.responses.ApiResponse()
//    @Operation(description = "find cart by user id")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable Long cartItemId, @RequestHeader("Authorization") String jwt) throws UserException, CartItemException {
        User user = userService.findUserProfileByJwt(jwt);
        cartItemService.removeCartItem(user.getId(),cartItemId);

        ApiResponse res = new ApiResponse();
        res.setMessage("delete item from cart");
        res.setStatus(true);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
//
//    @PutMapping("/{cartItemId}")
//    public ResponseEntity<ApiResponse> updateItemInCart(@PathVariable Long cartItemId,
//                                                     @RequestHeader("Authorization") String jwt) throws UserException, CartItemException {
//        User user = userService.findUserProfileByJwt(jwt);
//
//        cartItemService.updateCartItem()
//
//        return new ResponseEntity<>(res, HttpStatus.OK);
//    }
}
