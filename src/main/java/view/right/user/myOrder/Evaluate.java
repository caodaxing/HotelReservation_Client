package view.right.user.myOrder;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import viewController.UserLeftController;
import viewController.UserMyOrderController;

/**
 * 客户界面_我的订单_已执行订单_评价
 * @author XueWang
 *
 */
public class Evaluate {

	private UserMyOrderController controller;
	
	private Scene scene ;
	
	private UserUI userUI ;	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	TextField grade ;
	TextArea info ;
	
	Button confirm;
	Button cancel ;
	
	public Evaluate(UserMyOrderController controller){
		
		this.controller = controller;
		
		userUI = new UserUI(controller);
		
		// 初始化左侧Pane
		leftPane = userUI.getPane() ;
		leftPane.setPrefSize ( DefaultNums.LEFT_WIDTH , DefaultNums.HEIGHT );
		
		//初始化右侧Pane
		rightPane = new AnchorPane();
		rightPane.setPrefSize( DefaultNums.RIGHT_WIDTH , DefaultNums.HEIGHT );
		
		//设置TextField
		setText();
		
		//设置Button
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		
	}
	
	private void setText(){
		
		//初始化textField
		grade = new TextField();
		info = new TextArea();

		//设置textField可操作性
		grade.setEditable(true);
		info.setEditable(true);
		
		//设置textField大小
		grade.setPrefSize(200, 30);
		info.setPrefSize(200, 30);
		
		//右侧pane添加组件
		rightPane.getChildren().add(grade);
		rightPane.getChildren().add(info);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(grade, 200.0);
		AnchorPane.setLeftAnchor(info, 200.0);
				
		AnchorPane.setTopAnchor(grade, 150.0);
		AnchorPane.setTopAnchor(info, 200.0);
		
	}
	
	private void setButton(){
		
		//初始化Button
		confirm = new Button();
		cancel = new Button();
		
		//设置Button文字
		confirm.setText("确认");
		cancel.setText("取消");
				
		//设置Button大小
		confirm.setPrefSize(100, 40);
		cancel.setPrefSize(100, 40);
		
		//添加listener
		confirm.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		cancel.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		
		//添加Button组件
		rightPane.getChildren().add(confirm);
		rightPane.getChildren().add(cancel);
		
		//设置Button位置
		AnchorPane.setLeftAnchor(confirm, 350.0);
		AnchorPane.setRightAnchor(confirm, 400.0);
		
		AnchorPane.setLeftAnchor(cancel, 200.0);
		AnchorPane.setTopAnchor(cancel, 400.0);
				
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
}
