package thi.backend.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thi.backend.ecomerce.exception.OrderException;
import thi.backend.ecomerce.model.Address;
import thi.backend.ecomerce.model.Order;
import thi.backend.ecomerce.model.OrderItem;
import thi.backend.ecomerce.model.User;
import thi.backend.ecomerce.repository.*;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRespository orderItemRespository;

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRespository.save(orderItem);
    }
}
