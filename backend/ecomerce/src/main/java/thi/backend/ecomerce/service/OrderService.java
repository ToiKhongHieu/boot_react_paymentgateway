package thi.backend.ecomerce.service;

import thi.backend.ecomerce.exception.OrderException;
import thi.backend.ecomerce.model.Address;
import thi.backend.ecomerce.model.Order;
import thi.backend.ecomerce.model.User;

import java.util.List;

public interface OrderService {

    public Order createOrder(User user, Address shippingAddress);

    public Order findOrderById(Long orderId) throws OrderException;

    public List<Order> usersOrderHistory(Long orderId);

    public Order placedOrder(Long orderId) throws OrderException;

    public Order confirmedOrder(Long orderId) throws OrderException;

    public Order shippedOrder(Long orderId) throws OrderException;

    public Order deliveredOrder(Long orderId) throws OrderException;

    public Order canceledOrder(Long orderId) throws OrderException;

    public List<Order> getAllOrder();

    public Order deleteOrder(Long orderId) throws OrderException;
}
