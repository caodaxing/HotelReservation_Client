package view.right.user.checkHotel;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import view.helpTools.DefaultNums;
import view.left.UserUI;

/**
 * 客户界面_查看酒店_搜索结果列表
 * @author XueWang
 *
 */
public class SearchResultList extends Application{
	
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
	
	public void start(Stage primaryStage){
		
		primaryStage.setTitle("Rookie Travel");
		
		leftPane = userui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加按钮
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
		
		check = new Button("查看");
		check.setId("searchList");
		check.setPrefSize(50, 30);
		
		reserve = new Button("预定");
		reserve.setId("searchList");
		reserve.setPrefSize(50, 30);
		
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
		
		check.setLayoutX(635);
		check.setLayoutY(200);
		
		reserve.setLayoutX(695);
		reserve.setLayoutY(200);
		
		revert.setLayoutX(650);
		revert.setLayoutY(550);
		
		//设置滚动条
		scroller = new ScrollBar();
		scroller.setLayoutX(775);
		scroller.setLayoutY(140);
		scroller.setPrefHeight(400);
		scroller.setOrientation(Orientation.VERTICAL);
		scroller.setUnitIncrement(10.0);
		scroller.setBlockIncrement(5.0);
		
		//添加组件
		rightPane.getChildren().add(ascendingSort);
		rightPane.getChildren().add(dscendingSort);
		rightPane.getChildren().add(starLevel);
		rightPane.getChildren().add(evaluation);
		rightPane.getChildren().add(check);
		rightPane.getChildren().add(reserve);
		rightPane.getChildren().add(revert);
		rightPane.getChildren().add(scroller);
		
		AnchorPane.setLeftAnchor(ascendingSort, 150.0);
		AnchorPane.setLeftAnchor(dscendingSort, 250.0);
		AnchorPane.setLeftAnchor(starLevel, 350.0);
		AnchorPane.setLeftAnchor(evaluation, 450.0);
		AnchorPane.setLeftAnchor(check, 435.0);
		AnchorPane.setLeftAnchor(reserve, 495.0);
		AnchorPane.setLeftAnchor(revert, 450.0);
		AnchorPane.setLeftAnchor(scroller, 575.0);
		
		AnchorPane.setTopAnchor(ascendingSort, 100.0);
		AnchorPane.setTopAnchor(dscendingSort, 100.0);
		AnchorPane.setTopAnchor(starLevel, 100.0);
		AnchorPane.setTopAnchor(evaluation, 100.0);
		AnchorPane.setTopAnchor(check, 200.0);
		AnchorPane.setTopAnchor(reserve, 200.0);
		AnchorPane.setTopAnchor(revert, 550.0);
		AnchorPane.setTopAnchor(scroller, 140.0);
		
		
		HBox root = new HBox(leftPane, rightPane);
		HBox.setHgrow(leftPane, Priority.ALWAYS);
		scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String args[]){
		launch(args);
	}
}
