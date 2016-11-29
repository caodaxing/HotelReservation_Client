package view.left;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import view.helpTools.DefaultNums;

/**
 * 酒店工作人员界面的左侧导航栏
 * @author XueWang
 *
 */
public class HotelManagerUI{
	
	private GridPane pane;
	
	public HotelManagerUI(){
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
		Image image = new Image("Image\\index3.jpg", 200, 180, false, true);
		ImageView headImage = new ImageView(image);
		pane.getChildren().add(headImage);
		grid.add(pane, 0, 0);
		
		Button HotelInfo = new Button("酒店信息");
		HotelInfo.setId("light-button");
		HotelInfo.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(HotelInfo, 0, 1);
		
		Button manageOrder = new Button("管理订单");
		manageOrder.setId("light-button");
		manageOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(manageOrder, 0, 2);
		
		Button allOrder = new Button("全部订单");
		allOrder.setId("dark-button");
		allOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(allOrder, 0, 3);
		
		Button hasExecuteOrder = new Button("已执行订单");
		hasExecuteOrder.setId("dark-button");
		hasExecuteOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(hasExecuteOrder, 0, 4);
		
		Button unexecuteOrder = new Button("未执行订单");
		unexecuteOrder.setId("dark-button");
		unexecuteOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(unexecuteOrder, 0, 5);
		
		Button undoOrder = new Button("已撤销订单");
		undoOrder.setId("dark-button");
		undoOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(undoOrder, 0, 6);
		
		Button abnormalOrder = new Button("异常订单");
		abnormalOrder.setId("dark-button");
		abnormalOrder.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(abnormalOrder, 0, 7);
		
		Button orderedHotel = new Button("客房信息");
		orderedHotel.setId("dark-button");
		orderedHotel.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(orderedHotel, 0, 8);
		
		Button changePassword = new Button("促销策略");
		changePassword.setId("light-button");
		changePassword.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(changePassword, 0, 9);
		
		Button signOut = new Button("注 销");
		signOut.setId("light-button");
		signOut.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(signOut, 0, 10);
		
		return grid;
	}
	
}
