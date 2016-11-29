package view.right.user.myOrder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import view.helpTools.DefaultNums;
import view.left.UserUI;

/**
 * 客户界面_我的订单_已执行订单详情
 * @author XueWang
 *
 */
public class ExecuteOrder extends Application {
	
	private Scene scene ;
	
	private UserUI userUI = new UserUI();	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	Label orderID ;
	Label hotelName ; 
	Label roomType ;
	Label arriveTime ;
	Label leaveTime ;
	Label originalPrice ;
	Label actualPrice ;
	
	Button arriveMessage ;
	Button leaveMessage ;
	
	Button checkEvaluation ;
	
	Button back ;
	
	public void start(Stage stage){
		
		leftPane = userUI.getPane() ;
		leftPane.setPrefSize ( DefaultNums.LEFT_WIDTH , DefaultNums.HEIGHT );
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize( DefaultNums.RIGHT_WIDTH , DefaultNums.HEIGHT );
		
		//设置label大小
		orderID.setPrefSize(200, 30);
		hotelName.setPrefSize(200, 30);
		roomType.setPrefSize(200, 30);
		arriveTime.setPrefSize(200, 30);
		leaveTime.setPrefSize(200, 30);
		originalPrice.setPrefSize(200, 30);
		actualPrice.setPrefSize(200, 30);
		
		/*
		//设置label X
		orderID.setLayoutX(200);
		hotelName.setLayoutX(200);
		roomType.setLayoutX(200);
		arriveTime.setLayoutX(200);
		leaveTime.setLayoutX(200);
		originalPrice.setLayoutX(200);
		actualPrice.setLayoutX(200);
		
		//设置label Y
		orderID.setLayoutY(150);
		hotelName.setLayoutY(200);
		roomType.setLayoutY(250);
		arriveTime.setLayoutY(300);
		leaveTime.setLayoutY(350);
		originalPrice.setLayoutY(400);
		actualPrice.setLayoutY(450);
		*/
		
		//设置Button大小
		arriveMessage.setPrefSize(100, 40);
		leaveMessage.setPrefSize(100, 40);
		checkEvaluation.setPrefSize(100, 40);
		back.setPrefSize(100, 40);
		
		/*
		//设置Button位置
		arriveMessage.setLayoutX(425);
		arriveMessage.setLayoutY(400);
		
		leaveMessage.setLayoutX(425);
		leaveMessage.setLayoutY(450);
		
		checkEvaluation.setLayoutX(250);
		checkEvaluation.setLayoutY(525);
		
		back.setLayoutX(425);
		back.setLayoutY(525);
		*/
		
		//右侧Pane添加组件
		AnchorPane.setLeftAnchor(orderID, 200.0);
		AnchorPane.setLeftAnchor(hotelName, 200.0);
		AnchorPane.setLeftAnchor(roomType, 200.0);
		AnchorPane.setLeftAnchor(arriveTime, 200.0);
		AnchorPane.setLeftAnchor(leaveTime, 200.0);
		AnchorPane.setLeftAnchor(originalPrice, 200.0);
		AnchorPane.setLeftAnchor(actualPrice, 200.0);
		
		AnchorPane.setTopAnchor(orderID, 150.0);
		AnchorPane.setTopAnchor(hotelName, 200.0);
		AnchorPane.setTopAnchor(roomType, 250.0);
		AnchorPane.setTopAnchor(arriveTime, 300.0);
		AnchorPane.setTopAnchor(leaveTime, 350.0);
		AnchorPane.setTopAnchor(originalPrice, 400.0);
		AnchorPane.setTopAnchor(actualPrice, 450.0);
		
		AnchorPane.setLeftAnchor(arriveMessage, 425.0);
		AnchorPane.setTopAnchor(arriveMessage, 400.0);
		AnchorPane.setLeftAnchor(leaveMessage, 425.0);
		AnchorPane.setTopAnchor(leaveMessage, 450.0);
		
		AnchorPane.setLeftAnchor(checkEvaluation, 250.0);
		AnchorPane.setTopAnchor(checkEvaluation, 525.0);
		
		AnchorPane.setLeftAnchor(back, 425.0);
		AnchorPane.setTopAnchor(back, 525.0);
		
		HBox root = new HBox(leftPane , rightPane);
		HBox.setHgrow(leftPane , Priority.ALWAYS);
		scene.setRoot(root);
		stage.setScene(scene);
		stage.show();
		
	}

}
