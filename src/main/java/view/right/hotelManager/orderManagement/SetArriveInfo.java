package view.right.hotelManager.orderManagement;

import Message.OrderListCondition;
import Message.ResultMessage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.helpTools.OneButtonDialog;
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
	
	TextField roomId;
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
		root.setStyle("-fx-background-image:url(\"/infoManagement/房间管理_更新入住信息背景.jpg\")");
		
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		//添加文本框
		arriveTime = new TextField();
		arriveTime.setId("SetArriveInfo");
		arriveTime.setPrefSize(200, 30);
		
		estimateLeaveTime = new TextField();
		estimateLeaveTime.setId("SetArriveInfo");
		estimateLeaveTime.setPrefSize(200, 30);
		
		roomId = new TextField();
		roomId.setId("SetArriveInfo");
		roomId.setPrefSize(200, 30);
		
		//设置文本框内容可更改
		roomId.setEditable(true);
		arriveTime.setEditable(true);
		estimateLeaveTime.setEditable(true);
		
		//设置文本框位置
		roomId.setLayoutX(400);
		roomId.setLayoutY(150);
		
		arriveTime.setLayoutX(400);
		arriveTime.setLayoutY(200);
		
		estimateLeaveTime.setLayoutX(400);
		estimateLeaveTime.setLayoutY(250);
		
		//添加组件
		rightPane.getChildren().add(arriveTime);
		rightPane.getChildren().add(estimateLeaveTime);
		rightPane.getChildren().add(roomId);
		
		AnchorPane.setLeftAnchor(arriveTime, 200.0);
		AnchorPane.setLeftAnchor(estimateLeaveTime, 200.0);
		AnchorPane.setLeftAnchor(roomId, 200.0);
		
		AnchorPane.setTopAnchor(roomId, 150.0);
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
				controller.setFilterOrderList(OrderListCondition.UNEXECUTED);
				OrderVO orderVO = controller.getlist().get(controller.getRow());
				String rooms = roomId.getText();
				String[] roomID = rooms.split(" ");
				String orderId = orderVO.orderId;
				if(controller.getResult(orderId, roomID) == ResultMessage.SUCCESS){
					OneButtonDialog dialog = new OneButtonDialog("入住成功");
					dialog.show();
					controller.setunExecuteOrderListView();
					controller.getStage().show();
				}else{
					OneButtonDialog dialog = new OneButtonDialog("更新失败");
					dialog.show();
					roomId.setText("");
					arriveTime.setText("");
					estimateLeaveTime.setText("");
					
				}
			}
			
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
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
}
