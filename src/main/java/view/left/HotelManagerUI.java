package view.left;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import view.helpTools.DefaultNums;
import viewController.HotelManagerLeftController;

/**
 * 酒店工作人员界面的左侧导航栏
 * @author XueWang
 *
 */
public class HotelManagerUI{
	
	private GridPane pane;
	
	private HotelManagerLeftController leftcontroller;
	
	public HotelManagerUI(HotelManagerLeftController controller){
		this.leftcontroller = controller;
		pane = this.initGridPane();
	}
	
	public GridPane getPane(){
		return pane;
	}
	
	public GridPane initGridPane(){
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.BASELINE_LEFT);
		grid.setVgap(DefaultNums.GAP_HEIGHT);
		
		//Pane pane = new GridPane();
		//Image image = new Image("Image\\index3.jpg", 200, 180, false, true);
		//	ImageView headImage = new ImageView(image);
		//pane.getChildren().add(headImage);
		//grid.add(pane, 0, 0);
		
		Button hotelInfo = new Button("酒店信息");
		hotelInfo.setId("light-button");
		hotelInfo.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(hotelInfo, 0, 1);
		hotelInfo.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setModifyHotelInfoVeiw();
				leftcontroller.getStage().show();
			}
			
		});
		
		Button manageOrder = new Button("管理订单");
		manageOrder.setId("light-button");
		manageOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(manageOrder, 0, 2);
		manageOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setSearchOrderView();
				leftcontroller.getStage().show();
			}
			
		});
		
		Button allOrder = new Button("全部订单");
		allOrder.setId("dark-button");
		allOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(allOrder, 0, 3);
		allOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setOrderListView();
				leftcontroller.getStage().show();
			}
			
		});
		
		Button hasExecuteOrder = new Button("已执行订单");
		hasExecuteOrder.setId("dark-button");
		hasExecuteOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(hasExecuteOrder, 0, 4);
		hasExecuteOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setOrderListView();
				leftcontroller.getStage().show();
			}
			
		});
		
		Button unexecuteOrder = new Button("未执行订单");
		unexecuteOrder.setId("dark-button");
		unexecuteOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(unexecuteOrder, 0, 5);
		unexecuteOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setOrderListView();
				leftcontroller.getStage().show();
			}
			
		});
		
		Button undoOrder = new Button("已撤销订单");
		undoOrder.setId("dark-button");
		undoOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(undoOrder, 0, 6);
		undoOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setOrderListView();
				leftcontroller.getStage().show();
			}
			
		});
		
		Button abnormalOrder = new Button("异常订单");
		abnormalOrder.setId("dark-button");
		abnormalOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(abnormalOrder, 0, 7);
		abnormalOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setOrderListView();
				leftcontroller.getStage().show();
			}
			
		});
		
		Button orderedHotel = new Button("客房信息");
		orderedHotel.setId("dark-button");
		orderedHotel.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(orderedHotel, 0, 8);
		orderedHotel.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setRoomFirstView();
				leftcontroller.getStage().show();
			}
			
		});
		
		Button changePassword = new Button("促销策略");
		changePassword.setId("light-button");
		changePassword.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(changePassword, 0, 9);
		changePassword.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setPromotionFirstView();
				leftcontroller.getStage().show();
			}
			
		});
		
		Button signOut = new Button("注 销");
		signOut.setId("light-button");
		signOut.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(signOut, 0, 10);
		signOut.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				leftcontroller.setFirstUIView();
			}
			
		});
		
		return grid;
	}
	
}
