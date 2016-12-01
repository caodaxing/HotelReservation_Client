package view.right.user.checkHotel;

import java.util.ArrayList;

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
 * 客户界面_查看酒店_搜索结果列表
 * @author XueWang
 *
 */
public class SearchResultList{
	
	private UserCheckHotelController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private UserUI userui = new UserUI();
	
	Button ascendingSort;
	Button dscendingSort;
	Button starLevel;
	Button evaluation;
	Button check;
	Button reserve;
	Button revert;
	
	ScrollBar scroller;
	
	ArrayList<String> hotelNameList;
	ArrayList<String> judgeReserve;
	ArrayList<String> starList;
	ArrayList<String> evaluationList;
	
	public SearchResultList(UserCheckHotelController controller){
		
		this.controller = controller;
		
		leftPane = userui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加排序按钮
		setSortButton();
		
		//添加查看，预定按钮
		//需要添加获取HotelVO的数据，4个list，列表每一行都需要4个文本框以及判断是否需要预定按钮
		//需要添加for循环和判断是否添加预定按钮的if语句
		//for循环中还需要添加文本框组件，此处尚未给出
		setCheckButton();
		
		setReserveButton();
				
		//设置滚动条
		setScroller();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		return scene;
	}
	public void setSortButton(){
		
		//设置按钮
		ascendingSort = new Button("价格升序");
		ascendingSort.setId("searchResultList");
		ascendingSort.setPrefSize(60, 30);
		
		dscendingSort = new Button("价格降序");
		dscendingSort.setId("searchResultList");
		dscendingSort.setPrefSize(60, 30);
		
		starLevel = new Button("星级");
		starLevel.setId("searchResultList");
		starLevel.setPrefSize(60, 30);
		
		evaluation = new Button("评价");
		evaluation.setId("searchList");
		evaluation.setPrefSize(60, 30);
		
		revert = new Button("返回");
		revert.setId("searchList");
		revert.setPrefSize(100, 40);
		
		//设置按钮位置
		ascendingSort.setLayoutX(350);
		ascendingSort.setLayoutY(100);
		
		dscendingSort.setLayoutX(450);
		dscendingSort.setLayoutY(100);
		
		starLevel.setLayoutX(550);
		starLevel.setLayoutY(100);
		
		evaluation.setLayoutX(650);
		evaluation.setLayoutY(100);
		
		revert.setLayoutX(650);
		revert.setLayoutY(550);
		
		//添加组件
		rightPane.getChildren().add(ascendingSort);
		rightPane.getChildren().add(dscendingSort);
		rightPane.getChildren().add(starLevel);
		rightPane.getChildren().add(evaluation);
		rightPane.getChildren().add(revert);
		
		AnchorPane.setLeftAnchor(ascendingSort, 150.0);
		AnchorPane.setLeftAnchor(dscendingSort, 250.0);
		AnchorPane.setLeftAnchor(starLevel, 350.0);
		AnchorPane.setLeftAnchor(evaluation, 450.0);
		AnchorPane.setLeftAnchor(revert, 450.0);
		
		AnchorPane.setTopAnchor(ascendingSort, 100.0);
		AnchorPane.setTopAnchor(dscendingSort, 100.0);
		AnchorPane.setTopAnchor(starLevel, 100.0);
		AnchorPane.setTopAnchor(evaluation, 100.0);
		AnchorPane.setTopAnchor(revert, 550.0);
	}
	
	public void setCheckButton(){
		//添加查看按钮
		check = new Button("查看");
		check.setId("searchList");
		check.setPrefSize(50, 30);
		
		//设置查看按钮位置
		check.setLayoutX(635);
		check.setLayoutY(200);
		
		//添加组件
		rightPane.getChildren().add(check);
		
		AnchorPane.setLeftAnchor(check, 435.0);
		AnchorPane.setTopAnchor(check, 200.0);
	}
	
	public void setReserveButton(){
		//添加预定按钮
		reserve = new Button("预定");
		reserve.setId("searchList");
		reserve.setPrefSize(50, 30);
		
		//设置预定按钮位置
		reserve.setLayoutX(695);
		reserve.setLayoutY(200);
		
		//添加组件
		rightPane.getChildren().add(reserve);
		
		AnchorPane.setLeftAnchor(reserve, 495.0);
		AnchorPane.setTopAnchor(reserve, 200.0);
	}
	
	public void setScroller(){
		
		//是指滚动条
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
