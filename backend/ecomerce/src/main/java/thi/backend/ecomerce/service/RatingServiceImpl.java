package thi.backend.ecomerce.service;

import org.springframework.stereotype.Service;
import thi.backend.ecomerce.exception.CartItemException;
import thi.backend.ecomerce.exception.ProductException;
import thi.backend.ecomerce.exception.UserException;
import thi.backend.ecomerce.model.*;
import thi.backend.ecomerce.repository.RatingRepository;
import thi.backend.ecomerce.request.RatingRequest;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{

    private RatingRepository ratingRepository;
    private ProductService productService;

    public RatingServiceImpl(RatingRepository ratingRepository, ProductService productService) {
        this.ratingRepository = ratingRepository;
        this.productService = productService;
    }

    @Override
    public Rating createRating(RatingRequest req, User user) throws ProductException {
        Product product = productService.findProductById(req.getProductId());

        Rating rating = new Rating();
        rating.setUser(user);
        rating.setProduct(product);
        rating.setRating(req.getRating());
        rating.setCreatedAt(LocalDateTime.now());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getProductsRating(Long productId) {
        return ratingRepository.getAllProductsRating(productId);
    }
}
