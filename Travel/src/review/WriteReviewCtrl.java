package review;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WriteReviewCtrl {
	private Parent form;
	private Stage stage;
	private IWriteReview iWriteReview;
	@FXML private TextField reviewTitle;
	@FXML private TextField reviewContent;
	@FXML private TextField reviewSummary;
	@FXML private TextArea txtArea;
	
	public WriteReviewCtrl() {
		iWriteReview = new WriteReviewImpl();
	}

	public void setForm(Stage stage, Parent form) {
		this.form = form;
		this.stage = stage;
	}

//	리뷰에 사진첨부
	public void attachPicture() {
		iWriteReview.attachPicture(txtArea);
	}
	
//	리뷰등록
	public void registReview() {
		iWriteReview.registReview(reviewTitle, reviewContent, reviewSummary, txtArea);
		iWriteReview.pageBack(stage, form);
	}
	
//	리뷰작성 취소
	public void cancelReview(){		
		iWriteReview.cancelReview(stage, form);
	}
}
