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
import view.helpTools.MessageHelper;
import view.helpTools.OneButtonDialog;
import view.left.HotelManagerUI;
import viewController.HMOrderManagementController;
import vo.OrderVO;

/**
 * 酒店工作人员界面_管理订单_未执行订单详情
 * @author XueWang
 *
 */
public class UnexecuteOrder {
	
	private HMOrderManagementController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	TextField orderID;
	TextField hotelName;
	TextField roomType;
	TextField estimateInTime;
	TextField estimateLeaveTime;
	TextField primeCost;
	TextField realCost;
	
	Button doOrder;
	Button revert;
	OrderVO orderVO;
	
	public UnexecuteOrder(HMOrderManagementController controller){
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
				
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add("/CSS/right.css");
		
		//添加文本内容
		setTextContent();
		
		//添加按钮
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.setStyle("-fx-background-image:url(\"/orderManagement/订单详情_未执行订单背景.jpg\")");
		
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextContent(){
		
//		controller.setFilterOrderList(OrderListCondition.UNEXECUTED);
//		orderVO = controller.getlist().get(controller.getRow());
		
		//设置未执行订单的文本信息
		orderID = new TextField();
		hotelName = new TextField();
		roomType = new TextField();
		estimateInTime = new TextField();
		estimateLeaveTime = new TextField();
		primeCost = new TextField();
		realCost = new TextField();
		
		orderID.setId("UnExecuteOrder");
		hotelName.setId("UnExecuteOrder");
		roomType.setId("UnExecuteOrder");
		estimateInTime.setId("UnExecuteOrder");
		estimateLeaveTime.setId("UnExecuteOrder");
		primeCost.setId("UnExecuteOrder");
		realCost.setId("UnExecuteOrder");
		
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
		doOrder = new Button("执行订单");
		doOrder.setId("UnExecuteOrder");
		doOrder.setPrefSize(100, 40);
		
		revert = new Button("返回");
		revert.setId("UnExecuteOrder");
		revert.setPrefSize(100, 40);
						
		//设置按钮位置
		doOrder.setLayoutX(450);
		doOrder.setLayoutY(525);
		
		revert.setLayoutX(625);
		revert.setLayoutY(525);
						
		//设置按钮监听
		doOrder.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				OrderVO vo = controller.getOrderInfo();
				if(controller.getRoomInfoUpdateResult(vo.orderId, vo.roomIDs) == ResultMessage.SUCCESS){
					controller.showDialog("订单执行成功");
				}else{
					controller.showDialog("订单执行失败");
				}				
//				controller.getStage().show();
			}
							
		});
		
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				controller.setunExecuteOrderListView();
				controller.setOrderId(null);
				controller.getStage().show();
			}
							
		});
						
		//右侧pane添加
		rightPane.getChildren().add(doOrder);
		rightPane.getChildren().add(revert);
		
		AnchorPane.setLeftAnchor(doOrder, 250.0);
		AnchorPane.setLeftAnchor(revert, 425.0);
		
		AnchorPane.setTopAnchor(doOrder, 525.0);
		AnchorPane.setTopAnchor(revert, 525.0);
		
	}
	
	public void setBlank(){
		orderID.setText("");
		hotelName.setText("");
		roomType.setText("");
		estimateInTime.setText("");
		estimateLeaveTime.setText("");
		primeCost.setText("");
		realCost.setText("");
	}
	
	public void setText(){
		OrderVO vo = controller.getOrderInfo();
		orderID.setText(vo.orderId);
		hotelName.setText(vo.hotelID);
		roomType.setText(MessageHelper.roomTypeToString(vo.roomType));
		estimateInTime.setText(vo.startTime);
		estimateLeaveTime.setText(vo.endTime);
		primeCost.setText(String.valueOf(vo.beforePrice));
		realCost.setText(String.valueOf(vo.afterPrice));
	}
}
