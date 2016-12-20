package view.right.hotelManager.orderManagement;

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
import viewController.HMHotelInfoController;
import viewController.HMOrderManagementController;
import viewController.HotelManagerLeftController;

/**
 * 酒店工作人员界面_管理订单_查询订单界面
 * @author XueWang
 *
 */
public class SearchOrder{
	
	private HMOrderManagementController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	Button inquiry;
	Button revert;
	
	TextField orderID;
	
	public SearchOrder(HMOrderManagementController controller){
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add("/CSS/right.css");
		
		//添加按钮
		setButton();
		
		//添加文本框
		setTextField();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.setStyle("-fx-background-image:url(\"/hotelAndOrder/订单查询界面背景.jpg\")");
		
	}
	
	public Scene getScene(){
		return scene;
	}
	
	public void setButton(){
		
		//添加按钮
		inquiry = new Button("查询");
		inquiry.setId("searchOrder");
		inquiry.setPrefSize(100, 30);
		
		revert = new Button("返回");
		revert.setId("searchOrder");
		revert.setPrefSize(100, 30);
		
		//设置按钮位置
		inquiry.setLayoutX(375);
		inquiry.setLayoutY(330);
		
		revert.setLayoutX(525);
		revert.setLayoutY(330);
		
		//添加按钮监听
		inquiry.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				//传输vo
				if(controller.getOrder(orderID.getText()) != null){
					controller.setOrderId(orderID.getText());
					controller.setOrderView();
					controller.setExecuteOrderView();
					controller.getStage().show();
				}else{
					controller.showDialog("订单不存在");
				}
				//
				
			}
			
		});
		
		revert.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				controller.setAllOrderListView();
				controller.setOrderId(null);
				controller.getStage().show();
			}
			
		});

		//添加组件
		rightPane.getChildren().add(inquiry);
		rightPane.getChildren().add(revert);
		
		AnchorPane.setLeftAnchor(inquiry, 175.0);
		AnchorPane.setLeftAnchor(revert, 325.0);
		AnchorPane.setTopAnchor(inquiry, 330.0);
		AnchorPane.setTopAnchor(revert, 330.0);
		
	}
	
	public void setTextField(){
		
		//添加文本框
		orderID = new TextField();
		orderID.setId("searchOrder");
		orderID.setPrefSize(250, 30);
				
		//设置文本框位置
		orderID.setLayoutX(375);
		orderID.setLayoutY(250);
				
		//添加组件
				
		rightPane.getChildren().add(orderID);
				
		AnchorPane.setLeftAnchor(orderID, 175.0);
		AnchorPane.setTopAnchor(orderID, 250.0);
		
	}
	
}
