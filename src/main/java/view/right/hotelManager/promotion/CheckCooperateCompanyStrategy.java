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
 * 酒店工作人员界面_促销策略_查看合作企业促销策略
 * @author XueWang
 *
 */
public class CheckCooperateCompanyStrategy {
	
	private HMPromotionController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	TextField cooperateCompanyName;
	TextField dicountRange;
	TextField discountName;
	
	Button revert;
	ArrayList<PromotionVO> promotionList;
	
	public CheckCooperateCompanyStrategy(HMPromotionController controller){
		
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
		root.setStyle("-fx-background-image:url(\"/hotelPromotion/酒店促销策略_合作企业优惠_查看.jpg\")");
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		//添加文本框
		cooperateCompanyName = new TextField();
		cooperateCompanyName.setId("CheckCooperateCompanyStrategy");
		cooperateCompanyName.setPrefSize(200, 30);
				
		dicountRange = new TextField();
		dicountRange.setId("CheckCooperateCompanyStrategy");
		dicountRange.setPrefSize(200, 30);
			
		discountName = new TextField();
		discountName.setId("CheckCooperateCompanyStrategy");
		discountName.setPrefSize(200, 30);
				
		//设置文本框内容
				
		//设置文本框内容不可更改
		cooperateCompanyName.setEditable(false);
		dicountRange.setEditable(false);
		discountName.setEditable(false);
				
		//设置文本框位置
		cooperateCompanyName.setLayoutX(400);
		cooperateCompanyName.setLayoutY(150);
				
		dicountRange.setLayoutX(400);
		dicountRange.setLayoutY(200);
				
		discountName.setLayoutX(400);
		discountName.setLayoutY(250);
				
		//添加组件
		rightPane.getChildren().add(cooperateCompanyName);
		rightPane.getChildren().add(dicountRange);
		rightPane.getChildren().add(discountName);
				
		AnchorPane.setLeftAnchor(cooperateCompanyName, 200.0);
		AnchorPane.setLeftAnchor(dicountRange, 200.0);
		AnchorPane.setLeftAnchor(discountName, 200.0);
				
		AnchorPane.setTopAnchor(cooperateCompanyName, 150.0);
		AnchorPane.setTopAnchor(dicountRange, 200.0);
		AnchorPane.setTopAnchor(discountName, 250.0);
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
	
	public void setText(){
		PromotionVO vo = controller.getPromotionVO();
		cooperateCompanyName.setText(vo.cooperateBusiness);
		dicountRange.setText(String.valueOf(vo.discount));
		discountName.setText(vo.promotionName);
	}
}
