package Homepage;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
		Parent root = (Parent)loader.load();
		Scene scene = new Scene(root);

		primaryStage.setTitle("Travel");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		HomeController ctrler = loader.getController();
		ctrler.setForm(root);
		 
	}

}
     