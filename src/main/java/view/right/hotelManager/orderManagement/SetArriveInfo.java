package view.right.hotelManager.orderManagement;

import Message.ResultMessage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.helpTools.MessageHelper;
import view.left.HotelManagerUI;
import viewController.HMOrderManagementController;
import vo.OrderVO;

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
	
	TextArea roomIds;
	Label label;
	TextField roomType;
	TextField leaveTime;
	
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
		root.setStyle("-fx-background-image:url(\"/infoManagement/房间管理_更新入住信息背景.jpg\")");
		
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		//添加文本框
		roomIds = new TextArea();
		roomIds.setId("SetArriveInfo");
		roomIds.setPrefSize(200, 30);
		
		label = new Label();
		label.setId("SetArriveInfo");
		
		roomType = new TextField();
		roomType.setId("SetAvailableRooms");
		roomType.setPrefSize(200, 30);
		
		leaveTime = new TextField();
		leaveTime.setId("SetArriveInfo");
		leaveTime.setPrefSize(200, 30);
		
		//设置文本框内容可更改
		roomIds.setEditable(true);
		roomType.setEditable(false);
		leaveTime.setEditable(false);
		
		//设置文本框位置
		
		roomIds.setLayoutX(400);
		roomIds.setLayoutY(150);
		
		label.setLayoutX(600);
		label.setLayoutY(160);
		
		roomType.setLayoutX(400);
		roomType.setLayoutY(200.0);
		
		leaveTime.setLayoutX(400);
		leaveTime.setLayoutY(250);
		
		//添加组件
		rightPane.getChildren().add(roomIds);
		rightPane.getChildren().add(label);
		rightPane.getChildren().add(roomType);
		rightPane.getChildren().add(leaveTime);
		
		AnchorPane.setLeftAnchor(roomIds, 200.0);
		AnchorPane.setLeftAnchor(label, 400.0);
		AnchorPane.setLeftAnchor(roomType, 200.0);
		AnchorPane.setLeftAnchor(leaveTime, 200.0);
		
		AnchorPane.setTopAnchor(roomIds, 150.0);
		AnchorPane.setTopAnchor(label, 160.0);
		AnchorPane.setTopAnchor(roomType, 200.0);
		AnchorPane.setTopAnchor(leaveTime, 250.0);
		
	}
	
	private void setButton(){
		
		//添加按钮
		ok = new Button("确定");
		ok.setId("SetArriveInfo");
		ok.setPrefSize(100, 40);
		
		cancel = new Button("返回");
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
				String rooms = roomIds.getText();
				String[] room = rooms.split(" ");
				OrderVO vo = controller.getOrderInfo();
				if(controller.getRoomInfoUpdateResult(room) == ResultMessage.SUCCESS){
					controller.showDialog("订单执行成功");
				}else{
					controller.showDialog("订单执行失败");
				}			
			}
			
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				controller.setunExecuteOrderListView();
				controller.getStage().show();
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
	
	public void setText(){
		OrderVO vo = controller.getOrderInfo();
		label.setText("预定"+String.valueOf(vo.roomNum)+"间房");
		roomType.setText(MessageHelper.roomTypeToString(vo.roomType));
		leaveTime.setText(vo.endTime);
	}
}
