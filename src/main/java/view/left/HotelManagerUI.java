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
import viewController.HotelManagerLeftController;

/**
 * 酒店工作人员界面的左侧导航栏
 * @author XueWang
 *
 */
public class HotelManagerUI{
	
	private GridPane pane;
	
	private HotelManagerLeftController controller;
	
	public HotelManagerUI(HotelManagerLeftController controller){
		this.controller = controller;
		pane = this.initGridPane();
	}
	
	public GridPane getPane(){
		return pane;
	}
	
	public GridPane initGridPane(){
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.BASELINE_LEFT);
		grid.setVgap(DefaultNums.GAP_HEIGHT);
		
		Pane pane = new GridPane();
		Image image = new Image("/head/游客头像.png", 200, 180, false, true);
		ImageView headImage = new ImageView(image);
		pane.getChildren().add(headImage);
		grid.add(pane, 0, 0);
		
		Button hotelInfo = new Button("酒店信息");
		hotelInfo.setId("light-button");
		hotelInfo.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(hotelInfo, 0, 1);
		hotelInfo.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				controller.setModifyHotelInfoVeiw();
				controller.getStage().show();
			}
			
		});
		
//		Button setArriveInfo = new Button("线下入住");
//		setArriveInfo.setId("light-button");
//		setArriveInfo.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
//		grid.add(setArriveInfo, 0, 2);
//		setArriveInfo.setOnAction(new EventHandler<ActionEvent>(){
//			
//			@Override
//			public void handle(ActionEvent event) {
//				controller.setSetArriveInfoView();
//				controller.getStage().show();
//			}
//			
//		});
		
		Button allOrder = new Button("全部订单");
		allOrder.setId("dark-button");
		allOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(allOrder, 0, 2);
		allOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				controller.setAllOrderListView();
				controller.getStage().show();
			}
			
		});
		
		Button hasExecuteOrder = new Button("已执行订单");
		hasExecuteOrder.setId("dark-button");
		hasExecuteOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(hasExecuteOrder, 0, 3);
		hasExecuteOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				controller.setHasExecuteOrderListView();
				controller.getStage().show();
			}
			
		});
		
		Button unexecuteOrder = new Button("未执行订单");
		unexecuteOrder.setId("dark-button");
		unexecuteOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(unexecuteOrder, 0, 4);
		unexecuteOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				controller.setunExecuteOrderListView();
				controller.getStage().show();
			}
			
		});
		
		Button undoOrder = new Button("已撤销订单");
		undoOrder.setId("dark-button");
		undoOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(undoOrder, 0, 5);
		undoOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				controller.setUndoOrderListView();
				controller.getStage().show();
			}
			
		});
		
		Button abnormalOrder = new Button("异常订单");
		abnormalOrder.setId("dark-button");
		abnormalOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(abnormalOrder, 0, 6);
		abnormalOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				controller.setAbnormalOrderListView();
				controller.getStage().show();
			}
			
		});
		
		Button orderedHotel = new Button("客房信息");
		orderedHotel.setId("light-button");
		orderedHotel.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(orderedHotel, 0, 7);
		orderedHotel.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				controller.setRoomFirstView();
				controller.getStage().show();
			}
			
		});
		
		Button promotion = new Button("促销策略");
		promotion.setId("light-button");
		promotion.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(promotion, 0, 8);
		promotion.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				controller.setPromotionFirstView();
				controller.getStage().show();
			}
			
		});
		
		Button signOut = new Button("注 销");
		signOut.setId("light-button");
		signOut.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(signOut, 0, 9);
		signOut.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				controller.setFirstUIView();
			}
			
		});
		grid.getStylesheets().add(getClass().getResource("/CSS/left.css").toExternalForm());
		
		return grid;
	}
	
}
