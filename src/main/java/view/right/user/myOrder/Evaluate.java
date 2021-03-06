package view.right.user.myOrder;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.UserUI;
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
	
	private ChoiceBox grade;
	
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
		
		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/hotelAndOrder/查看订单_评价界面背景.jpg\")");
	}
	
	private void setText(){
		
		//初始化textField
		grade = new ChoiceBox(FXCollections.observableArrayList("1","2","3","4","5"));
		info = new TextArea();

		//设置textField可操作性
		grade.setValue("5");
		info.setEditable(true);
		
		//设置textField大小
		grade.setPrefSize(100, 30);
		info.setPrefSize(250, 150);
		
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
				//评价
				controller.evaluate();
				controller.getStage().show();
			}
			
		});
		cancel.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//返回首页并清空
				controller.setExecuteOrderView();
				controller.getStage().show();
			}
			
		});
		
		//添加Button组件
		rightPane.getChildren().add(confirm);
		rightPane.getChildren().add(cancel);
		
		//设置Button位置
		AnchorPane.setLeftAnchor(confirm, 200.0);
		AnchorPane.setTopAnchor(confirm, 400.0);
		
		AnchorPane.setLeftAnchor(cancel, 350.0);
		AnchorPane.setTopAnchor(cancel, 400.0);
				
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
	public double getGrade(){
		double grd = grade.getSelectionModel().getSelectedIndex()+1.0;
		return grd;
	}
	
	public String getInfo(){
		//允许置空
		return info.getText();
	}
}
