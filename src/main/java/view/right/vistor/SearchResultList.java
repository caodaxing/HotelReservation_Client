package view.right.vistor;

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
import view.left.VistorUI;
import viewController.UserCheckHotelController;
import viewController.VistorController;

/**
 * 游客界面_查看酒店_搜索结果列表
 * @author XueWang
 *
 */
public class SearchResultList {


	private VistorController controller;
	
	private Scene scene;
	
	private GridPane leftPane;
	
	private AnchorPane rightPane;
	
	private VistorUI vistorUI = new VistorUI();
	
	Button ascendingSort;
	Button dscendingSort;
	Button starLevel;
	Button evaluation;
	
	Button check;
	//游客不能预订
	
	Button revert;
	
	ScrollBar scroller;
	
	ArrayList<String> hotelNameList;
	ArrayList<String> judgeReserve;
	ArrayList<String> starList;
	ArrayList<String> evaluationList;
	
	public SearchResultList(VistorController controller){
		
		this.controller = controller;
		
		leftPane = vistorUI.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加排序按钮
		setSortButton();
		
		//添加查看按钮
		setCheckButton();
				
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
		
		//设置按钮监听
		ascendingSort.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		dscendingSort.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		starLevel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		evaluation.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
			
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
		check.setPrefSize(100, 30);
		
		//设置查看按钮位置
		check.setLayoutX(635);
		check.setLayoutY(200);
		
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
	
	public void setScroller(){
		
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
