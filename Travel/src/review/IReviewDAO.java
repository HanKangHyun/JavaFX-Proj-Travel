package review;

import java.util.ArrayList;

import db.dto.ReviewDTO;

public interface IReviewDAO {
	//public ReviewDAO getInstance();
	public ArrayList<ReviewDTO> select();
}
