package db.dto;

public class ReviewDTO {
	private String review_name;
	private String review_content;
	private String review_summary;
	private String review_image;
	
	public ReviewDTO() {
		super();
	}
	public ReviewDTO(String review_name, String review_content, String review_summary, String review_image) {
		super();
		this.review_name = review_name;
		this.review_content = review_content;
		this.review_summary = review_summary;
		this.review_image = review_image;
	}
	public String getReview_name() {
		return review_name;
	}
	public void setReview_name(String review_name) {
		this.review_name = review_name;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public String getReview_summary() {
		return review_summary;
	}
	public void setReview_summary(String review_summary) {
		this.review_summary = review_summary;
	}
	public String getReview_image() {
		return review_image;
	}
	public void setReview_image(String review_image) {
		this.review_image = review_image;
	}
}
