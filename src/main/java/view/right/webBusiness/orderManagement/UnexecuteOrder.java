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
import logic.order.ManageOrder;
import logicService.order.ManageOrderService;
import view.helpTools.DefaultNums;
import view.left.WebBusinessUI;
import viewController.WBOrderManagementController;
import vo.OrderVO;

/**
 * 网站营销人员界面_订单管理_未执行订单详情
 * @author XueWang
 *
 */
public class UnexecuteOrder {
	
	private WBOrderManagementController controller;
	private ManageOrderService manageOrderService;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui;
	
	TextField orderID;
	TextField hotelName;
	TextField roomType;
	TextField estimateInTime;
	TextField estimateLeaveTime;
	TextField primeCost;
	TextField realCost;
	
	Button revert;
	ArrayList<OrderVO> orderList;
	
	public UnexecuteOrder(WBOrderManagementController controller) {
		
		this.controller = controller;
		wbui = new WebBusinessUI(controller);
		manageOrderService = new ManageOrder();
		
		leftPane = wbui.getPane();
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
		orderList = manageOrderService.getWebDailyUnexecutedOrderList();
		int num = controller.getRow();
	
		//设置未执行订单的文本信息
		orderID = new TextField(orderList.get(num).orderId);
		hotelName = new TextField(orderList.get(num).hotelID);
		roomType = new TextField(orderList.get(num).roomType.toString());
		estimateInTime = new TextField(orderList.get(num).startTime);
		estimateLeaveTime = new TextField(orderList.get(num).endTime);
		primeCost = new TextField(String.valueOf(orderList.get(num).beforePrice));
		realCost = new TextField(String.valueOf(orderList.get(num).afterPrice));
		
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
				orderID.setText("");
				hotelName.setText("");
				roomType.setText("");
				estimateInTime.setText("");
				estimateLeaveTime.setText("");
				primeCost.setText("");
				realCost.setText("");
				controller.setTodayUnexecuteOrderView();
				controller.getStage().show();
			}
							
		});
						
		//右侧pane添加
		rightPane.getChildren().add(revert);
						
		AnchorPane.setLeftAnchor(revert, 425.0);
		AnchorPane.setTopAnchor(revert, 525.0);
		
	}
	
}
