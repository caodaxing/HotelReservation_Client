package view.left;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.helpTools.DefaultNums;

/**
 * 酒店工作人员界面的左侧导航栏
 * @author XueWang
 *
 */
public class HotelManagerUI extends Application implements Left{

	public void refreshLeft(){
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Rookie Travel");
		primaryStage.show();
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.BASELINE_LEFT);
		grid.setVgap(DefaultNums.GAP_HEIGHT);
		
		Pane pane = new GridPane();
		Image image = new Image("Image\\index.jpg");
		ImageView headImage = new ImageView(image);
		pane.getChildren().add(headImage);
		grid.add(pane, 0, 0);
		
		Button hotelInfo = new Button("酒店信息");
		grid.add(hotelInfo, 0, 1);
		
		Button order = new Button("管理订单");
		grid.add(order, 0, 2);
		
		Button allOrder = new Button("全部订单");
		grid.add(allOrder, 0, 3);
		
		Button executeOrder = new Button("已执行订单");
		grid.add(executeOrder, 0, 4);
		
		Button unexecuteOrder = new Button("未执行订单");
		grid.add(unexecuteOrder, 0, 5);
		
		Button undoOrder = new Button("已撤销订单");
		grid.add(undoOrder, 0, 6);
		
		Button abnormalOrder = new Button("异常订单");
		grid.add(abnormalOrder, 0, 7);
		
		Button roomInfo = new Button("客房信息");
		grid.add(roomInfo, 0, 8);
		
		Button promotionStrategy = new Button("促销策略");
		grid.add(promotionStrategy, 0, 9);
		
		Button signOut = new Button("注销");
		grid.add(signOut, 0, 11);
		
		Scene scene = new Scene(grid, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
