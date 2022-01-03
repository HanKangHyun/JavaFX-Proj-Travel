package review;

import java.util.ArrayList;

import db.dto.ReviewDTO;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public interface IReview {
	public ArrayList<ReviewDTO> LoadRecentReview();
	public void moveReview(Stage stage, Parent form);
	public void moveWriteReview(Stage stage, Parent form);
	public void initial(Stage stage, Parent form, ArrayList<ReviewDTO> list, VBox vb);
}
