package review;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WriteReviewCtrl {
	private Parent form;
	private Stage stage;
	private String picPath;
	private IWriteReview iWriteReview;
	
	public WriteReviewCtrl() {
		iWriteReview = new WriteReviewImpl();
	}

	public void setForm(Stage stage, Parent form) {
		this.form = form;
		this.stage = stage;
	}

//	리뷰에 사진첨부
	public void attachPicture() {
		picPath = iWriteReview.attachPicture();
		
	}
	
	public void registReview() {
		System.out.println("등록");
	}
	
//	리뷰작성 취소
	public void cancelReview(){		
		iWriteReview.cancelReview(stage, form);
	}
}
