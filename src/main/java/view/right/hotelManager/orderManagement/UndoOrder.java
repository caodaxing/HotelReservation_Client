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
 * 酒店工作人员界面_管理订单_未执行订单详情
 * @author XueWang
 *
 */
public class UndoOrder {
	
	private HMOrderManagementController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui = new HotelManagerUI();
	
	TextField orderID;
	TextField hotelName;
	TextField roomType;
	TextField cancelTime;
	
	Button revert;
	
	public UndoOrder(HMOrderManagementController controller){
		
		this.controller = controller;
		
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
		orderID = new TextField();
		orderID.setId("AbnormalOrder");
		orderID.setPrefSize(200, 30);
		
		hotelName = new TextField();
		hotelName.setId("AbnormalOrder");
		hotelName.setPrefSize(200, 30);
		
		roomType = new TextField();
		roomType.setId("AbnormalOrder");
		roomType.setPrefSize(200, 30);
		
		cancelTime = new TextField();
		cancelTime.setId("AbnormalOrder");
		cancelTime.setPrefSize(200, 30);
		
		//设置文本框内容
		
		//设置文本框内容不可更改
		orderID.setEditable(false);
		hotelName.setEditable(false);
		roomType.setEditable(false);
		cancelTime.setEditable(false);
		
		//设置文本框位置
		orderID.setLayoutX(400);
		orderID.setLayoutY(150);
		
		hotelName.setLayoutX(400);
		hotelName.setLayoutY(250);
		
		roomType.setLayoutX(400);
		roomType.setLayoutY(350);
		
		cancelTime.setLayoutX(400);
		cancelTime.setLayoutY(450);
		
		//添加组件
		rightPane.getChildren().add(orderID);
		rightPane.getChildren().add(hotelName);
		rightPane.getChildren().add(roomType);
		rightPane.getChildren().add(cancelTime);
		
		AnchorPane.setLeftAnchor(orderID, 200.0);
		AnchorPane.setLeftAnchor(hotelName, 200.0);
		AnchorPane.setLeftAnchor(roomType, 200.0);
		AnchorPane.setLeftAnchor(cancelTime, 200.0);
		
		AnchorPane.setTopAnchor(orderID, 150.0);
		AnchorPane.setTopAnchor(hotelName, 250.0);
		AnchorPane.setTopAnchor(roomType, 350.0);
		AnchorPane.setTopAnchor(cancelTime, 450.0);
		
	}
	
	private void setButton(){
		
		//添加按钮
		revert = new Button("取消");
		revert.setId("AbnormalOrder");
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
