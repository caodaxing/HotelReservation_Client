package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.right.hotelManager.promotion.First;
import viewController.AccountController;
import viewController.HMPromotionController;

public class Main extends Application{
	
	@Override
	public void start(Stage stage) {
		
		AccountController accountController = new AccountController(stage);
		accountController.setFirstView();
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
