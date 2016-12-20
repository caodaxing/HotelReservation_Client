package view.right.user.myOrder;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.helpTools.MessageHelper;
import view.left.UserUI;
import viewController.UserMyOrderController;
import vo.OrderVO;

/**
 * 客户界面_我的订单_已执行订单详情
 * @author XueWang
 *
 */
public class ExecuteOrder {
	
	private UserMyOrderController controller;
	
	private Scene scene ;
	
	private UserUI userUI;	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	TextField orderID ;
	TextField hotelName ; 
	TextField roomType ;
	TextField arriveTime ;
	TextField leaveTime ;
	TextField originalPrice ;
	TextField actualPrice ;
	
	Button checkEvaluation ;
	
	Button back ;
	
	public ExecuteOrder(UserMyOrderController controller){
		
		this.controller = controller;
		
		userUI = new UserUI(controller);
		
		// 初始化左侧Pane
		leftPane = userUI.getPane() ;
		leftPane.setPrefSize ( DefaultNums.LEFT_WIDTH , DefaultNums.HEIGHT );
		
		//初始化右侧Pane
		rightPane = new AnchorPane();
		rightPane.setPrefSize( DefaultNums.RIGHT_WIDTH , DefaultNums.HEIGHT );
		
		//设置TextField
		setTextField();
		
		//设置Button
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		
		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/orderManagement/订单详情_已执行订单背景.jpg\")");
		
	}
	
	private void setTextField(){
		
		//初始化textField
		orderID = new TextField();
		hotelName = new TextField();
		roomType = new TextField();
		arriveTime = new TextField();
		leaveTime = new TextField();
		originalPrice = new TextField();
		actualPrice = new TextField();
		
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
		
		//右侧pane添加组件
		rightPane.getChildren().add(orderID);
		rightPane.getChildren().add(hotelName);
		rightPane.getChildren().add(roomType);
		rightPane.getChildren().add(arriveTime);
		rightPane.getChildren().add(leaveTime);
		rightPane.getChildren().add(originalPrice);
		rightPane.getChildren().add(actualPrice);
		
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
		
	}
	
	private void setButton(){
		
		//初始化Button
		checkEvaluation = new Button();
		back = new Button();
		
		//设置Button文字
		checkEvaluation.setText("查看评价");
		back.setText("返回");
				
		//设置Button大小
		checkEvaluation.setPrefSize(100, 40);
		back.setPrefSize(100, 40);
		
		//添加listener
		
		checkEvaluation.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.whetherEvaluateAndSetView();
				controller.getStage().show();
			}
			
		});
		back.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//返回已执行订单列表
				controller.setExecuteOrderList();
				controller.setOrderID(null);
				controller.getStage().show();
			}
			
		});
		
		//添加Button组件
		rightPane.getChildren().add(checkEvaluation);
		rightPane.getChildren().add(back);
		
		//设置Button位置
		AnchorPane.setLeftAnchor(checkEvaluation, 250.0);
		AnchorPane.setTopAnchor(checkEvaluation, 525.0);
		
		AnchorPane.setLeftAnchor(back, 425.0);
		AnchorPane.setTopAnchor(back, 525.0);
				
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
	public void setBlank(){
	
		orderID.setText("");
		hotelName.setText("");
		roomType.setText("");
		arriveTime.setText("");
		leaveTime.setText("");
		originalPrice.setText("");
		actualPrice.setText("");
		
	}
	
	public void setText(){
		OrderVO vo = controller.getOrderInfo();
		orderID.setText(vo.orderId);
		hotelName.setText(vo.hotelID);
		roomType.setText(MessageHelper.roomTypeToString(vo.roomType));
		arriveTime.setText(vo .checkInTime);
		leaveTime.setText(vo.endTime);
		originalPrice.setText(Double.toString(vo.beforePrice));
		actualPrice.setText(Double.toString(vo.afterPrice));
	}
	
}
