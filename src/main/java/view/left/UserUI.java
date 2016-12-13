package view.left;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import view.helpTools.DefaultNums;
import viewController.UserLeftController;
import viewController.UserMyInfoController;

/**
 * 客户的左侧导航栏
 * @author XueWang
 *
 */
public class UserUI{

	private GridPane pane;
	private UserLeftController controller;
	
	public UserUI(UserLeftController controller){
		this.controller = controller ;
		pane = this.initGridPane();
	}
	
	public GridPane getPane(){
		return pane;
	}
	
	public GridPane initGridPane( ){
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.BASELINE_LEFT);
		grid.setVgap(DefaultNums.GAP_HEIGHT);
		
		Pane pane = new GridPane();
		Image image = new Image("/hotelImage/index.jpg", 200, 200, false, true);
		ImageView headImage = new ImageView(image);
		pane.getChildren().add(headImage);
		grid.add(pane, 0, 0);
		
		Button vip = new Button("会 员");
		vip.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setVIPView();
				controller.getStage().show();
			}
			
		});
		vip.setId("light-button");
		vip.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(vip, 0, 1);
		
		Button myInfo = new Button("我的信息 ");
		myInfo.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setCheckMyInfoView();
				controller.getStage().show();
			}
			
		});
		myInfo.setId("light-button");
		myInfo.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(myInfo, 0, 2);
		
		Button myOrder = new Button("我的订单 ");
		myOrder.setId("light-button");
		myOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setOrderFirstView();
				controller.getStage().show();
			}
			
		});
		myOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(myOrder, 0, 3);
		
		Button allOrder = new Button("全部订单");
		allOrder.setId("dark-button");
		allOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setAllOrderList();
				controller.getStage().show();
			}
			
		});
		allOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(allOrder, 0, 4);
		
		Button executeOrder = new Button("已执行订单");
		executeOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setExecuteOrderList();
				controller.getStage().show();
			}
			
		});
		executeOrder.setId("dark-button");
		executeOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(executeOrder, 0, 5);
		
		Button unexecuteOrder = new Button("未执行订单");
		unexecuteOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setUnexecuteOrderList();
				controller.getStage().show();
			}
			
		});
		unexecuteOrder.setId("dark-button");
		unexecuteOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(unexecuteOrder, 0, 6);
		
		Button undoOrder = new Button("撤销订单");
		undoOrder.setId("dark-button");
		undoOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setUndoOrderList();
				controller.getStage().show();
			}
			
		});
		undoOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(undoOrder, 0, 7);
		
		Button abnormalOrder = new Button("异常订单");
		abnormalOrder.setId("dark-button");
		abnormalOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setAbnormalOrderList();
				controller.getStage().show();
			}
			
		});
		abnormalOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(abnormalOrder, 0, 8);
		
		Button orderedHotel = new Button("查看酒店");
		orderedHotel.setId("dark-button");
		orderedHotel.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setHotelFirstView();
				controller.getStage().show();
			}
			
		});
		orderedHotel.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(orderedHotel, 0, 9);
		
		Button changePassword = new Button("修改密码");
		changePassword.setId("light-button");
		changePassword.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setModifyPasswordView();
				controller.getStage().show();
			}
			
		});
		changePassword.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(changePassword, 0, 10);
		
		Button signOut = new Button("注 销");
		signOut.setId("light-button");
		signOut.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setFirstView();
			}
			
		});
		signOut.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(signOut, 0, 11);
		
		grid.getStylesheets().add("/CSS/left.css");
		
		return grid;
	}
}
