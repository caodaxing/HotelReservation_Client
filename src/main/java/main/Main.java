package main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import main.rmi.ClientRunner;
import viewController.AccountController;

public class Main extends Application{
	
	@Override
	public void start(Stage stage) {
		
		AccountController accountController = new AccountController(stage);
		accountController.setFirstView();
		stage.setResizable(false);
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                accountController.logout();
            }
        });
		stage.show();
		
	}
	
	public static void main(String[] args) {
		new ClientRunner();
		
		launch(args);
		
	}
}
