package thi.backend.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thi.backend.ecomerce.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
