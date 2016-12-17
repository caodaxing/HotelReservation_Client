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
 * 酒店工作人员界面_促销策略_执行生日促销策略
 * @author XueWang
 *
 */
public class SetBirthdayStrategy {
	
	private HMPromotionController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	TextField discountRange;
	TextField discountName;
	
	Button ok;
	Button cancel;
	
	ArrayList<PromotionVO> promotionList;
	
	public SetBirthdayStrategy(HMPromotionController controller){
		
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
		root.setStyle("-fx-background-image:url(\"/hotelPromotion/酒店促销策略_生日特惠背景.jpg\")");
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		//添加文本框
		discountRange = new TextField();
		discountRange.setId("SetBirthdayStrategy");
		discountRange.setPrefSize(200, 30);
				
		discountName = new TextField();
		discountName.setId("SetBirthdayStrategy");
		discountName.setPrefSize(200, 30);
			
		//设置文本框内容
				
		//设置文本框内容可更改
		discountRange.setEditable(true);
		discountName.setEditable(true);
				
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
		ok = new Button("确认");
		ok.setId("SetBirthdayStrategy");
		ok.setPrefSize(100, 40);
		
		cancel = new Button("取消");
		cancel.setId("SetBirthdayStrategy");
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
				String discount = discountRange.getText();
				String name = discountName.getText();
				
				//
				try{
					double d = Double.parseDouble(discount);
					PromotionVO promotionVO = new PromotionVO(null, controller.getUserId(), name, d);
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
				discountRange.setText("");
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
