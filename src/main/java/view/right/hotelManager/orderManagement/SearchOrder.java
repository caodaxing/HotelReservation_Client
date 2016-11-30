package view.right.hotelManager.orderManagement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import view.helpTools.DefaultNums;
import view.left.HotelManagerUI;

/**
 * 酒店工作人员界面_管理订单_查询订单界面
 * @author XueWang
 *
 */
public class SearchOrder extends Application{

	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hotelmanagerui = new HotelManagerUI();
	
	Button inquiry;
	public void start(Stage primaryStage){
		
		primaryStage.setTitle("Rookie Travel");
		
		leftPane = hotelmanagerui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加按钮
		
		HBox root = new HBox(leftPane, rightPane);
		HBox.setHgrow(leftPane, Priority.ALWAYS);
		scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
