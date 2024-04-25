package thi.backend.ecomerce.service;

import thi.backend.ecomerce.exception.ProductException;
import thi.backend.ecomerce.model.Cart;
import thi.backend.ecomerce.model.User;
import thi.backend.ecomerce.request.AddItemRequest;

public interface CartService {

    public Cart createCart(User user);

    public String addCartItem(Long userId, AddItemRequest req) throws ProductException;

    public Cart findUserCart(Long userId);
}
