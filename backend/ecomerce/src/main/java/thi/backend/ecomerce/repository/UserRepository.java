package thi.backend.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thi.backend.ecomerce.model.User;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

    public User findByEmail(String email);
}
