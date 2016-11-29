package view.right.hotelManager.orderManagement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.helpTools.DefaultNums;
import view.left.HotelManagerUI;

/**
 * 酒店工作人员界面_管理订单_异常订单详情
 * @author XueWang
 *
 */
public class AbnormalOrder extends Application{
	HotelManagerUI hotelManagerUI;
	public AbnormalOrder(HotelManagerUI hotelManagerUI){
		this.hotelManagerUI = hotelManagerUI;
	}
	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene( hotelManagerUI.initGridPane(), DefaultNums.WIDTH, DefaultNums.HEIGHT);
		primaryStage.setScene(scene);
		hotelManagerUI.scene.getStylesheets().add(getClass().getResource("left.css").toExternalForm());
		primaryStage.show();
	}
	
	public static void main(String args[]){
		launch(args);
	}
}
