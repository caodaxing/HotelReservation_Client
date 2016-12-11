package view.right.webBusiness.promotion;

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

/**
 * 网站营销人员界面_促销策略_选择界面（选择生成哪种促销策略）
 * @author XueWang
 *
 */
public class Choose {
	
	private WBPromotionController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui;
	
	Button VIPTradingDiscount;
	Button VIPLevelDiscount;
	Button specialDayDiscount;
	
	public Choose(WBPromotionController controller){
		
		this.controller = controller;
		wbui = new WebBusinessUI(controller);
		
		leftPane = wbui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加按钮
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setButton(){
		
		//添加按钮
		VIPTradingDiscount = new Button("VIP特定商圈折扣");
		VIPTradingDiscount.setId("Choose");
		VIPTradingDiscount.setPrefSize(150, 50);
		
		VIPLevelDiscount = new Button("制定VIP等级折扣");
		VIPLevelDiscount.setId("Choose");
		VIPLevelDiscount.setPrefSize(150, 50);
		
		specialDayDiscount = new Button("制定特殊期间折扣");
		specialDayDiscount.setId("Choose");
		specialDayDiscount.setPrefSize(150, 50);
		
		//设置按钮位置
		VIPTradingDiscount.setLayoutX(300);
		VIPTradingDiscount.setLayoutY(200);
		
		VIPLevelDiscount.setLayoutX(550);
		VIPLevelDiscount.setLayoutY(200);
		
		specialDayDiscount.setLayoutX(300);
		specialDayDiscount.setLayoutY(300);
				
		//添加按钮监听
		VIPTradingDiscount.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				controller.setSetVIPAreaStrategyView();
				controller.getStage().show();
			}
							
		});
		
		VIPLevelDiscount.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				controller.setSetVIPStrategyView();
				controller.getStage().show();
			}
							
		});
		
		specialDayDiscount.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				controller.setSetSpecialTimeStrategyView();
				controller.getStage().show();
			}
							
		});
		
		//添加组件
		rightPane.getChildren().add(VIPTradingDiscount);
		rightPane.getChildren().add(VIPLevelDiscount);
		rightPane.getChildren().add(specialDayDiscount);
		
		
		AnchorPane.setLeftAnchor(VIPTradingDiscount, 100.0);
		AnchorPane.setLeftAnchor(VIPLevelDiscount, 350.0);
		AnchorPane.setLeftAnchor(specialDayDiscount, 100.0);
		
		AnchorPane.setTopAnchor(VIPTradingDiscount, 200.0);
		AnchorPane.setTopAnchor(VIPLevelDiscount, 200.0);
		AnchorPane.setTopAnchor(specialDayDiscount, 300.0);
	}
	
}
