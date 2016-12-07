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
import viewController.WBOrderManagementController;

/**
 * 酒店工作人员界面_管理订单_已执行订单详情
 * @author XueWang
 *
 */
public class ExecuteOrder {
	
	private HMOrderManagementController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui = new HotelManagerUI();
	
	TextField orderID;
	TextField hotelName;
	TextField roomType;
	TextField arriveTime;
	TextField leaveTime;
	TextField primeCost;
	TextField realCost;
	
	Button arriveInfo;
	Button leaveInfo;
	Button checkEvaluation;
	Button revert;
	
	public ExecuteOrder(HMOrderManagementController controller){
		
		this.controller = controller;
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加文本内容
		setTextContent();
		
		//添加按钮
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextContent(){
		
		//ArrayList<String> orderInfoList = controller.getInfoList();
		
		//设置未执行订单的文本信息
		orderID = new TextField();
		hotelName = new TextField();
		roomType = new TextField();
		arriveTime = new TextField();
		leaveTime = new TextField();
		primeCost = new TextField();
		realCost = new TextField();
		
		orderID.setId("ExecuteOrder");
		hotelName.setId("ExecuteOrder");
		roomType.setId("ExecuteOrder");
		arriveTime.setId("ExecuteOrder");
		leaveTime.setId("ExecuteOrder");
		primeCost.setId("ExecuteOrder");
		realCost.setId("ExecuteOrder");
		
		/*
		//根据Controller设置textField文字
		orderID.setText(infoList.get(0));
		hotelName.setText(infoList.get(1));
		roomType.setText(infoList.get(2));
		arriveTime.setText(infoList.get(3));
		leaveTime.setText(infoList.get(4));
		primeCost.setText(infoList.get(5));
		realCost.setText(infoList.get(6));
		*/
		
		//设置TextField不可更改
		orderID.setEditable(false);
		hotelName.setEditable(false);
		roomType.setEditable(false);
		arriveTime.setEditable(false);
		leaveTime.setEditable(false);
		primeCost.setEditable(false);
		realCost.setEditable(false);
		
		//设置textField大小
		orderID.setPrefSize(200, 30);
		hotelName.setPrefSize(200, 30);
		roomType.setPrefSize(200, 30);
		arriveTime.setPrefSize(200, 30);
		leaveTime.setPrefSize(200, 30);
		primeCost.setPrefSize(200, 30);
		realCost.setPrefSize(200, 30);
		
		//右侧pane添加组件
		rightPane.getChildren().add(orderID);
		rightPane.getChildren().add(hotelName);
		rightPane.getChildren().add(roomType);
		rightPane.getChildren().add(arriveTime);
		rightPane.getChildren().add(leaveTime);
		rightPane.getChildren().add(primeCost);
		rightPane.getChildren().add(realCost);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(orderID, 200.0);
		AnchorPane.setLeftAnchor(hotelName, 200.0);
		AnchorPane.setLeftAnchor(roomType, 200.0);
		AnchorPane.setLeftAnchor(arriveTime, 200.0);
		AnchorPane.setLeftAnchor(leaveTime, 200.0);
		AnchorPane.setLeftAnchor(primeCost, 200.0);
		AnchorPane.setLeftAnchor(realCost, 200.0);
						
		AnchorPane.setTopAnchor(orderID, 150.0);
		AnchorPane.setTopAnchor(hotelName, 200.0);
		AnchorPane.setTopAnchor(roomType, 250.0);
		AnchorPane.setTopAnchor(arriveTime, 300.0);
		AnchorPane.setTopAnchor(leaveTime, 350.0);
		AnchorPane.setTopAnchor(primeCost, 400.0);
		AnchorPane.setTopAnchor(realCost, 450.0);
	}
	
	private void setButton(){
		
		//添加按钮
		
		arriveInfo = new Button("入住信息");
		arriveInfo.setId("button-css");
		arriveInfo.setPrefSize(100, 40);
		
		leaveInfo = new Button("退房信息");
		leaveInfo.setId("button-css");
		leaveInfo.setPrefSize(100, 40);
		
		checkEvaluation = new Button("查看评价");
		checkEvaluation.setId("button-css");
		checkEvaluation.setPrefSize(100, 40);
		
		revert = new Button("返回");
		revert.setId("button-css");
		revert.setPrefSize(100, 40);
		
								
		//设置按钮位置
		arriveInfo.setLayoutX(625);
		arriveInfo.setLayoutY(400);
		
		leaveInfo.setLayoutX(625);
		leaveInfo.setLayoutY(450);
		
		checkEvaluation.setLayoutX(450);
		checkEvaluation.setLayoutY(525);
		
		revert.setLayoutX(625);
		revert.setLayoutY(525);
								
		//设置按钮监听
		arriveInfo.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
										
			}
									
		});
		
		leaveInfo.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
										
			}
									
		});
		
		checkEvaluation.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
										
			}
									
		});
		
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
										
			}
									
		});
								
		//右侧pane添加
		rightPane.getChildren().add(arriveInfo);
		rightPane.getChildren().add(leaveInfo);
		rightPane.getChildren().add(checkEvaluation);
		rightPane.getChildren().add(revert);
								
		AnchorPane.setLeftAnchor(arriveInfo, 425.0);
		AnchorPane.setLeftAnchor(leaveInfo, 425.0);
		AnchorPane.setLeftAnchor(checkEvaluation, 250.0);
		AnchorPane.setLeftAnchor(revert, 425.0);
		
		AnchorPane.setTopAnchor(arriveInfo, 400.0);
		AnchorPane.setTopAnchor(leaveInfo, 450.0);
		AnchorPane.setTopAnchor(checkEvaluation, 525.0);
		AnchorPane.setTopAnchor(revert, 525.0);
				
		}
}
