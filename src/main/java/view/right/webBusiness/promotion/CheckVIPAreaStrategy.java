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
 * 网站营销人员界面_促销策略_查看会员特定商圈折扣策略
 * @author XueWang
 *
 */
public class CheckVIPAreaStrategy {
	
	private WBPromotionController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui;
	
	TextField lowestVIPLevel;
	TextField tradingArea;
	TextField discountRange;
	TextField discountName;
	
	Button revert;
	
	private static final int 
	TEXTFIELD_WIDTH = 200,//文本框的宽度
	TEXTFIELD_HEIGHT = 30,//文本框的高度
	TEXTFIELD_START_HORIZONTAL = 400,//文本框X起始位置
	TEXTFIELD_START_VERTICAL = 150,//文本框Y起始位置
	TEXTFIELD_GAP = 50,//文本框之间的间隔
	BUTTON_WIDTH = 100,//按钮宽
	BUTTON_HEIGHT = 40,//按钮高
	BUTTON_START_HORIZONTAL = 625,//按钮X起始位置
	BUTTON_START_VERTICAL = 525;//按钮Y起始位置
	
	public CheckVIPAreaStrategy(WBPromotionController controller){
		
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
		
		//ArrayList<String> orderInfoList = controller.getInfoList();
		
		//初始化文本框
		lowestVIPLevel = new TextField();
		tradingArea = new TextField();
		discountRange = new TextField();
		discountName = new TextField();
		
		lowestVIPLevel.setId("CheckVIPAreaStrategy");
		tradingArea.setId("CheckVIPAreaStrategy");
		discountRange.setId("CheckVIPAreaStrategy");
		discountName.setId("CheckVIPAreaStrategy");
		/*
		//根据Controller设置textField文字
		
		*/
		
		//设置文本框内容不可更改
		lowestVIPLevel.setEditable(false);
		tradingArea.setEditable(false);
		discountRange.setEditable(false);
		discountName.setEditable(false);
		
		//设置文本框大小
		lowestVIPLevel.setPrefSize(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		tradingArea.setPrefSize(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		discountRange.setPrefSize(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		discountName.setPrefSize(TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		
		//设置文本框位置
		lowestVIPLevel.setLayoutX(TEXTFIELD_START_HORIZONTAL);
		lowestVIPLevel.setLayoutY(TEXTFIELD_START_VERTICAL);
		
		tradingArea.setLayoutX(TEXTFIELD_START_HORIZONTAL);
		tradingArea.setLayoutY(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP);
		
		discountRange.setLayoutX(TEXTFIELD_START_HORIZONTAL);
		discountRange.setLayoutY(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP*2);
		
		discountName.setLayoutX(TEXTFIELD_START_HORIZONTAL);
		discountName.setLayoutY(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP*3);
		
		
		//右侧pane添加组件
		rightPane.getChildren().add(lowestVIPLevel);
		rightPane.getChildren().add(tradingArea);
		rightPane.getChildren().add(discountRange);
		rightPane.getChildren().add(discountName);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(lowestVIPLevel, TEXTFIELD_START_HORIZONTAL - (double)DefaultNums.LEFT_WIDTH);
		AnchorPane.setLeftAnchor(tradingArea, TEXTFIELD_START_HORIZONTAL - (double)DefaultNums.LEFT_WIDTH);
		AnchorPane.setLeftAnchor(discountRange, TEXTFIELD_START_HORIZONTAL - (double)DefaultNums.LEFT_WIDTH);
		AnchorPane.setLeftAnchor(discountName, TEXTFIELD_START_HORIZONTAL - (double)DefaultNums.LEFT_WIDTH);
						
		AnchorPane.setTopAnchor(lowestVIPLevel, (double)TEXTFIELD_START_VERTICAL);
		AnchorPane.setTopAnchor(tradingArea, (double)(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP));
		AnchorPane.setTopAnchor(discountRange, (double)(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP*2));
		AnchorPane.setTopAnchor(discountName, (double)(TEXTFIELD_START_VERTICAL + TEXTFIELD_GAP*3));
		
	}
	
	private void setButton(){
		
		//添加按钮
		revert = new Button("返回");
		revert.setId("CheckVIPAreaStrategy");
		revert.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		
		//设置按钮位置
		revert.setLayoutX(BUTTON_START_HORIZONTAL);
		revert.setLayoutY(BUTTON_START_VERTICAL);
		
		//设置按钮监听
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				controller.setCheckVIPAreaStrategyView();
				controller.getStage().show();
			}
			
		});
		
		//右侧pane添加
		rightPane.getChildren().add(revert);
		
		AnchorPane.setLeftAnchor(revert, BUTTON_START_HORIZONTAL - (double)DefaultNums.LEFT_WIDTH);
		AnchorPane.setTopAnchor(revert, (double)BUTTON_START_VERTICAL);
	}
}
