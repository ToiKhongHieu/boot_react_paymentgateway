package thi.backend.ecomerce.service;

import thi.backend.ecomerce.exception.ProductException;
import thi.backend.ecomerce.model.Rating;
import thi.backend.ecomerce.model.User;
import thi.backend.ecomerce.repository.RatingRepository;
import thi.backend.ecomerce.request.RatingRequest;

import java.util.List;

public interface RatingService {

    public Rating createRating(RatingRequest req, User user) throws ProductException;
    public List<Rating> getProductsRating(Long productId);
}
