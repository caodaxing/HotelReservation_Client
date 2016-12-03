package view.right.hotelManager.promotion;

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
import view.left.WebBusinessUI;
import viewController.HMPromotionController;
import viewController.WBPromotionController;

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
	private HotelManagerUI hmui = new HotelManagerUI();
	
	TextField cooperateCompanyName;
	TextField dicountRange;
	TextField discountName;
	
	Button ok;
	Button cancel;
	
	public SetCooperateCompanyStrategy(HMPromotionController controller){
		
		this.controller = controller;
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
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
		
		//ArrayList<String> infoList = controller.getInfoList();
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
						
			}
					
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
						
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
