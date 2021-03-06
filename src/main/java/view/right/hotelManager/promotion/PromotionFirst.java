package view.right.hotelManager.promotion;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.HotelManagerUI;
import viewController.HMPromotionController;
import viewController.HotelManagerLeftController;

/**
 * 酒店工作人员界面_促销策略_初始界面（选择查看现有策略还是制定新策略）
 * @author XueWang
 *
 */
public class PromotionFirst {
	
	private HotelManagerLeftController controller;
	private HMPromotionController hmcontroller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	Button checkNowName;
	Button makeNewPromotion;
	
	public PromotionFirst(HotelManagerLeftController controller){
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add("/CSS/right.css");
		
		//添加按钮
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.setStyle("-fx-background-image:url(\"/hotelPromotion/酒店促销策略_初始界面背景.jpg\")");
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setButton(){
		
		//添加按钮
		checkNowName = new Button("查看现有策略");
		checkNowName.setId("First");
		checkNowName.setPrefSize(150, 50);
		
		makeNewPromotion = new Button("制定新策略");
		makeNewPromotion.setId("First");
		makeNewPromotion.setPrefSize(150, 50);
		
		//设置按钮位置
		checkNowName.setLayoutX(300);
		checkNowName.setLayoutY(250);
		
		makeNewPromotion.setLayoutX(550);
		makeNewPromotion.setLayoutY(250);
		
		//添加按钮监听
		checkNowName.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				hmcontroller = new HMPromotionController(controller.getStage(),controller.getUserId());
				hmcontroller.setExistStrategy();
				hmcontroller.getStage().show();
			}
							
		});
		
		makeNewPromotion.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				hmcontroller = new HMPromotionController(controller.getStage(),controller.getUserId());
				hmcontroller.setChooseView();
				hmcontroller.getStage().show();
			}
							
		});
		
		//添加组件
		rightPane.getChildren().add(checkNowName);
		rightPane.getChildren().add(makeNewPromotion);
		
		AnchorPane.setLeftAnchor(checkNowName, 100.0);
		AnchorPane.setLeftAnchor(makeNewPromotion, 350.0);
		
		AnchorPane.setTopAnchor(checkNowName, 250.0);
		AnchorPane.setTopAnchor(makeNewPromotion, 250.0);
		
	}
}
