package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.right.vistor.SearchResultList;
import viewController.VistorController;

public class Main extends Application{
	
	@Override
	public void start(Stage stage) {
		
//		ExecuteOrder executeOrder = new ExecuteOrder(new UserMyOrderController());
//		
//		Scene scene = executeOrder.getScene();
		
		SearchResultList roomList = new SearchResultList(new VistorController());
		Scene scene = roomList.getScene();
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
