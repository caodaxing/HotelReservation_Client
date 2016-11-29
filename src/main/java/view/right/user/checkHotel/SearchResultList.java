package view.right.user.checkHotel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.helpTools.DefaultNums;
import view.left.UserUI;

/**
 * 客户界面_查看酒店_搜索结果列表
 * @author XueWang
 *
 */
public class SearchResultList extends Application{
	
	HBox root;
	Pane leftPane, rightPane;
	
	UserUI userui = new UserUI();
	
	public void start(Stage primaryStage){
		primaryStage.setTitle("Rookie Travel");
		leftPane = userui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		
		
		root = new HBox(leftPane, rightPane);
		Scene scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
}
