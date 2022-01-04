package review;

import java.util.ArrayList;

import db.dto.ReviewDTO;

public interface IReviewDAO {
	public ArrayList<ReviewDTO> select();
	public void insertReview(ReviewDTO dto);
}
