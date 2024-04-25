package thi.backend.ecomerce.service;

import org.springframework.stereotype.Service;
import thi.backend.ecomerce.exception.ProductException;
import thi.backend.ecomerce.model.Product;
import thi.backend.ecomerce.model.Review;
import thi.backend.ecomerce.model.User;
import thi.backend.ecomerce.repository.ProductRepository;
import thi.backend.ecomerce.repository.ReviewRepository;
import thi.backend.ecomerce.request.ReviewRequest;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReivewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private ProductService productService;
    private ProductRepository productRepository;

    public ReivewServiceImpl(ReviewRepository reviewRepository, ProductService productService, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @Override
    public Review createReview(ReviewRequest req, User user) throws ProductException {
        Product product = productService.findProductById(req.getProductId());

        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReview(req.getReview());
        review.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReview(Long productId) {
        return reviewRepository.getAllProductsReview(productId);
    }
}
