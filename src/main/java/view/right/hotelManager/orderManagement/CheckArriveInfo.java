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
import logicService.order.OrderListService;
import logicService.stub.OrderService_Stub;
import view.helpTools.DefaultNums;
import view.helpTools.MessageHelper;
import view.left.HotelManagerUI;
import viewController.HMOrderManagementController;
import vo.OrderVO;

/**
 * 酒店工作人员界面_管理订单_已执行订单_查看入住信息
 * @author XueWang
 *
 */
public class CheckArriveInfo {
	
	private HMOrderManagementController controller;
	private OrderListService orderListService;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	TextField roomType;
	TextField arriveTime;
	TextField estimateLeaveTime;
	
	Button revert;
	
	ArrayList<OrderVO> orderList;
	
	public CheckArriveInfo(HMOrderManagementController controller){
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
		orderListService = new OrderService_Stub();
		
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
		root.setStyle("-fx-background-image:url(\"/infoManagement/房间管理_查看入住信息背景.jpg\")");
		
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
//		OrderVO vo = controller.getOrderInfo();
		
		//添加文本框
		arriveTime = new TextField();
		arriveTime.setId("CheckArriveInfo");
		arriveTime.setPrefSize(200, 30);
		
		estimateLeaveTime = new TextField();
		estimateLeaveTime.setId("CheckArriveInfo");
		estimateLeaveTime.setPrefSize(200, 30);
		
		roomType = new TextField();
		roomType.setId("CheckArriveInfo");
		roomType.setPrefSize(200, 30);
		
		//设置文本框内容
		
		//设置文本框内容不可更改
		roomType.setEditable(false);
		arriveTime.setEditable(false);
		estimateLeaveTime.setEditable(false);
		
		//设置文本框位置
		roomType.setLayoutX(400);
		roomType.setLayoutY(150);
		
		arriveTime.setLayoutX(400);
		arriveTime.setLayoutY(200);
		
		estimateLeaveTime.setLayoutX(400);
		estimateLeaveTime.setLayoutY(250);
		
		//添加组件
		rightPane.getChildren().add(arriveTime);
		rightPane.getChildren().add(estimateLeaveTime);
		rightPane.getChildren().add(roomType);
		
		AnchorPane.setLeftAnchor(arriveTime, 200.0);
		AnchorPane.setLeftAnchor(estimateLeaveTime, 200.0);
		AnchorPane.setLeftAnchor(roomType, 200.0);
		
		AnchorPane.setTopAnchor(roomType, 150.0);
		AnchorPane.setTopAnchor(arriveTime, 200.0);
		AnchorPane.setTopAnchor(estimateLeaveTime, 250.0);
		
	}
	
	private void setButton(){
		
		//添加按钮
		
		revert = new Button("返回");
		revert.setId("button-css");
		revert.setPrefSize(100, 40);
				
		//设置按钮位置
		
		revert.setLayoutX(625);
		revert.setLayoutY(525);
		
		
		
		//添加按钮监听
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				controller.setReturnExecuteOrderView();
				controller.getStage().show();
			}
			
		});
		
		//添加组件
		rightPane.getChildren().add(revert);
		
		AnchorPane.setLeftAnchor(revert, 425.0);
		
		AnchorPane.setTopAnchor(revert, 525.0);
		
	}
	
	public void setText(){
		OrderVO vo = controller.getOrderInfo();
		arriveTime.setText(vo.checkInTime);
		estimateLeaveTime.setText(vo.endTime);
		roomType.setText(MessageHelper.roomTypeToString(vo.roomType));
	}
}
