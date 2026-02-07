package demo.conart.model.dao.review;

import demo.conart.model.entity.Review;

import java.util.List;

public interface ReviewDao {

    void addReview(Review review);
    void updateReview(Review review);
    void deleteReview(Review review);
    List<Review> getReviews();
    Review getReview(int id);

}
