package review;

import javafx.scene.Parent;
import javafx.stage.Stage;

public interface IWriteReview {
	public void cancelReview(Stage stage, Parent form);
	public String attachPicture();
}
