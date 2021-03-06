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
 * 酒店工作人员界面_管理订单_已执行订单_更新退房信息
 * @author XueWang
 *
 */
public class SetLeaveInfo {
	
	private HMOrderManagementController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	TextField roomType;
	TextField actualLeaveTime;
	
	Button ok;
	Button cancel;
	
	public SetLeaveInfo(HMOrderManagementController controller){
		
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
		root.setStyle("-fx-background-image:url(\"/infoManagement/房间管理_更新退房信息背景.jpg\")");
		
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		//添加文本框
		
		roomType = new TextField();
		roomType.setId("SetLeaveInfo");
		roomType.setPrefSize(200, 30);
		
		actualLeaveTime = new TextField();
		actualLeaveTime.setId("SetLeaveInfo");
		actualLeaveTime.setPrefSize(200, 30);
		
		//设置文本框内容可更改
		roomType.setEditable(true);
		actualLeaveTime.setEditable(true);
		
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
		ok = new Button("确定");
		ok.setId("SetLeaveInfo");
		ok.setPrefSize(100, 40);
		
		cancel = new Button("取消");
		cancel.setId("SetLeaveInfo");
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
				if(controller.setLeaveResult() == ResultMessage.SUCCESS){
					OneButtonDialog dialog = new OneButtonDialog("退房成功");
					dialog.show();
					controller.setHasExecuteOrderListView();
					controller.getStage().show();
				}else{
					OneButtonDialog dialog = new OneButtonDialog("更新失败");
					dialog.show();
				}
			}
			
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				controller.setHasExecuteOrderListView();
				controller.setOrderId(null);
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
