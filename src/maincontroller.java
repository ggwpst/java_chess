
import Controller.PressedAction;
import Controller.ReleaseAction;
import Controller.ResetAction;
import view.ChessBoard;
import view.ChessPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class maincontroller{
	@FXML
	public Button exit;
	@FXML
	public Button start;
	@FXML
	public Text text;
	@FXML
	public ImageView imageview;
	

	@FXML
    private void color() throws Exception{
		exit.setStyle("-fx-background-color: orange;");
		exit.addEventHandler(MouseEvent.MOUSE_ENTERED,new EventHandler<MouseEvent>() {
			@Override
		    public void handle(MouseEvent e) {
				exit.setStyle("-fx-background-color: white;");
		    }
		});
		exit.addEventHandler(MouseEvent.MOUSE_EXITED,new EventHandler<MouseEvent>() {
			@Override
		    public void handle(MouseEvent e) {
				exit.setStyle("-fx-background-color: orange;");
		    }
		});
		start.setStyle("-fx-background-color: orange;");
		start.addEventHandler(MouseEvent.MOUSE_ENTERED,new EventHandler<MouseEvent>() {
			@Override
		    public void handle(MouseEvent e) {
				start.setStyle("-fx-background-color: white;");
		    }
		});
		start.addEventHandler(MouseEvent.MOUSE_EXITED,new EventHandler<MouseEvent>() {
			@Override
		    public void handle(MouseEvent e) {
				start.setStyle("-fx-background-color: orange;");
		    }
		});
		text.setFill(new LinearGradient(0, 0, 1, 2, true, CycleMethod.REPEAT, new
    	        Stop[]{new Stop(0, Color.AQUA), new Stop(0.5f, Color.RED)}));
		imageview.setStyle("-fx-background-color:FFFFFF;");
	}
	
    @FXML
	public void onStarPressed() throws Exception{
		ChessBoard chessBoard = ChessBoard.getInstance(100,40,40);
		
		ChessPane pane = new ChessPane(chessBoard);
	    
	    pane.setOnMouseReleased(new ReleaseAction(pane));
	    pane.setOnMousePressed(new PressedAction(pane));
	    
	    BorderPane borderPane = new BorderPane();
	    borderPane.setCenter(pane);
	    
	    HBox hBox = new HBox();
	    hBox.setAlignment(Pos.TOP_CENTER);

	    Button button = new Button("®¬´Ñ");
	    button.setOnAction(new ResetAction(pane));
	    //AudioClip ac = new AudioClip("music.mp3");
        //ac.play();
        //ac.setCycleCount(1000);
	    
	    hBox.getChildren().add(button);
	    borderPane.setBottom(hBox);
	    Stage primaryStage = new Stage();
	    Scene scene = new Scene(borderPane,900,900);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("¦è¬v´Ñ");
	    primaryStage.show();
	    
	}
	@FXML
	public void onExitPressed() {
		main.currentStage.close();
	}
}
