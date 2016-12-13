package main;

import javafx.application.Application;
import javafx.stage.Stage;
import viewController.AccountController;
import viewController.WBVIPInfoController;

public class Main extends Application{
	
	@Override
	public void start(Stage stage) {
		
		AccountController accountController = new AccountController(stage);
		accountController.setFirstView();
		stage.setResizable(false);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
