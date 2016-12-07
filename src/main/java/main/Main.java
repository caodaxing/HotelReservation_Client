package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.right.hotelManager.promotion.First;
import viewController.HMPromotionController;

public class Main extends Application{
	
	@Override
	public void start(Stage stage) {
		
//		ExecuteOrder executeOrder = new ExecuteOrder(new UserMyOrderController());
//		
//		Scene scene = executeOrder.getScene();
		First first = new First(new HMPromotionController(stage));
		Scene scene = first.getScene();
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
