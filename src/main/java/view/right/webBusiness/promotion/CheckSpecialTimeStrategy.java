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
import viewController.WebBusinessLeftController;
import vo.PromotionVO;

/**
 * 网站营销人员界面_促销策略_查看特殊期间促销策略
 * @author XueWang
 *
 */
public class CheckSpecialTimeStrategy {
	
	private WBPromotionController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui;
	
	TextField startDiscount;
	TextField endDiscount;
	TextField discountRange;
	TextField discountName;
	
	Button revert;
	ArrayList<PromotionVO> promotionList;
	
	public CheckSpecialTimeStrategy(WBPromotionController controller){
		
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
		root.setStyle("-fx-background-image:url(\"/webPromotion/网站促销策略_特殊期间促销策略_查看.jpg\")");
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		controller.setPromotoinList();
		promotionList = controller.getPromotionList();
		int num = controller.getRow();
		
		//添加文本框
		startDiscount = new TextField(String.valueOf(promotionList.get(num).discount));
		startDiscount.setId("CheckSpecialTimeStrategy");
		startDiscount.setPrefSize(200, 30);
				
		endDiscount = new TextField(String.valueOf(promotionList.get(num).discount));
		endDiscount.setId("CheckSpecialTimeStrategy");
		endDiscount.setPrefSize(200, 30);
			
		discountRange = new TextField(String.valueOf(promotionList.get(num).vipLevelDiscount));
		discountRange.setId("CheckSpecialTimeStrategy");
		discountRange.setPrefSize(200, 30);
				
		discountName = new TextField(promotionList.get(num).promotionName);
		discountName.setId("CheckSpecialTimeStrategy");
		discountName.setPrefSize(200, 30);
				
		//设置文本框内容
				
		//设置文本框内容不可更改
		startDiscount.setEditable(false);
		endDiscount.setEditable(false);
		discountRange.setEditable(false);
		discountName.setEditable(false);
				
		//设置文本框位置
		startDiscount.setLayoutX(400);
		startDiscount.setLayoutY(150);
				
		endDiscount.setLayoutX(400);
		endDiscount.setLayoutY(200);
				
		discountRange.setLayoutX(400);
		discountRange.setLayoutY(250);
				
		discountName.setLayoutX(400);
		discountName.setLayoutY(300);
				
		//添加组件
		rightPane.getChildren().add(startDiscount);
		rightPane.getChildren().add(endDiscount);
		rightPane.getChildren().add(discountRange);
		rightPane.getChildren().add(discountName);
				
		AnchorPane.setLeftAnchor(startDiscount, 200.0);
		AnchorPane.setLeftAnchor(endDiscount, 200.0);
		AnchorPane.setLeftAnchor(discountRange, 200.0);
		AnchorPane.setLeftAnchor(discountName, 200.0);
				
		AnchorPane.setTopAnchor(startDiscount, 150.0);
		AnchorPane.setTopAnchor(endDiscount, 200.0);
		AnchorPane.setTopAnchor(discountRange, 250.0);
		AnchorPane.setTopAnchor(discountName, 300.0);
	}
	
	private void setButton(){
		
		//添加按钮
		revert = new Button("返回");
		revert.setId("CheckSpecialTimeStrategy");
		revert.setPrefSize(100, 40);
		
		//设置按钮位置
		revert.setLayoutX(625);
		revert.setLayoutY(525);
		
		//添加按钮监听
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				controller.setExistStrategyView();
				controller.getStage().show();
			}
					
		});
		
		//添加组件
		rightPane.getChildren().add(revert);
				
		AnchorPane.setLeftAnchor(revert, 425.0);
		AnchorPane.setTopAnchor(revert, 525.0);
	}
}
