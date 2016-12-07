package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.right.hotelManager.roomInfo.ExistRooms;
import viewController.HMRoomInfoController;

public class Main extends Application{
	
	@Override
	public void start(Stage stage) {
		
//		ExecuteOrder executeOrder = new ExecuteOrder(new UserMyOrderController());
//		
//		Scene scene = executeOrder.getScene();
		
		ExistRooms hotelInfo = new ExistRooms(new HMRoomInfoController());
		Scene scene = hotelInfo.getScene();
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
