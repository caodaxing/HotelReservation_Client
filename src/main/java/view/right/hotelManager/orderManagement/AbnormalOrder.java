package view.right.hotelManager.orderManagement;

import java.util.ArrayList;

import Message.OrderListCondition;
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
import view.left.HotelManagerUI;
import viewController.HMOrderManagementController;
import viewController.HotelManagerLeftController;
import vo.OrderVO;

/**
 * 酒店工作人员界面_管理订单_异常订单详情
 * @author XueWang
 *
 */
public class AbnormalOrder{
	
	private HMOrderManagementController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	TextField orderID;
	TextField hotelName;
	TextField roomType;
	TextField lastExecuteTime;
	
	Button againRegister;
	Button revert;
	
	OrderVO orderVO;
	
	public AbnormalOrder(HMOrderManagementController controller){
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add("/CSS/right.css");
		
		//添加文本内容
		setTextField();
		
		//添加按钮
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.setStyle("-fx-background-image:url(\"/orderManagement/订单详情_异常订单背景.jpg\")");
		
	}

	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		//添加文本框
		orderID = new TextField();
		orderID.setId("AbnormalOrder");
		orderID.setPrefSize(200, 30);
		
		hotelName = new TextField();
		hotelName.setId("AbnormalOrder");
		hotelName.setPrefSize(200, 30);
		
		roomType = new TextField();
		roomType.setId("AbnormalOrder");
		roomType.setPrefSize(200, 30);
		
		lastExecuteTime = new TextField();
		lastExecuteTime.setId("AbnormalOrder");
		lastExecuteTime.setPrefSize(200, 30);
		
		//设置文本框内容
		
		//设置文本框内容不可更改
		orderID.setEditable(false);
		hotelName.setEditable(false);
		roomType.setEditable(false);
		lastExecuteTime.setEditable(false);
		
		//设置文本框位置
		orderID.setLayoutX(400);
		orderID.setLayoutY(150);
		
		hotelName.setLayoutX(400);
		hotelName.setLayoutY(200);
		
		roomType.setLayoutX(400);
		roomType.setLayoutY(250);
		
		lastExecuteTime.setLayoutX(400);
		lastExecuteTime.setLayoutY(300);
		
		//添加组件
		rightPane.getChildren().add(orderID);
		rightPane.getChildren().add(hotelName);
		rightPane.getChildren().add(roomType);
		rightPane.getChildren().add(lastExecuteTime);
		
		AnchorPane.setLeftAnchor(orderID, 200.0);
		AnchorPane.setLeftAnchor(hotelName, 200.0);
		AnchorPane.setLeftAnchor(roomType, 200.0);
		AnchorPane.setLeftAnchor(lastExecuteTime, 200.0);
		
		AnchorPane.setTopAnchor(orderID, 150.0);
		AnchorPane.setTopAnchor(hotelName, 200.0);
		AnchorPane.setTopAnchor(roomType, 250.0);
		AnchorPane.setTopAnchor(lastExecuteTime, 300.0);
		
	}
	
	private void setButton(){
		
		//添加按钮
		againRegister = new Button("补登记订单");
		againRegister.setId("button-css");
		againRegister.setPrefSize(100, 40);
		
		revert = new Button("返回");
		revert.setId("button-css");
		revert.setPrefSize(100, 40);
				
		//设置按钮位置
		againRegister.setLayoutX(450);
		againRegister.setLayoutY(525);
		
		revert.setLayoutX(625);
		revert.setLayoutY(525);
		
		
		
		//添加按钮监听
		againRegister.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				controller.setAbnormalOrderListView();
				controller.setOrderId(null);
				controller.getStage().show();
			}
			
		});
		
		//添加组件
		rightPane.getChildren().add(againRegister);
		rightPane.getChildren().add(revert);
		
		AnchorPane.setLeftAnchor(againRegister, 250.0);
		AnchorPane.setLeftAnchor(revert, 425.0);
		
		AnchorPane.setTopAnchor(againRegister, 525.0);
		AnchorPane.setTopAnchor(revert, 525.0);
		
	}
	
	public void setBlank(){
		orderID.setText("");
		hotelName.setText("");
		roomType.setText("");
		lastExecuteTime.setText("");
	}
	
	public void setText(){
		
		OrderVO vo = controller.getOrderInfo();
		orderID.setText(vo.orderId);
		hotelName.setText(vo.hotelID);
		roomType.setText(MessageHelper.roomTypeToString(vo.roomType));
		lastExecuteTime.setText(vo.abnormalTime);
	}
}
