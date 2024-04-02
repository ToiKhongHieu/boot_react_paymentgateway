package thi.backend.ecomerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import thi.backend.ecomerce.exception.ProductException;
import thi.backend.ecomerce.model.Category;
import thi.backend.ecomerce.model.Product;
import thi.backend.ecomerce.repository.CategoryRespository;
import thi.backend.ecomerce.repository.ProductRepository;
import thi.backend.ecomerce.request.CreateProductRequest;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRespository categoryRespository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRespository categoryRespository) {
        this.productRepository = productRepository;
        this.categoryRespository = categoryRespository;
    }

    @Override
    public Product createProduct(CreateProductRequest req) {

        Category topLevel = categoryRespository.findByName(req.getTopLavelCategory());

        if (topLevel == null) {
            Category topLavelCategory = new Category();
            topLavelCategory.setName(req.getTopLavelCategory());
            topLavelCategory.setLevel(1);

            topLevel = categoryRespository.save(topLavelCategory);
        }

        Category secondLevel = categoryRespository.findByNameAndParent(req.getSecondLavelCategory(), topLevel.getName());
        if (secondLevel == null) {
            Category seconLevelCategory = new Category();
            seconLevelCategory.setName(req.getSecondLavelCategory());
            seconLevelCategory.setParentCategory(topLevel);
            seconLevelCategory.setLevel(2);

            secondLevel = categoryRespository.save(seconLevelCategory);
        }

        Category thirdLevel = categoryRespository.findByNameAndParent(req.getThirdLavelCategory(), secondLevel.getName());
        if (thirdLevel == null) {
            Category thirdLevelCategory = new Category();
            thirdLevelCategory.setName(req.getThirdLavelCategory());
            thirdLevelCategory.setParentCategory(secondLevel);
            thirdLevelCategory.setLevel(3);

            thirdLevel = categoryRespository.save(thirdLevelCategory);
        }

        Product product = new Product();
        product.setTitle(req.getTitle());
        product.setColor(req.getColor());
        product.setDescription(req.getDescription());
        product.setDiscountPersent(req.getDiscountPersent());
        product.setImageUrl(req.getImageUrl());
        product.setBrand(req.getBrand());
        product.setPrice(req.getPrice());
        product.setSizes(req.getSize());
        product.setQuantity(req.getQuantity());
        product.setCategory(thirdLevel);
        product.setCreatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    @Override
    public String deleteProduct(Long productId) throws ProductException {
        Product product = findProductById(productId);
        product.getSizes().clear();
        productRepository.delete(product);
        return "Product deleted Successfully";
    }

    @Override
    public Product updateProduct(Long productId, Product req) throws ProductException {
        Product product = findProductById(productId);

        if (req.getQuantity() != 0) {
            product.setQuantity(req.getQuantity());
        }
        return productRepository.save(product);
    }

    @Override
    public Product findProductById(Long id) throws ProductException {
        Optional<Product> opt = productRepository.findById(id);

        if (opt.isPresent()) {
            return opt.get();
        }
        throw new ProductException("Product not found with id - " + id);
    }

    @Override
    public List<Product> findProductByCategory(String category) {
        return null;
    }

    @Override
    public Page<Product> getAllProduct(String category, List<String> colors, List<String> sizes, Integer minPrice, Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        List<Product> products = productRepository.filterProducts(category, minPrice, maxPrice, minDiscount, sort);

        if (!colors.isEmpty()) {
            products = products.stream().filter(p -> colors.stream().anyMatch(c -> c.equalsIgnoreCase(p.getColor())))
                    .collect(Collectors.toList());
        }
        if (stock != null) {
            if (stock.equals("in_stock")) {
                products = products.stream().filter(p -> p.getQuantity() > 0).collect(Collectors.toList());
            } else if (stock.equals("out_of_stock")) {
                products = products.stream().filter(p -> p.getQuantity() < 1).collect(Collectors.toList());
            }
        }

        int startIndex = (int) pageable.getOffset();
        int endIndex = Math.min(startIndex + pageable.getPageSize() , products.size());
        List<Product> pageContent = products.subList(startIndex,endIndex);

        Page<Product> filteredProducts = new PageImpl<>(pageContent,pageable,products.size());
        return filteredProducts;
    }
}
