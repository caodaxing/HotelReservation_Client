package view.left;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.helpTools.DefaultNums;

/**
 * 游客左侧导航栏
 * @author XueWang
 *
 */
public class VistorUI extends Application{

	public void refreshLeft(){
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.BASELINE_LEFT);
		grid.setVgap(DefaultNums.GAP_HEIGHT);
		
		Pane pane = new GridPane();
		Image image = new Image("Image\\index1.jpg", 200, 180, false, true);
		ImageView headImage = new ImageView(image);
		pane.getChildren().add(headImage);
		grid.add(pane, 0, 0);
		
		Button signIn = new Button("登 录");
		signIn.setId("light-button");
		signIn.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(signIn, 0, 1);
		
		Button signUp = new Button("注 册");
		signUp.setId("light-button");
		signUp.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(signUp, 0, 2);
		
		Scene scene = new Scene(grid, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("left.css").toExternalForm());
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
