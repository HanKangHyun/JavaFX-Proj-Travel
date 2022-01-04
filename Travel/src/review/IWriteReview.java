package review;

import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public interface IWriteReview {
	public void cancelReview(Stage stage, Parent form);
	public void attachPicture(TextArea txtArea);
	public void registReview(TextField reviewTitle, TextField reviewContent, TextField reviewSummary, TextArea txtArea);
	public void pageBack(Stage stage, Parent form);
}
