package thi.backend.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import thi.backend.ecomerce.model.Category;

public interface CategoryRespository extends JpaRepository<Category , Long> {
    public Category findByName(String name);

    @Query("SELECT c from Category c WHERE c.name = :name AND c.parentCategory.name = :parentCategoryName")
    public  Category findByNameAndParent(@Param("name") String name
            ,@Param("parentCategoryName") String parentCategoryName);
}
