package view.right.hotelManager.orderManagement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import view.helpTools.DefaultNums;
import view.left.HotelManagerUI;

/**
 * 酒店工作人员界面_管理订单_查询订单界面
 * @author XueWang
 *
 */
public class SearchOrder{

	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hotelmanagerui = new HotelManagerUI();
	
	Button inquiry;
	
	TextField orderID;
	public void start(Stage primaryStage){
		
		primaryStage.setTitle("Rookie Travel");
		
		leftPane = hotelmanagerui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加按钮
		inquiry = new Button("查询");
		inquiry.setId("searchOrder");
		inquiry.setPrefSize(100, 30);
		
		//添加文本框
		orderID = new TextField();
		orderID.setId("searchOrder");
		orderID.setPrefSize(200, 30);
		
		//设置按钮,文本框位置
		inquiry.setLayoutX(550);
		inquiry.setLayoutY(250);
		
		orderID.setLayoutX(300);
		orderID.setLayoutY(250);
		
		//添加组件
		rightPane.getChildren().add(inquiry);
		rightPane.getChildren().add(orderID);
		
		AnchorPane.setLeftAnchor(inquiry, 350.0);
		AnchorPane.setLeftAnchor(orderID, 100.0);
		
		AnchorPane.setTopAnchor(inquiry, 250.0);
		AnchorPane.setTopAnchor(orderID, 250.0);
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
