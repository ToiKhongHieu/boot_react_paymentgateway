package thi.backend.ecomerce.service;

import thi.backend.ecomerce.exception.CartItemException;
import thi.backend.ecomerce.exception.UserException;
import thi.backend.ecomerce.model.Cart;
import thi.backend.ecomerce.model.CartItem;
import thi.backend.ecomerce.model.Product;

public interface CartItemService {

    public CartItem createCartItem(CartItem cartItem);

    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;

    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);

    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;

    public CartItem findCartItemById(Long CartItemId) throws CartItemException;
}
