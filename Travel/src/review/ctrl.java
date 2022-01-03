package review;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ctrl {
	private Parent form;
	private Stage stage;

	public void setForm(Stage stage, Parent form) {
		this.form = form;
		this.stage = stage;
	}

	public void hoverReview() {
		//System.out.println("hover");
	}
	
	public void MoveReview() {
		System.out.println("Move");
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("review.fxml"));
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

}
