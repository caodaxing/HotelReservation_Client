package view.right.webBusiness.orderManagement;

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
import view.left.WebBusinessUI;
import viewController.WBOrderManagementController;
import viewController.WebBusinessLeftController;

/**
 * 网站营销人员界面_订单管理_未执行订单详情
 * @author XueWang
 *
 */
public class UnexecuteOrder {
	
	private WBOrderManagementController controller;
	private WebBusinessLeftController wbController;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui = new WebBusinessUI(wbController);
	
	TextField orderID;
	TextField hotelName;
	TextField roomType;
	TextField estimateInTime;
	TextField estimateLeaveTime;
	TextField primeCost;
	TextField realCost;
	
	Button revert;
	
	public UnexecuteOrder(WBOrderManagementController controller){
		
		this.controller = controller;
		
		leftPane = wbui.getPane();
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
		estimateInTime = new TextField();
		estimateLeaveTime = new TextField();
		primeCost = new TextField();
		realCost = new TextField();
		
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
		estimateInTime.setEditable(false);
		estimateLeaveTime.setEditable(false);
		primeCost.setEditable(false);
		realCost.setEditable(false);
		
		//设置textField大小
		orderID.setPrefSize(200, 30);
		hotelName.setPrefSize(200, 30);
		roomType.setPrefSize(200, 30);
		estimateInTime.setPrefSize(200, 30);
		estimateLeaveTime.setPrefSize(200, 30);
		primeCost.setPrefSize(200, 30);
		realCost.setPrefSize(200, 30);
		
		//右侧pane添加组件
		rightPane.getChildren().add(orderID);
		rightPane.getChildren().add(hotelName);
		rightPane.getChildren().add(roomType);
		rightPane.getChildren().add(estimateInTime);
		rightPane.getChildren().add(estimateLeaveTime);
		rightPane.getChildren().add(primeCost);
		rightPane.getChildren().add(realCost);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(orderID, 200.0);
		AnchorPane.setLeftAnchor(hotelName, 200.0);
		AnchorPane.setLeftAnchor(roomType, 200.0);
		AnchorPane.setLeftAnchor(estimateInTime, 200.0);
		AnchorPane.setLeftAnchor(estimateLeaveTime, 200.0);
		AnchorPane.setLeftAnchor(primeCost, 200.0);
		AnchorPane.setLeftAnchor(realCost, 200.0);
						
		AnchorPane.setTopAnchor(orderID, 150.0);
		AnchorPane.setTopAnchor(hotelName, 200.0);
		AnchorPane.setTopAnchor(roomType, 250.0);
		AnchorPane.setTopAnchor(estimateInTime, 300.0);
		AnchorPane.setTopAnchor(estimateLeaveTime, 350.0);
		AnchorPane.setTopAnchor(primeCost, 400.0);
		AnchorPane.setTopAnchor(realCost, 450.0);
	}
	
	private void setButton(){
		//添加按钮
		revert = new Button("返回");
		revert.setId("CheckVIPAreaStrategy");
		revert.setPrefSize(100, 40);
						
		//设置按钮位置
		revert.setLayoutX(625);
		revert.setLayoutY(525);
						
		//设置按钮监听
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
								
			}
							
		});
						
		//右侧pane添加
		rightPane.getChildren().add(revert);
						
		AnchorPane.setLeftAnchor(revert, 425.0);
		AnchorPane.setTopAnchor(revert, 525.0);
		
	}
	
}
