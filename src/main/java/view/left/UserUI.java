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
 * 客户的左侧导航栏
 * @author XueWang
 *
 */
public class UserUI extends Application{
	
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
		
		Button vip = new Button("会员");
		grid.add(vip, 0, 1);
		
		Button myInfo = new Button("我的信息");
		grid.add(myInfo, 0, 2);
		
		Button myOrder = new Button("我的订单");
		grid.add(myOrder, 0, 3);
		
		Button allOrder = new Button("全部订单");
		grid.add(allOrder, 0, 4);
		
		Button executeOrder = new Button("已执行订单");
		grid.add(executeOrder, 0, 5);
		
		Button unexecuteOrder = new Button("未执行订单");
		grid.add(unexecuteOrder, 0, 6);
		
		Button undoOrder = new Button("撤销订单");
		grid.add(undoOrder, 0, 7);
		
		Button abnormalOrder = new Button("异常订单");
		grid.add(abnormalOrder, 0, 8);
		
		Button orderedHotel = new Button("预定过的酒店");
		grid.add(orderedHotel, 0, 9);
		
		Button changePassword = new Button("修改密码");
		grid.add(changePassword, 0, 10);
		
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
