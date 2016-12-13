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
 * 酒店工作人员界面_管理订单_已执行订单_更新入住信息
 * @author XueWang
 *
 */
public class SetArriveInfo {
	
	private HMOrderManagementController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	TextField roomType;
	TextField arriveTime;
	TextField estimateLeaveTime;
	
	Button ok;
	Button cancel;
	
	public SetArriveInfo(HMOrderManagementController controller){
		
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
		
		//ArrayList<String> infoList = controller.getInfoList();
		//添加文本框
		arriveTime = new TextField();
		arriveTime.setId("SetArriveInfo");
		arriveTime.setPrefSize(200, 30);
		
		estimateLeaveTime = new TextField();
		estimateLeaveTime.setId("SetArriveInfo");
		estimateLeaveTime.setPrefSize(200, 30);
		
		roomType = new TextField();
		roomType.setId("SetArriveInfo");
		roomType.setPrefSize(200, 30);
		
		//设置文本框内容
		
		//设置文本框内容可更改
		roomType.setEditable(true);
		arriveTime.setEditable(true);
		estimateLeaveTime.setEditable(true);
		
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
		ok = new Button("确定");
		ok.setId("SetArriveInfo");
		ok.setPrefSize(100, 40);
		
		cancel = new Button("取消");
		cancel.setId("SetArriveInfo");
		cancel.setPrefSize(100, 40);
				
		//设置按钮位置
		ok.setLayoutX(450);
		ok.setLayoutY(525);
		
		cancel.setLayoutX(625);
		cancel.setLayoutY(525);
		
		
		
		//添加按钮监听
		ok.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//添加组件
		rightPane.getChildren().add(ok);
		rightPane.getChildren().add(cancel);
		
		AnchorPane.setLeftAnchor(ok, 250.0);
		AnchorPane.setLeftAnchor(cancel, 425.0);
		
		AnchorPane.setTopAnchor(ok, 525.0);
		AnchorPane.setTopAnchor(cancel, 525.0);
		
	}
}
