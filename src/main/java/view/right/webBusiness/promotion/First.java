package view.right.webBusiness.promotion;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import view.helpTools.DefaultNums;
import view.left.WebBusinessUI;
import viewController.WBPromotionController;

/**
 * 网站营销人员界面_促销策略_初始界面（选择查看现有策略还是制定新策略）
 * @author XueWang
 *
 */
public class First {
	
	private WBPromotionController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui = new WebBusinessUI();
	
	Button checkNowName;
	Button makeNewPromotion;
	
	public First(WBPromotionController controller){
		
		this.controller = controller;
		
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
				controller.setExistStrategyView();
				Stage stage = controller.getStage();
				stage.show();
			}
							
		});
		
		makeNewPromotion.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				controller.setChooseView();
				Stage stage = controller.getStage();
				stage.show();
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
