package view.right.user.checkHotel;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import viewController.UserCheckHotelController;

/**
 * 客户界面_查看酒店_酒店详情_历史订单
 * @author XueWang
 *
 */
public class HistoryOrderList {

	private UserCheckHotelController controller;
	
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private UserUI userUI = new UserUI();
	
	Button revert;
	
	Button check;
	
	ScrollBar scroller;
	
	public HistoryOrderList(UserCheckHotelController controller){
		
		this.controller = controller;
		
		leftPane = userUI.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加排序按钮
		setSortButton();
		
		//添加查看按钮
		//需要添加获取HotelVO的数据，4个list，列表每一行都需要4个文本框以及判断是否需要预定按钮
		//需要添加for循环和判断是否添加预定按钮的if语句
		//for循环中还需要添加文本框组件，此处尚未给出
		setCheckButton();
				
		//设置滚动条
		setScroller();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
	private void setSortButton(){
		
		//设置按钮
		revert = new Button("返回");
		revert.setId("searchList");
		revert.setPrefSize(100, 40);
		
		//设置按钮位置
		revert.setLayoutX(650);
		revert.setLayoutY(550);
	
		//添加监听
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
			
		//添加组件
		rightPane.getChildren().add(revert);

		AnchorPane.setLeftAnchor(revert, 450.0);
		AnchorPane.setTopAnchor(revert, 550.0);
	
	}
	
	private void setCheckButton(){
		
		//添加查看按钮
		check = new Button("查看");
		check.setPrefSize(50, 30);

		//设置按钮监听
		check.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//添加组件
		rightPane.getChildren().add(check);
		
		AnchorPane.setLeftAnchor(check, 435.0);
		AnchorPane.setTopAnchor(check, 200.0);
	
	}
	
	private void setScroller(){
		
		//设置滚动条
		scroller = new ScrollBar();
		scroller.setLayoutX(775);
		scroller.setLayoutY(140);
		scroller.setPrefHeight(400);
		scroller.setOrientation(Orientation.VERTICAL);
		scroller.setUnitIncrement(10.0);
		scroller.setBlockIncrement(5.0);
		
		//添加组件
		rightPane.getChildren().add(scroller);
		
		AnchorPane.setLeftAnchor(scroller, 575.0);
		AnchorPane.setTopAnchor(scroller, 140.0);
		
	}
	
}
