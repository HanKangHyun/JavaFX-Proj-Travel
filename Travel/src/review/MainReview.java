package review;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainReview extends Application{

	public static void main(String[] args){
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primartStage) throws Exception {
		//FXMLLoader loader = new FXMLLoader(getClass().getResource("Review.fxml"));
		FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
		Parent root = (Parent)loader.load();
		Scene sc = new Scene(root);
		
		primartStage.setTitle("11");
		primartStage.setScene(sc);
		primartStage.show();
		
		ctrl ctrler = loader.getController();
		ctrler.setForm(primartStage, root);
		
	}
}
