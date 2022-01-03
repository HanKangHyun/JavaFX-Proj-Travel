package review;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import db.dao.ReviewDAO;
import db.dto.ReviewDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReviewCtrl implements Initializable{
	private Parent form;
	private Stage stage;
	private IReview iReview;
	@FXML private VBox vb;

	public ReviewCtrl() {
		iReview = new ReviewImpl();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<ReviewDTO> list = iReview.LoadRecentReview();
		
		iReview.initial(stage, form, list, vb);
	}
	
	public void setForm(Stage stage, Parent form) {
		this.form = form;
		this.stage = stage;
	}

//	리뷰 화면으로
	public void MoveReview() {
		iReview.moveReview(stage, form);
	}
	
//	리뷰작성으로
	public void MoveWriteReview() {
		iReview.moveWriteReview(stage, form);
	}
	
	
}
