package thi.backend.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thi.backend.ecomerce.model.OrderItem;

public interface OrderItemRespository extends JpaRepository<OrderItem , Long> {
}
