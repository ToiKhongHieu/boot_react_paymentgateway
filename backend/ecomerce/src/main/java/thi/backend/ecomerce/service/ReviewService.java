package thi.backend.ecomerce.service;

import thi.backend.ecomerce.exception.ProductException;
import thi.backend.ecomerce.model.Review;
import thi.backend.ecomerce.model.User;
import thi.backend.ecomerce.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    public Review createReview(ReviewRequest req, User user) throws ProductException;
    public List<Review> getAllReview(Long productId);
}
