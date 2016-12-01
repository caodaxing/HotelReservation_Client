package view.right.user.checkHotel;

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
import viewController.UserMyOrderController;

/**
 * 客户界面_查看酒店_生成订单
 * @author XueWang
 *
 */
public class MakeOrder {

	private UserMyOrderController controller;
	
	private Scene scene ;
	
	private UserUI userUI = new UserUI();	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	TextField roomType ;
	TextField roomNums ; 
	TextField arriveTime ;
	TextField leaveTime ;
	TextField latestTime ;
	TextField peopleNums ;
	TextField haveChild ;
	
	Button makeOrder ;
	Button back ;
	
	public MakeOrder(UserMyOrderController controller){
		
		this.controller = controller;
		
		// 初始化左侧Pane
		leftPane = userUI.getPane() ;
		leftPane.setPrefSize ( DefaultNums.LEFT_WIDTH , DefaultNums.HEIGHT );
		
		//初始化右侧Pane
		rightPane = new AnchorPane();
		rightPane.setPrefSize( DefaultNums.RIGHT_WIDTH , DefaultNums.HEIGHT );
		
		//设置TextField
		setTextField();
		
		//设置Button
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		
	}
	
	private void setTextField(){
		
		//ArrayList<String> infoList = controller.getInfoList();
		
		//初始化textField
		roomType = new TextField();
		roomNums = new TextField();
		arriveTime = new TextField();
		leaveTime = new TextField();
		latestTime = new TextField();
		peopleNums = new TextField();
		haveChild = new TextField();
		/*
		//根据Controller设置textField文字
		roomType.setText(infoList.get(0));
		roomNums.setText(infoList.get(1));
		roomType.setText(infoList.get(2));
		arriveTime.setText(infoList.get(3));
		leaveTime.setText(infoList.get(4));
		originalPrice.setText(infoList.get(5));
		actualPrice.setText(infoList.get(6));
		*/
		//设置textField可操作性
		roomType.setEditable(true);
		roomNums.setEditable(true);
		arriveTime.setEditable(true);
		leaveTime.setEditable(true);
		latestTime.setEditable(true);
		peopleNums.setEditable(true);
		haveChild.setEditable(true);
		
		//设置textField大小
		roomType.setPrefSize(200, 30);
		roomNums.setPrefSize(200, 30);
		arriveTime.setPrefSize(200, 30);
		leaveTime.setPrefSize(200, 30);
		latestTime.setPrefSize(200, 30);
		peopleNums.setPrefSize(200, 30);
		haveChild.setPrefSize(200, 30);
		
		//右侧pane添加组件
		rightPane.getChildren().add(roomType);
		rightPane.getChildren().add(roomNums);
		rightPane.getChildren().add(arriveTime);
		rightPane.getChildren().add(leaveTime);
		rightPane.getChildren().add(latestTime);
		rightPane.getChildren().add(peopleNums);
		rightPane.getChildren().add(haveChild);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(roomType, 200.0);
		AnchorPane.setLeftAnchor(roomNums, 200.0);
		AnchorPane.setLeftAnchor(arriveTime, 200.0);
		AnchorPane.setLeftAnchor(leaveTime, 200.0);
		AnchorPane.setLeftAnchor(latestTime, 200.0);
		AnchorPane.setLeftAnchor(peopleNums, 200.0);
		AnchorPane.setLeftAnchor(haveChild, 200.0);
				
		AnchorPane.setTopAnchor(roomType, 150.0);
		AnchorPane.setTopAnchor(roomNums, 200.0);
		AnchorPane.setTopAnchor(arriveTime, 250.0);
		AnchorPane.setTopAnchor(leaveTime, 300.0);
		AnchorPane.setTopAnchor(latestTime, 350.0);
		AnchorPane.setTopAnchor(peopleNums, 400.0);
		AnchorPane.setTopAnchor(haveChild, 450.0);
		
	}
	
	private void setButton(){
		
		//初始化Button
		makeOrder = new Button();
		back = new Button();
		
		//设置Button文字
		makeOrder.setText("生成订单");
		back.setText("返回");
				
		//设置Button大小
		makeOrder.setPrefSize(100, 40);
		back.setPrefSize(100, 40);
		
		//添加listener
		makeOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		back.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		
		//添加Button组件
		rightPane.getChildren().add(makeOrder);
		rightPane.getChildren().add(back);
		
		//设置Button位置
		AnchorPane.setLeftAnchor(makeOrder, 250.0);
		AnchorPane.setTopAnchor(makeOrder, 525.0);
		
		AnchorPane.setLeftAnchor(back, 425.0);
		AnchorPane.setTopAnchor(back, 525.0);
				
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
}
