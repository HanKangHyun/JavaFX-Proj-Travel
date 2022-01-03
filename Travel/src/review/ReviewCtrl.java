package review;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import db.dao.ReviewDAO;
import db.dto.ReviewDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReviewCtrl implements Initializable{
	private Parent form;
	private ReviewDAO reviewDAO = ReviewDAO.getInstance();
	@FXML private VBox vb;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<ReviewDTO> list = reviewDAO.select();
		
		for(ReviewDTO dto : list) {
			String review_name = dto.getReview_name();
			String review_content = dto.getReview_content();
			String review_summary = dto.getReview_summary();
			String review_image = dto.getReview_image();
			
			Label label = new Label(review_name);
			Label label2 = new Label(review_content);
			Label label3 = new Label(review_summary);
			
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
		
		//String name = reviewDAO.select();
		//reviewTitle.setText(name);
	}

}
