package view.right.user.checkHotel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import viewController.UserCheckHotelController;
import viewController.UserLeftController;

/**
 * 客户界面_查看酒店_初始界面（选择查看预定过的酒店还是搜索酒店）
 * @author XueWang
 *
 */
public class HotelFirst{
	
	private UserLeftController controller ;
	
	private Scene scene;
	
	private UserUI userUI;
	
	private GridPane leftPane;
	
	private AnchorPane rightPane;
	
	Button checkHistoryHotel ;
	Button searchNewHotel ;
	
	public HotelFirst(UserLeftController controller) {
		
		this.controller = controller;
		
		userUI = new UserUI(controller);
		
		leftPane = userUI.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		setButton();
		
		HBox root = new HBox(leftPane,rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);

		//添加样式表
		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/hotelAndOrder/查看酒店_选择界面背景.jpg\")");
	}
	
	public Scene getScene(){
		
		return scene;
		
	}
	
	private void setButton(){
		
		//初始化Button
		checkHistoryHotel = new Button();
		searchNewHotel = new Button();
		
		//设置Button文字
		checkHistoryHotel.setText("预定过的酒店");
		searchNewHotel.setText("搜索酒店");
		
		//设置Button大小
		checkHistoryHotel.setPrefSize(150,50);
		searchNewHotel.setPrefSize(150,50);
		
		//设置listener
		checkHistoryHotel.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//历史酒店
				UserCheckHotelController right = new UserCheckHotelController(controller.getStage(),controller.getUserID());
				right.setHistoryHotelListView();
				right.getStage().show();
			}
			
		});
		searchNewHotel.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//搜索酒店界面
				UserCheckHotelController right = new UserCheckHotelController(controller.getStage(),controller.getUserID());
				right.setSearchHotelView();
				right.getStage().show();
			}
			
		});
		
		//右侧Pane添加组件
		rightPane.getChildren().add(checkHistoryHotel);
		rightPane.getChildren().add(searchNewHotel);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(checkHistoryHotel, 100.0);
		AnchorPane.setTopAnchor(checkHistoryHotel, 200.0);
		
		AnchorPane.setLeftAnchor(searchNewHotel, 350.0);
		AnchorPane.setTopAnchor(searchNewHotel, 200.0);
		
	}

}
