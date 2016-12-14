package view.right.hotelManager.promotion;

import java.util.ArrayList;

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
import viewController.HMPromotionController;
import vo.PromotionVO;

/**
 * 酒店工作人员界面_促销策略_查看生日促销策略
 * @author XueWang
 *
 */
public class CheckBirthdayStrategy {
	
	private HMPromotionController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	TextField discountRange;
	TextField discountName;
	
	Button revert;
	
	ArrayList<PromotionVO> promotionList;
	
	public CheckBirthdayStrategy(HMPromotionController controller){
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add("/CSS/right.css");
		
		//添加文本框
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
		
		controller.setBirthdayPromotion();
		promotionList = controller.getPromotionList();
		controller.setRow();
		int num = controller.getRow();
		
		//添加文本框
		discountRange = new TextField(String.valueOf(promotionList.get(num).discount));
		discountRange.setId("CheckBirthdayStrategy");
		discountRange.setPrefSize(200, 30);
				
		discountName = new TextField(promotionList.get(num).promotionName);
		discountName.setId("CheckBirthdayStrategy");
		discountName.setPrefSize(200, 30);
			
		//设置文本框内容
				
		//设置文本框内容不可更改
		discountRange.setEditable(false);
		discountName.setEditable(false);
				
		//设置文本框位置
		discountRange.setLayoutX(400);
		discountRange.setLayoutY(150);
				
		discountName.setLayoutX(400);
		discountName.setLayoutY(200);
				
		//添加组件
		rightPane.getChildren().add(discountRange);
		rightPane.getChildren().add(discountName);
				
		AnchorPane.setLeftAnchor(discountRange, 200.0);
		AnchorPane.setLeftAnchor(discountName, 200.0);
				
		AnchorPane.setTopAnchor(discountRange, 150.0);
		AnchorPane.setTopAnchor(discountName, 200.0);
	}
	
	private void setButton(){
		
		//添加按钮
		revert = new Button("返回");
		revert.setId("CheckBirthdayStrategy");
		revert.setPrefSize(100, 40);
		
		//设置按钮位置
		revert.setLayoutX(625);
		revert.setLayoutY(525);
		
		//添加按钮监听
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				controller.setExistStrategy();
				controller.getStage().show();
			}
					
		});
		
		//添加组件
		rightPane.getChildren().add(revert);
		
		AnchorPane.setLeftAnchor(revert, 425.0);
		
		AnchorPane.setTopAnchor(revert, 525.0);
	}
}
