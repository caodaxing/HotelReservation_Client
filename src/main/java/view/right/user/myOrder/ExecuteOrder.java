package view.right.user.myOrder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
	
	TextField orderID ;
	TextField hotelName ; 
	TextField roomType ;
	TextField arriveTime ;
	TextField leaveTime ;
	TextField originalPrice ;
	TextField actualPrice ;
	
	Button arriveMessage ;
	Button leaveMessage ;
	
	Button checkEvaluation ;
	
	Button back ;
	
	public void start(Stage stage){
		
		//初始化左侧Pane
		leftPane = userUI.getPane() ;
		leftPane.setPrefSize ( DefaultNums.LEFT_WIDTH , DefaultNums.HEIGHT );
		
		//初始化右侧Pane
		rightPane = new AnchorPane();
		rightPane.setPrefSize( DefaultNums.RIGHT_WIDTH , DefaultNums.HEIGHT );
		
		//初始化textField
		orderID = new TextField("订单ID");
		hotelName = new TextField("酒店名称");
		roomType = new TextField("房间类型");
		arriveTime = new TextField("入住时间");
		leaveTime = new TextField("退房时间");
		originalPrice = new TextField("原始价格");
		actualPrice = new TextField("实际价格");
		
		//设置textField可操作性
		orderID.setEditable(false);
		hotelName.setEditable(false);
		roomType.setEditable(false);
		arriveTime.setEditable(false);
		leaveTime.setEditable(false);
		originalPrice.setEditable(false);
		actualPrice.setEditable(false);
		
		//设置textField大小
		orderID.setPrefSize(200, 30);
		hotelName.setPrefSize(200, 30);
		roomType.setPrefSize(200, 30);
		arriveTime.setPrefSize(200, 30);
		leaveTime.setPrefSize(200, 30);
		originalPrice.setPrefSize(200, 30);
		actualPrice.setPrefSize(200, 30);
		
		//初始化Button
		arriveMessage = new Button();
		leaveMessage = new Button();
		checkEvaluation = new Button();
		back = new Button();
		
		//设置Button文字
		arriveMessage.setText("入住信息");
		leaveMessage.setText("退房信息");
		checkEvaluation.setText("查看评论");
		back.setText("返回");
		
		//设置Button大小
		arriveMessage.setPrefSize(100, 40);
		leaveMessage.setPrefSize(100, 40);
		checkEvaluation.setPrefSize(100, 40);
		back.setPrefSize(100, 40);
		
		//右侧pane添加组件
		rightPane.getChildren().add(orderID);
		rightPane.getChildren().add(hotelName);
		rightPane.getChildren().add(roomType);
		rightPane.getChildren().add(arriveTime);
		rightPane.getChildren().add(leaveTime);
		rightPane.getChildren().add(originalPrice);
		rightPane.getChildren().add(actualPrice);
		
		rightPane.getChildren().add(arriveMessage);
		rightPane.getChildren().add(leaveMessage);
		rightPane.getChildren().add(checkEvaluation);
		rightPane.getChildren().add(back);
		
		//右侧Pane设置位置
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
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args){
		Application.launch(ExecuteOrder.class,args);
	}

}
