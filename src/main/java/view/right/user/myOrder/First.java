package view.right.user.myOrder;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import viewController.UserLeftController;
import viewController.UserMyOrderController;

/**
 * 客户界面_我的订单_初始界面（查询订单）
 * @author XueWang
 *
 */
public class First {

	private UserLeftController controller;
	
	private Scene scene;
	
	private GridPane leftPane;
	
	private AnchorPane rightPane;
	
	private UserUI userUI ;

	TextField orderID;
	
	Button inquiry;
	
	public First(UserLeftController controller){
		
		this.controller = controller;
		
		userUI = new UserUI(controller);
		
		leftPane = userUI.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加按钮
		setButton();
		
		//添加文本框
		setTextField();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);

		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/hotelAndOrder/订单查询界面背景.jpg\")");
		
	}
	
	private void setButton(){
		
		//添加按钮
		inquiry = new Button("查询");
		inquiry.setPrefSize(100, 30);
		
		//添加按钮监听
		inquiry.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				// 搜索，controller内部实现跳转，若有则清空跳转（工厂模式）,若没有则清空提示
				UserMyOrderController right = new UserMyOrderController(controller.getStage(),controller.getUserID());
				right.searchOrder();
				setBlank();
				right.getStage().show();
			}
			
		});

		//添加组件
		rightPane.getChildren().add(inquiry);
		
		AnchorPane.setLeftAnchor(inquiry, 350.0);
		AnchorPane.setTopAnchor(inquiry, 250.0);
		
	}
	
	private void setTextField(){
		
		//添加文本框
		orderID = new TextField();
		orderID.setPrefSize(200, 30);
				
		//设置文本框位置
		orderID.setLayoutX(375);
		orderID.setLayoutY(250);
				
		//添加组件
				
		rightPane.getChildren().add(orderID);
				
		AnchorPane.setLeftAnchor(orderID, 100.0);
		AnchorPane.setTopAnchor(orderID, 250.0);
		
	}

	public Scene getScene(){
		
		return scene;
		
	}
	
	public void setBlank(){
		
		orderID.setText("");
		
	}
	
	public String getOrderID(){
		
		return orderID.getText();
		
	}
	
}
