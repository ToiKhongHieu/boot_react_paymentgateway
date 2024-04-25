package thi.backend.ecomerce.request;

public class ReviewRequest {

    private Long productId;
    private String review;

    public ReviewRequest(Long productId, String review) {
        this.productId = productId;
        this.review = review;
    }

    public ReviewRequest() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
