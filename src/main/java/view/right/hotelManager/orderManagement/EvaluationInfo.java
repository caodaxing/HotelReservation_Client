package view.right.hotelManager.orderManagement;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.HotelManagerUI;
import viewController.HMOrderManagementController;

/**
 * 酒店工作人员界面_管理订单_已执行订单_评价详情
 * @author XueWang
 *
 */
public class EvaluationInfo {
	
	private HMOrderManagementController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	TextField evaluationGrade;
	TextField evaluation;
	
	Button revert;
	
	public EvaluationInfo(HMOrderManagementController controller){
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加文本内容
		setTextField();
		
		//添加按钮
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		//ArrayList<String> infoList = controller.getInfoList();
		//添加文本框
		
		evaluationGrade = new TextField();
		evaluationGrade.setId("EvaluationInfo");
		evaluationGrade.setPrefSize(100, 30);
		
		evaluation = new TextField();
		evaluation.setId("CheckLeaveInfo");
		evaluation.setPrefSize(250, 100);
		/*
		 * //设置文本框内容
		 * 
		 */
		
		//设置文本框内容不可更改
		evaluationGrade.setEditable(false);
		evaluation.setEditable(false);
		
		//设置文本框位置
		evaluationGrade.setLayoutX(400);
		evaluationGrade.setLayoutY(150);
		
		evaluation.setLayoutX(400);
		evaluation.setLayoutY(225);
		
		//添加组件
		rightPane.getChildren().add(evaluation);
		rightPane.getChildren().add(evaluationGrade);
		
		AnchorPane.setLeftAnchor(evaluation, 200.0);
		AnchorPane.setLeftAnchor(evaluationGrade, 200.0);
		
		AnchorPane.setTopAnchor(evaluationGrade, 150.0);
		AnchorPane.setTopAnchor(evaluation, 225.0);
		
	}

	private void setButton(){
		
		//添加按钮
		
		revert = new Button("返回");
		revert.setId("button-css");
		revert.setPrefSize(100, 40);
				
		//设置按钮位置
		
		revert.setLayoutX(550);
		revert.setLayoutY(400);
		
		
		
		//添加按钮监听
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//添加组件
		rightPane.getChildren().add(revert);
		
		AnchorPane.setLeftAnchor(revert, 350.0);
		
		AnchorPane.setTopAnchor(revert, 400.0);
		
	}
}
