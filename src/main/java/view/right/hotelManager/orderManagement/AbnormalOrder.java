package view.right.hotelManager.orderManagement;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
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
	private HotelManagerLeftController hmcontroller;
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
	
	ArrayList<OrderVO> orderList;
	
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
		
	}

	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		controller.setOrderList();
		orderList = controller.getOrderList();
		int num = controller.getRow();
		
		//添加文本框
		orderID = new TextField(orderList.get(num).orderId);
		orderID.setId("AbnormalOrder");
		orderID.setPrefSize(200, 30);
		
		hotelName = new TextField(orderList.get(num).hotelID);
		hotelName.setId("AbnormalOrder");
		hotelName.setPrefSize(200, 30);
		
		roomType = new TextField(orderList.get(num).roomType.toString());
		roomType.setId("AbnormalOrder");
		roomType.setPrefSize(200, 30);
		
		lastExecuteTime = new TextField(orderList.get(num).endTime);
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
		hotelName.setLayoutY(250);
		
		roomType.setLayoutX(400);
		roomType.setLayoutY(350);
		
		lastExecuteTime.setLayoutX(400);
		lastExecuteTime.setLayoutY(450);
		
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
		AnchorPane.setTopAnchor(hotelName, 250.0);
		AnchorPane.setTopAnchor(roomType, 350.0);
		AnchorPane.setTopAnchor(lastExecuteTime, 450.0);
		
	}
	
	private void setButton(){
		
		//添加按钮
		againRegister = new Button("补登记订单");
		againRegister.setId("button-css");
		againRegister.setPrefSize(100, 40);
		
		revert = new Button("取消");
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
				
				controller.setabnormalOrderListView();
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
}
