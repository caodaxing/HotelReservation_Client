package view.right.hotelManager.promotion;

import java.util.ArrayList;

import Message.ResultMessage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.helpTools.OneButtonDialog;
import view.left.HotelManagerUI;
import viewController.HMPromotionController;
import vo.PromotionVO;

/**
 * 酒店工作人员界面_促销策略_制定合作企业促销策略
 * @author XueWang
 *
 */
public class SetCooperateCompanyStrategy {
	
	private HMPromotionController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	TextField cooperateCompanyName;
	TextField dicountRange;
	TextField discountName;
	
	Button ok;
	Button cancel;
	
	ArrayList<PromotionVO> promotionVO;
	
	public SetCooperateCompanyStrategy(HMPromotionController controller){
		
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
		root.setStyle("-fx-background-image:url(\"/hotelPromotion/酒店促销策略_合作企业优惠背景.jpg\")");
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		//添加文本框
		cooperateCompanyName = new TextField();
		cooperateCompanyName.setId("SetCooperateCompanyStrategy");
		cooperateCompanyName.setPrefSize(200, 30);
				
		dicountRange = new TextField();
		dicountRange.setId("SetCooperateCompanyStrategy");
		dicountRange.setPrefSize(200, 30);
			
		discountName = new TextField();
		discountName.setId("SetCooperateCompanyStrategy");
		discountName.setPrefSize(200, 30);
				
		//设置文本框内容
				
		//设置文本框内容可更改
		cooperateCompanyName.setEditable(true);
		dicountRange.setEditable(true);
		discountName.setEditable(true);
				
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
		ok = new Button("确认");
		ok.setId("SetCooperateCompanyStrategy");
		ok.setPrefSize(100, 40);
		
		cancel = new Button("取消");
		cancel.setId("SetCooperateCompanyStrategy");
		cancel.setPrefSize(100, 40);
		
		//设置按钮位置
		ok.setLayoutX(450);
		ok.setLayoutY(525);
		
		cancel.setLayoutX(625);
		cancel.setLayoutY(525);
		
		//添加按钮监听
		ok.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				//传输vo
				String companyName = cooperateCompanyName.getText();
				String discount = dicountRange.getText();
				String promotionName = discountName.getText();
				//
				try{
					double d = Double.parseDouble(discount);
					PromotionVO promotionVO = new PromotionVO(null, controller.getUserId(), promotionName, d, companyName);
					if(d<=0 || d>=1){
						controller.showDialog("折扣输入错误");
					}else if(controller.getPromotionResult(promotionVO) == ResultMessage.SUCCESS){
						controller.showDialog("制定成功");
						controller.setChooseView();
						controller.getStage().show();
					}else{
						controller.showDialog("制定失败");
					}
				}catch(NumberFormatException e){
					controller.showDialog("折扣输入错误");
				}
				
			}
					
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				cooperateCompanyName.setText("");
				dicountRange.setText("");
				discountName.setText("");
				controller.setChooseView();
				controller.getStage().show();
			}
					
		});
		
		//添加组件
		rightPane.getChildren().add(ok);
		rightPane.getChildren().add(cancel);
		
		AnchorPane.setLeftAnchor(ok, 250.0);
		AnchorPane.setLeftAnchor(cancel, 425.0);
		
		AnchorPane.setTopAnchor(ok, 525.0);
		AnchorPane.setTopAnchor(cancel, 525.0);
	}
}
