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
import viewController.HMOrderManagementController;

/**
 * 酒店工作人员界面_管理订单_已执行订单_查看退房信息
 * @author XueWang
 *
 */
public class CheckLeaveInfo {
	
	private HMOrderManagementController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	TextField roomType;
	TextField actualLeaveTime;
	
	Button revert;
	
	public CheckLeaveInfo(HMOrderManagementController controller){
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
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
		
		//ArrayList<String> infoList = controller.getInfoList();
		//添加文本框
		
		roomType = new TextField();
		roomType.setId("CheckLeaveInfo");
		roomType.setPrefSize(200, 30);
		
		actualLeaveTime = new TextField();
		actualLeaveTime.setId("CheckLeaveInfo");
		actualLeaveTime.setPrefSize(200, 30);
		/*
		 * //设置文本框内容
		 * 
		 */
		
		//设置文本框内容不可更改
		roomType.setEditable(false);
		actualLeaveTime.setEditable(false);
		
		//设置文本框位置
		roomType.setLayoutX(400);
		roomType.setLayoutY(150);
		
		actualLeaveTime.setLayoutX(400);
		actualLeaveTime.setLayoutY(200);
		
		//添加组件
		rightPane.getChildren().add(actualLeaveTime);
		rightPane.getChildren().add(roomType);
		
		AnchorPane.setLeftAnchor(actualLeaveTime, 200.0);
		AnchorPane.setLeftAnchor(roomType, 200.0);
		
		AnchorPane.setTopAnchor(roomType, 150.0);
		AnchorPane.setTopAnchor(actualLeaveTime, 200.0);
		
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
				
			}
			
		});
		
		//添加组件
		rightPane.getChildren().add(revert);
		
		AnchorPane.setLeftAnchor(revert, 425.0);
		
		AnchorPane.setTopAnchor(revert, 525.0);
		
	}
}
