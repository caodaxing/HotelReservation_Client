package view.right.hotelManager.promotion;

import Message.ResultMessage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
 * 酒店工作人员界面_促销策略_制定特定时间优惠
 * @author XueWang
 *
 */
public class SetSpecialTimeStrategy {
	
	private HMPromotionController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	DatePicker startTime;
	DatePicker endTime;
	TextField discountRange;
	TextField discountName;
	
	Button ok;
	Button cancel;
	
	public SetSpecialTimeStrategy(HMPromotionController controller){
		
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
		root.setStyle("-fx-background-image:url(\"/webPromotion/网站促销策略_特殊期间促销策略背景.jpg\")");
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		//添加文本框
		startTime = new DatePicker();
		startTime.setId("SetSpecialTimeStrategy");
		startTime.setPrefSize(200, 30);
				
		endTime = new DatePicker();
		endTime.setId("SetSpecialTimeStrategy");
		endTime.setPrefSize(200, 30);
			
		discountRange = new TextField();
		discountRange.setId("SetSpecialTimeStrategy");
		discountRange.setPrefSize(200, 30);
				
		discountName = new TextField();
		discountName.setId("SetSpecialTimeStrategy");
		discountName.setPrefSize(200, 30);
				
		//设置文本框内容
				
		//设置文本框内容可更改
		startTime.setEditable(true);
		endTime.setEditable(true);
		discountRange.setEditable(true);
		discountName.setEditable(true);
				
		//设置文本框位置
		startTime.setLayoutX(400);
		startTime.setLayoutY(150);
				
		endTime.setLayoutX(400);
		endTime.setLayoutY(200);
				
		discountRange.setLayoutX(400);
		discountRange.setLayoutY(250);
				
		discountName.setLayoutX(400);
		discountName.setLayoutY(300);
				
		//添加组件
		rightPane.getChildren().add(startTime);
		rightPane.getChildren().add(endTime);
		rightPane.getChildren().add(discountRange);
		rightPane.getChildren().add(discountName);
				
		AnchorPane.setLeftAnchor(startTime, 200.0);
		AnchorPane.setLeftAnchor(endTime, 200.0);
		AnchorPane.setLeftAnchor(discountRange, 200.0);
		AnchorPane.setLeftAnchor(discountName, 200.0);
				
		AnchorPane.setTopAnchor(startTime, 150.0);
		AnchorPane.setTopAnchor(endTime, 200.0);
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
				String starttime = startTime.getValue().toString();
				String endtime = endTime.getValue().toString();
				String discount = discountRange.getText();
				String name = discountName.getText();
				PromotionVO promotionVO = new PromotionVO(null, controller.getUserId(), 
						name, Double.parseDouble(discount), starttime, endtime);
				//
				if(controller.getPromotionResult(promotionVO) == ResultMessage.SUCCESS){
//					startTime.setValue();
//					endTime.setValue("");
					discountRange.setText("");
					discountName.setText("");
					OneButtonDialog dialog = new OneButtonDialog("制定成功");
					dialog.show();
					controller.setChooseView();
					controller.getStage().show();
				}else{
					OneButtonDialog dialog = new OneButtonDialog("制定失败");
					dialog.show();
				}
			}
					
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
//				startTime.setText("");
//				endTime.setText("");
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
