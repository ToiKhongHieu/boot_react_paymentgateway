package thi.backend.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import thi.backend.ecomerce.model.Product;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p" +
    "WHERE (p.category.name = :category OR :category='')" +
    "AND ((:minPrice IS NULL AND :maxPrice IS NULL OR (p.discountedPrice BETWEEN :minPrice AND :maxPrice))" +
            "AND (:minDiscount IS NULL OR p.discountPersent >= :minDiscount)" +
            "ORDER BY" +
            "CASE WHEN :sort = 'price_low' THEN p.discountedPrice ASC"+
            "          :sort = 'price_high' THEN p.discountedPrice DESC END;"
    )
    public List<Product> filterProducts(@Param("category") String category ,@Param("minPrice") Integer minPrice
    ,@Param("maxPrice") Integer maxPrice,@Param("minDiscount") Integer minDiscount,@Param("sort") Integer sort);
}
