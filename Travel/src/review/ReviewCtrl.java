package review;

import java.net.URL;
import java.util.ResourceBundle;

import db.dao.ReviewDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReviewCtrl implements Initializable{
	private Parent form;
	@FXML private Text reviewTitle;
	ReviewDAO reviewDAO = ReviewDAO.getInstance();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//여기에 리뷰리스트 뿌리기
		String name = reviewDAO.select();
		reviewTitle.setText(name);
	}
	
	public void setForm(Stage primartStage, Parent form) {
		this.form = form;
	}

	public void hoverReview() {
		//System.out.println("hover333");
	}
	
	public void MoveReview() {
		System.out.println("Move333");
	}
	
	public void Move() {
		System.out.println("PaneClick");
		
		String name = reviewDAO.select();
		reviewTitle.setText(name);
	}

}
