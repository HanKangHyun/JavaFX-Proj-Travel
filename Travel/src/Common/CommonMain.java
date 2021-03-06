package Common;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommonMain extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("header.fxml"));
		Parent root = (Parent)loader.load();
		Scene scene = new Scene(root);

		primaryStage.setTitle("header");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		PageController ctrler = loader.getController();
		ctrler.setForm(root);
		
	}

}
