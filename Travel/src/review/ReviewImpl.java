package review;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import db.dto.ReviewDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReviewImpl implements IReview{
	private IReviewDAO iReviewDAO;

	public ReviewImpl() {
		iReviewDAO = new ReviewDAOImpl();
	}
	@Override
	public ArrayList<ReviewDTO> LoadRecentReview() {
		ArrayList<ReviewDTO> list = iReviewDAO.select();
		
		return list;
	}
	
	@Override
	public void moveWriteReview(Stage stage, Parent form) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("writeReview.fxml"));
			form = (Parent) loader.load();
			Scene sc = new Scene(form);
			
			stage.setTitle("리뷰 작성");
			stage.setScene(sc);
			stage.show();
			
			WriteReviewCtrl ctrler = loader.getController();
			ctrler.setForm(stage, form);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void moveReview(Stage stage, Parent form) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Review.fxml"));
			form = (Parent) loader.load();
			Scene sc = new Scene(form);
			
			stage.setTitle("리뷰");
			stage.setScene(sc);
			stage.show();
			
			ReviewCtrl ctrler = loader.getController();
			ctrler.setForm(stage, form);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void initial(Stage stage, Parent form, ArrayList<ReviewDTO> list, VBox vb) {
		for(ReviewDTO dto : list) {
			String review_name = dto.getReview_name();
			String review_content = dto.getReview_content();
			String review_summary = dto.getReview_summary();
			String review_image = dto.getReview_image();
			
			Label label = new Label(review_name);
			Label label2 = new Label(review_content);
			Label label3 = new Label(review_summary);
			
			// 4개이상은 페이지넘김 처리
			//review_image -> null처리 해야함
			File file = new File(review_image);
			Image image1 = new Image(file.toURI().toString());
			ImageView imgView = new ImageView(image1);
			imgView.setFitWidth(80);
			imgView.setFitHeight(80);
			
			HBox hb = new HBox();
			hb.setMargin(label, new Insets(10));
			hb.setMargin(label2, new Insets(10));
			hb.setMargin(label3, new Insets(10));
			hb.setMargin(imgView, new Insets(10));
			hb.getChildren().addAll(label, label2, imgView, label3);
			
			vb.getChildren().add(hb);
		}
	}

}
