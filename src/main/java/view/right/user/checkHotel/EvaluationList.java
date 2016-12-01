package view.right.user.checkHotel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import viewController.UserCheckHotelController;

/**
 * 客户界面_查看酒店_酒店详情_评价列表
 * @author XueWang
 *
 */
public class EvaluationList {

	private UserCheckHotelController controller;
	
	private Scene scene;
	
	private GridPane leftPane;
	private AnchorPane rightPane;
	
	private UserUI userui = new UserUI();
	
	Button check;

	Button revert;
	
	//ScrollBar scroller;
	
	TableView table ;
	
	public EvaluationList(UserCheckHotelController controller){
		
		this.controller = controller;
		
		leftPane = userui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加按钮
		setButton();
				
		//设置滚动条
		//setScroller();
		
		//添加列表
		setTable();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setButton(){
		
		//设置按钮
		check = new Button("查看");
		check.setId("searchList");

		check.setPrefSize(100, 30);
		
		revert = new Button("返回");
		revert.setId("searchList");
		revert.setPrefSize(100, 40);
		
		/*
		//设置按钮位置
		check.setLayoutX(635);
		check.setLayoutY(200);

		revert.setLayoutX(650);
		revert.setLayoutY(550);
		*/
		
		//设置listener
		check.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		revert.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		
		//添加组件
		rightPane.getChildren().add(check);
		rightPane.getChildren().add(revert);
		
		AnchorPane.setLeftAnchor(check, 435.0);
		AnchorPane.setLeftAnchor(revert, 450.0);
		
		AnchorPane.setTopAnchor(check, 200.0);
		AnchorPane.setTopAnchor(revert, 550.0);
		
	}
	
	/*
	  private void setScroller(){
		
		//设置滚动条
		scroller = new ScrollBar();
		scroller.setLayoutX(775);
		scroller.setLayoutY(140);
		scroller.setPrefHeight(400);
		scroller.setOrientation(Orientation.VERTICAL);
		scroller.setUnitIncrement(10.0);
		scroller.setBlockIncrement(5.0);
		
		//添加滚动条
		rightPane.getChildren().add(scroller);
		AnchorPane.setLeftAnchor(scroller, 575.0);
		AnchorPane.setTopAnchor(scroller, 140.0);
		
	}
	*/
	
	private void setTable(){

		table = new TableView<String>();
		
		table.setEditable(false);
		
        TableColumn orderID = new TableColumn("订单号");
        TableColumn roomType = new TableColumn("房间类型");
        TableColumn arriveTime = new TableColumn("入住时间");
        TableColumn evaluation = new TableColumn("评分");
 
        table.getColumns().addAll(orderID , roomType , arriveTime , evaluation );
        
        rightPane.getChildren().add(table);
        
        AnchorPane.setLeftAnchor(table, 80.0);
        AnchorPane.setTopAnchor(table, 175.0);
        
	}
	
}
