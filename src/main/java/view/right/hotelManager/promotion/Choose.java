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

/**
 * 酒店工作人员界面_促销策略_选择界面（选择制定哪种促销策略）
 * @author XueWang
 *
 */
public class Choose{

	private HMPromotionController controller ;
	
	private Scene scene;
	
	private HotelManagerUI hmui;
	
	private GridPane leftPane;
	
	private AnchorPane rightPane;
	
	Button birthdayStrategy ;
	Button cooperateCompanyStrategy ;
	Button specialTimeStrategy ;
	Button threeRoomsStrategy ;
	
	public Choose (HMPromotionController controller) {
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add("/CSS/right.css");
		
		setButton();
		
		HBox root = new HBox(leftPane,rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		
		return scene;
		
	}
	
	private void setButton(){
		
		//初始化Button
		birthdayStrategy = new Button();
		cooperateCompanyStrategy = new Button();
		specialTimeStrategy = new Button();
		threeRoomsStrategy = new Button();
		
		//设置Button文字
		birthdayStrategy.setText("制定生日特惠");
		cooperateCompanyStrategy.setText("制定合作企业优惠");
		specialTimeStrategy.setText("制定特殊期间优惠");
		threeRoomsStrategy.setText("制定三间及以上预订优惠");
		
		//设置Button大小
		birthdayStrategy.setPrefSize(150,50);
		cooperateCompanyStrategy.setPrefSize(150,50);
		specialTimeStrategy.setPrefSize(150,50);
		threeRoomsStrategy.setPrefSize(150,50);
		
		//设置listener
		birthdayStrategy.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setSetBirthdayStrategyView();
				controller.getStage().show();
			}
			
		});
		cooperateCompanyStrategy.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setSetCooperateCompanyStrategyView();
				controller.getStage().show();
			}
			
		});
		specialTimeStrategy.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setSetSpecialTimeStrategyView();
				controller.getStage().show();
			}
			
		});
		threeRoomsStrategy.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setSetThreeRoomsStrategyView();
				controller.getStage().show();
			}
			
		});
		
		//右侧Pane添加组件
		rightPane.getChildren().add(birthdayStrategy);
		rightPane.getChildren().add(cooperateCompanyStrategy);
		rightPane.getChildren().add(specialTimeStrategy);
		rightPane.getChildren().add(threeRoomsStrategy);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(birthdayStrategy, 100.0);
		AnchorPane.setTopAnchor(birthdayStrategy, 200.0);
		
		AnchorPane.setLeftAnchor(cooperateCompanyStrategy, 350.0);
		AnchorPane.setTopAnchor(cooperateCompanyStrategy, 200.0);
		
		AnchorPane.setLeftAnchor(specialTimeStrategy, 100.0);
		AnchorPane.setTopAnchor(specialTimeStrategy, 300.0);
		
		AnchorPane.setLeftAnchor(threeRoomsStrategy, 350.0);
		AnchorPane.setTopAnchor(threeRoomsStrategy, 300.0);
		
	}
	
}
