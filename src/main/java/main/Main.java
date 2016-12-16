package main;


import javafx.application.Application;
import javafx.stage.Stage;
import viewController.AccountController;

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
		/*
		new ClientRunner();
	
		AccountDao ad = RemoteHelper.getInstance().getAccountDao();
		
		try {
			System.out.println(ad.getAccountInfo("00001").getIdentity());
		} catch (RemoteException e) {
			e.printStackTrace();
		}*/
	}
}
