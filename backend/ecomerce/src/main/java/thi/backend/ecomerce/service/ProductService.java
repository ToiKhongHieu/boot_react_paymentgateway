package thi.backend.ecomerce.service;

import org.springframework.data.domain.Page;
import thi.backend.ecomerce.exception.ProductException;
import thi.backend.ecomerce.model.Product;
import thi.backend.ecomerce.request.CreateProductRequest;

import java.util.List;

public interface ProductService {
    public Product createProduct(CreateProductRequest req);

    public List<Product> findAllProducts();

    public String deleteProduct(Long productId) throws ProductException;

    public Product updateProduct(Long productId, Product req) throws ProductException;

    public Product findProductById(Long id) throws ProductException;

    public List<Product> findProductByCategory(String category);

    public Page<Product> getAllProduct(String category, List<String> colors, List<String> sizes, Integer minPrice, Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber, Integer pageSize);


}
