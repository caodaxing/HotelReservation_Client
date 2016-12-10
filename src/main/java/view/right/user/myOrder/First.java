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
		
	}
	
	private void setButton(){
		
		//添加按钮
		inquiry = new Button("查询");
		inquiry.setPrefSize(100, 30);
		
		//设置按钮位置
		inquiry.setLayoutX(375);
		inquiry.setLayoutY(330);
		
		//添加按钮监听
		inquiry.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});

		//添加组件
		rightPane.getChildren().add(inquiry);
		
		AnchorPane.setLeftAnchor(inquiry, 175.0);
		AnchorPane.setTopAnchor(inquiry, 330.0);
		
	}
	
	private void setTextField(){
		
		//添加文本框
		orderID = new TextField();
		orderID.setPrefSize(250, 30);
				
		//设置文本框位置
		orderID.setLayoutX(375);
		orderID.setLayoutY(250);
				
		//添加组件
				
		rightPane.getChildren().add(orderID);
				
		AnchorPane.setLeftAnchor(orderID, 175.0);
		AnchorPane.setTopAnchor(orderID, 250.0);
		
	}

	public Scene getScene(){
		
		return scene;
		
	}
	
}
