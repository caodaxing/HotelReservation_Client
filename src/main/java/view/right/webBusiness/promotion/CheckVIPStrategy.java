package view.right.webBusiness.promotion;

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
import view.left.WebBusinessUI;
import viewController.WBPromotionController;
import vo.PromotionVO;

/**
 * 网站营销人员界面_促销策略_查看VIP专属折扣
 * @author XueWang
 *
 */
public class CheckVIPStrategy {
	
	private WBPromotionController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui;
	
	TextField VIP1DiscountRange;
	TextField VIP2DiscountRange;
	TextField VIP3DiscountRange;
	TextField discountName;
	
	Button revert;
	ArrayList<PromotionVO> promotionList;
	
	public CheckVIPStrategy(WBPromotionController controller){
		
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
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		controller.setPromotoinList();
		promotionList = controller.getPromotionList();
		int num = controller.getRow();
		//添加文本框
		VIP1DiscountRange = new TextField(String.valueOf(promotionList.get(num).discount));
		VIP1DiscountRange.setId("CheckVIPStrategy");
		VIP1DiscountRange.setPrefSize(200, 30);
				
		VIP2DiscountRange = new TextField(String.valueOf(promotionList.get(num).discount));
		VIP2DiscountRange.setId("CheckVIPStrategy");
		VIP2DiscountRange.setPrefSize(200, 30);
			
		VIP3DiscountRange = new TextField(String.valueOf(promotionList.get(num).discount));
		VIP3DiscountRange.setId("CheckVIPStrategy");
		VIP3DiscountRange.setPrefSize(200, 30);
				
		discountName = new TextField(promotionList.get(num).promotionName);
		discountName.setId("CheckVIPStrategy");
		discountName.setPrefSize(200, 30);
				
		//设置文本框内容
				
		//设置文本框内容不可更改
		VIP1DiscountRange.setEditable(false);
		VIP2DiscountRange.setEditable(false);
		VIP3DiscountRange.setEditable(false);
		discountName.setEditable(false);
				
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
		revert = new Button("返回");
		revert.setId("CheckVIPStrategy");
		revert.setPrefSize(100, 40);
		
		//设置按钮位置
		revert.setLayoutX(625);
		revert.setLayoutY(525);
		
		//添加按钮监听
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				controller.setCheckVIPStrategyView();
				controller.getStage().show();
			}
					
		});
		
		//添加组件
		rightPane.getChildren().add(revert);
				
		AnchorPane.setLeftAnchor(revert, 425.0);
		AnchorPane.setTopAnchor(revert, 525.0);
	}
}
