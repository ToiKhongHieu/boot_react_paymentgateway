package thi.backend.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thi.backend.ecomerce.model.User;

public interface UserRepository extends JpaRepository<User , Long> {

    public User findByEmail(String email);
}
