package view.left;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * 客户的左侧导航栏
 * @author XueWang
 *
 */
public class UserUI extends Application{
	
	public void refreshLeft(){
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Rookie Travel");
		primaryStage.show();
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.BASELINE_LEFT);
		grid.setVgap(10);
		Scene scene = new Scene(grid, 800, 600);
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
