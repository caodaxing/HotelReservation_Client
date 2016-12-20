package view.right.webBusiness.orderManagement;

import java.util.ArrayList;

import Message.ResultMessage;
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
import view.helpTools.OneButtonDialog;
import view.left.WebBusinessUI;
import viewController.WBOrderManagementController;
import vo.OrderVO;

/**
 * 网站营销人员界面_订单管理_异常订单详情
 * @author XueWang
 *
 */
public class AbnormalOrder{
	
	private WBOrderManagementController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui;
	
	TextField orderID;
	TextField hotelName;
	TextField roomType;
	TextField lastExecuteTime;
	
	Button halfCredit;
	Button allCredit;
	Button revert;
	ArrayList<OrderVO> orderList;
	
	public AbnormalOrder(WBOrderManagementController controller){
		
		this.controller = controller;
		wbui = new WebBusinessUI(controller);
		
		leftPane = wbui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add("/CSS/right.css");
		
		//添加文本框
		setTextField();
		
		//添加按钮
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.setStyle("-fx-background-image:url(\"/orderManagement/订单管理_异常订单背景.jpg\")");
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
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
		
		lastExecuteTime = new TextField();
		lastExecuteTime.setId("AbnormalOrder");
		lastExecuteTime.setPrefSize(200, 30);
		
		//设置文本框内容不可更改
		orderID.setEditable(false);
		hotelName.setEditable(false);
		roomType.setEditable(false);
		lastExecuteTime.setEditable(false);
		
		//设置文本框位置
		orderID.setLayoutX(400);
		orderID.setLayoutY(150);
		
		hotelName.setLayoutX(400);
		hotelName.setLayoutY(200);
		
		roomType.setLayoutX(400);
		roomType.setLayoutY(250);
		
		lastExecuteTime.setLayoutX(400);
		lastExecuteTime.setLayoutY(300);
		
		//添加组件
		rightPane.getChildren().add(orderID);
		rightPane.getChildren().add(hotelName);
		rightPane.getChildren().add(roomType);
		rightPane.getChildren().add(lastExecuteTime);
		
		AnchorPane.setLeftAnchor(orderID, 200.0);
		AnchorPane.setLeftAnchor(hotelName, 200.0);
		AnchorPane.setLeftAnchor(roomType, 200.0);
		AnchorPane.setLeftAnchor(lastExecuteTime, 200.0);
		
		AnchorPane.setTopAnchor(orderID, 150.0);
		AnchorPane.setTopAnchor(hotelName, 200.0);
		AnchorPane.setTopAnchor(roomType, 250.0);
		AnchorPane.setTopAnchor(lastExecuteTime, 300.0);
		
	}
	
	private void setButton(){
		
		//添加按钮
		halfCredit = new Button("撤销并恢复一半信用");
		halfCredit.setId("AbnormalOrder");
		halfCredit.setPrefSize(150, 40);
		
		allCredit = new Button("撤销并恢复全部信用");
		allCredit.setId("AbnormalOrder");
		allCredit.setPrefSize(150, 40);
		
		revert = new Button("返回");
		revert.setId("AbnormalOrder");
		revert.setPrefSize(100, 40);
				
		//设置按钮位置
		halfCredit.setLayoutX(275);
		halfCredit.setLayoutY(525);
		
		allCredit.setLayoutX(450);
		allCredit.setLayoutY(525);
		
		revert.setLayoutX(625);
		revert.setLayoutY(525);
		
		//添加按钮监听
		halfCredit.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				//传输creditVO
				String orderId = orderID.getText();
				boolean bool = false;
				//
				if(controller.getHalfCreditResult(orderId, bool) == ResultMessage.SUCCESS){
					controller.showDialog("信用修改成功");
				}else{
					controller.showDialog("信用修改失败");
				}
			}
			
		});
		
		allCredit.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				//传输creditVO
				String orderId = orderID.getText();
				boolean bool = true;
				//
				if(controller.getHalfCreditResult(orderId, bool) == ResultMessage.SUCCESS){
					controller.showDialog("信用修改成功");
				}else{
					controller.showDialog("信用修改失败");
				}
			}
			
		});
		
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				controller.setAbnormalOrderView();
				controller.getStage().show();
			}
			
		});
		
		//添加组件
		rightPane.getChildren().add(halfCredit);
		rightPane.getChildren().add(allCredit);
		rightPane.getChildren().add(revert);
		
		AnchorPane.setLeftAnchor(halfCredit, 75.0);
		AnchorPane.setLeftAnchor(allCredit, 250.0);
		AnchorPane.setLeftAnchor(revert, 425.0);
		
		AnchorPane.setTopAnchor(halfCredit, 525.0);
		AnchorPane.setTopAnchor(allCredit, 525.0);
		AnchorPane.setTopAnchor(revert, 525.0);
		
	}
	
	public void setText(){
		OrderVO vo = controller.getOrderVOInfo();
		orderID.setText(vo.orderId);
		hotelName.setText(vo.hotelID);
		roomType.setText(vo.roomType.toString());
		lastExecuteTime.setText(vo.endTime);
	}
	
}
