import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class main extends Application {
	
	public static void main(String[] args) {
        launch(args);
    }
	public static Stage currentStage;
	public static Scene menuScene;
	
	
	@Override
    public void start(Stage primaryStage) throws Exception{
		currentStage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("final.fxml"));
        menuScene = new Scene(root);
        
        //AudioClip ac = new AudioClip("music.mp3");
        //ac.play();
        //ac.setCycleCount(1000);
        
        currentStage.setTitle("¦è¬v´Ñ");
        currentStage.setScene(menuScene);
        currentStage.show();
    }
}