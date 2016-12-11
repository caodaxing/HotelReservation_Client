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
import viewController.HMPromotionController;

/**
 * 酒店工作人员界面_促销策略_制定三间及以上预订优惠
 * @author XueWang
 *
 */
public class SetThreeRoomsStrategy {
	
	private HMPromotionController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	TextField discountRange;
	TextField discountName;
	
	Button ok;
	Button cancel;
	
	public SetThreeRoomsStrategy(HMPromotionController controller){
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
		
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
		discountRange = new TextField();
		discountRange.setId("SetThreeRoomsStrategy");
		discountRange.setPrefSize(200, 30);
				
		discountName = new TextField();
		discountName.setId("SetThreeRoomsStrategy");
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
		ok.setId("SetThreeRoomsStrategy");
		ok.setPrefSize(100, 40);
		
		cancel = new Button("取消");
		cancel.setId("SetThreeRoomsStrategy");
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
