package view.right.webBusiness.promotion;

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
import view.left.WebBusinessUI;
import viewController.WBPromotionController;
import vo.PromotionVO;

/**
 * 网站营销人员界面_促销策略_制定特殊期间促销策略
 * @author XueWang
 *
 */
public class SetSpecialTimeStrategy {
	
	private WBPromotionController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui;
	
	TextField startDiscountTime;
	TextField endDiscountTime;
	TextField discountRange;
	TextField discountName;
	
	Button ok;
	Button cancel;
	
	public SetSpecialTimeStrategy(WBPromotionController controller){
		
		this.controller = controller;
		wbui = new WebBusinessUI(controller);
		
		leftPane = wbui.getPane();
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
		root.setStyle("-fx-background-image:url(\"/webPromotion/网站促销策略_特殊期间促销策略背景.jpg\")");
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		//添加文本框
		startDiscountTime = new TextField();
		startDiscountTime.setId("SetSpecialTimeStrategy");
		startDiscountTime.setPrefSize(200, 30);
				
		endDiscountTime = new TextField();
		endDiscountTime.setId("SetSpecialTimeStrategy");
		endDiscountTime.setPrefSize(200, 30);
			
		discountRange = new TextField();
		discountRange.setId("SetSpecialTimeStrategy");
		discountRange.setPrefSize(200, 30);
				
		discountName = new TextField();
		discountName.setId("SetSpecialTimeStrategy");
		discountName.setPrefSize(200, 30);
				
		//设置文本框内容
				
		//设置文本框内容可更改
		startDiscountTime.setEditable(true);
		endDiscountTime.setEditable(true);
		discountRange.setEditable(true);
		discountName.setEditable(true);
				
		//设置文本框位置
		startDiscountTime.setLayoutX(400);
		startDiscountTime.setLayoutY(150);
				
		endDiscountTime.setLayoutX(400);
		endDiscountTime.setLayoutY(200);
				
		discountRange.setLayoutX(400);
		discountRange.setLayoutY(250);
				
		discountName.setLayoutX(400);
		discountName.setLayoutY(300);
				
		//添加组件
		rightPane.getChildren().add(startDiscountTime);
		rightPane.getChildren().add(endDiscountTime);
		rightPane.getChildren().add(discountRange);
		rightPane.getChildren().add(discountName);
				
		AnchorPane.setLeftAnchor(startDiscountTime, 200.0);
		AnchorPane.setLeftAnchor(endDiscountTime, 200.0);
		AnchorPane.setLeftAnchor(discountRange, 200.0);
		AnchorPane.setLeftAnchor(discountName, 200.0);
				
		AnchorPane.setTopAnchor(startDiscountTime, 150.0);
		AnchorPane.setTopAnchor(endDiscountTime, 200.0);
		AnchorPane.setTopAnchor(discountRange, 250.0);
		AnchorPane.setTopAnchor(discountName, 300.0);
	}
	
	private void setButton(){
		
		//添加按钮
		ok = new Button("确认");
		ok.setId("SetSpecialTimeStrategy");
		ok.setPrefSize(100, 40);
		
		cancel = new Button("取消");
		cancel.setId("SetSpecialTimeStrategy");
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
				String s1 = startDiscountTime.getText();
				String s2 = endDiscountTime.getText();
				String s3 = discountRange.getText();
				String s4 = discountName.getText();
				//
				PromotionVO promotionVO = new PromotionVO(null, s4,Double.parseDouble(s3), s1, s2);
				if(controller.getAddPromotionResult(promotionVO) == ResultMessage.SUCCESS){
					startDiscountTime.setText("");
					endDiscountTime.setText("");
					discountRange.setText("");
					discountName.setText("");
					Prompt prompt = new Prompt("保存成功");
					prompt.show();
					controller.setChooseView();
					controller.getStage().show();
				}else{
					Prompt prompt = new Prompt("输入错误");
					prompt.show();
				}
			}
					
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
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
