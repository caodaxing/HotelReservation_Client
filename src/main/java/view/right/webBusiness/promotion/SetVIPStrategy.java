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
 * 网站营销人员界面_促销策略_制定VIP专属折扣
 * @author XueWang
 *
 */
public class SetVIPStrategy {
	
	private WBPromotionController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui;
	
	TextField VIP1DiscountRange;
	TextField VIP2DiscountRange;
	TextField VIP3DiscountRange;
	TextField discountName;
	
	Button cancel;
	Button ok;
	
	public SetVIPStrategy(WBPromotionController controller){
		
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
		root.setStyle("-fx-background-image:url(\"/webPromotion/网站促销策略_VIP折扣背景.jpg\")");
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		//添加文本框
		VIP1DiscountRange = new TextField();
		VIP1DiscountRange.setId("SetVIPStrategy");
		VIP1DiscountRange.setPrefSize(200, 30);
				
		VIP2DiscountRange = new TextField();
		VIP2DiscountRange.setId("SetVIPStrategy");
		VIP2DiscountRange.setPrefSize(200, 30);
			
		VIP3DiscountRange = new TextField();
		VIP3DiscountRange.setId("SetVIPStrategy");
		VIP3DiscountRange.setPrefSize(200, 30);
				
		discountName = new TextField();
		discountName.setId("SetVIPStrategy");
		discountName.setPrefSize(200, 30);
				
		//设置文本框内容
				
		//设置文本框内容不可更改
		VIP1DiscountRange.setEditable(true);
		VIP2DiscountRange.setEditable(true);
		VIP3DiscountRange.setEditable(true);
		discountName.setEditable(true);
				
		//设置文本框位置
		VIP1DiscountRange.setLayoutX(400);
		VIP1DiscountRange.setLayoutY(150);
				
		VIP2DiscountRange.setLayoutX(400);
		VIP2DiscountRange.setLayoutY(200);
				
		VIP3DiscountRange.setLayoutX(400);
		VIP3DiscountRange.setLayoutY(250);
				
		discountName.setLayoutX(400);
		discountName.setLayoutY(300);
				
		//添加组件
		rightPane.getChildren().add(VIP1DiscountRange);
		rightPane.getChildren().add(VIP2DiscountRange);
		rightPane.getChildren().add(VIP3DiscountRange);
		rightPane.getChildren().add(discountName);
				
		AnchorPane.setLeftAnchor(VIP1DiscountRange, 200.0);
		AnchorPane.setLeftAnchor(VIP2DiscountRange, 200.0);
		AnchorPane.setLeftAnchor(VIP3DiscountRange, 200.0);
		AnchorPane.setLeftAnchor(discountName, 200.0);
				
		AnchorPane.setTopAnchor(VIP1DiscountRange, 150.0);
		AnchorPane.setTopAnchor(VIP2DiscountRange, 200.0);
		AnchorPane.setTopAnchor(VIP3DiscountRange, 250.0);
		AnchorPane.setTopAnchor(discountName, 300.0);
	}
	
	private void setButton(){
		
		//添加按钮
		ok = new Button("确认");
		ok.setId("CheckVIPStrategy");
		ok.setPrefSize(100, 40);
		
		cancel = new Button("取消");
		cancel.setId("CheckVIPStrategy");
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
				//传输vo
				try{
					double d1 = Double.parseDouble(VIP1DiscountRange.getText());
					double d2 = Double.parseDouble(VIP2DiscountRange.getText());
					double d3 = Double.parseDouble(VIP3DiscountRange.getText());
					double[] d = {d1,d2,d3};
					String s = discountName.getText();
					PromotionVO promotionVO = new PromotionVO(null, s, d);
					if(controller.getAddPromotionResult(promotionVO) == ResultMessage.SUCCESS){
						Prompt prompt = new Prompt("添加成功");
						prompt.show();
						controller.setChooseView();
						controller.getStage().show();
					}else{
						Prompt prompt = new Prompt("添加失败");
						prompt.show();
					}
				}catch(NumberFormatException e){
					controller.showDialog("折扣输入错误");
				}
				
			}
					
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
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
