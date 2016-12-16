package main;


import java.rmi.RemoteException;

import dataDao.account.AccountDao;
import javafx.application.Application;
import javafx.stage.Stage;
import main.rmi.ClientRunner;
import main.rmi.RemoteHelper;
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
//		launch(args);
		
		new ClientRunner();
	
		AccountDao ad = RemoteHelper.getInstance().getAccountDao();
		
		try {
			System.out.println(ad.getAccountInfo("00001").getIdentity());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
