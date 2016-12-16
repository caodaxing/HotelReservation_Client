package view.right.hotelManager.orderManagement;

import Message.OrderListCondition;
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
import vo.OrderVO;

/**
 * 酒店工作人员界面_管理订单_撤销订单详情
 * @author XueWang
 *
 */
public class UndoOrder {
	
	private HMOrderManagementController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	TextField orderID;
	TextField hotelName;
	TextField roomType;
	TextField cancelTime;
	
	Button revert;
	OrderVO orderVO;
	
	public UndoOrder(HMOrderManagementController controller){
		
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
		root.setStyle("-fx-background-image:url(\"/infoManagement/订单详情_撤销订单背景.jpg\")");
		
	}

	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		controller.setFilterOrderList(OrderListCondition.UNDO_UNEXECUTED);
		orderVO = controller.getlist().get(controller.getRow());
		
		//添加文本框
		orderID = new TextField(orderVO.orderId);
		orderID.setId("AbnormalOrder");
		orderID.setPrefSize(200, 30);
		
		hotelName = new TextField(orderVO.hotelID);
		hotelName.setId("AbnormalOrder");
		hotelName.setPrefSize(200, 30);
		
		roomType = new TextField(orderVO.roomType.toString());
		roomType.setId("AbnormalOrder");
		roomType.setPrefSize(200, 30);
		
		cancelTime = new TextField(orderVO.undoUnexecutedTime);
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
		hotelName.setLayoutY(200);
		
		roomType.setLayoutX(400);
		roomType.setLayoutY(250);
		
		cancelTime.setLayoutX(400);
		cancelTime.setLayoutY(300);
		
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
		revert = new Button("返回");
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
				controller.setUndoOrderListView();
				controller.getStage().show();
			}
			
		});
		
		//添加组件
		rightPane.getChildren().add(revert);
		
		AnchorPane.setLeftAnchor(revert, 425.0);
		
		AnchorPane.setTopAnchor(revert, 525.0);
		
	}
}
