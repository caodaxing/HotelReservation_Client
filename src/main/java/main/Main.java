package main;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;

import dataDao.account.AccountDao;
import dataDao.picture.PictureDao;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import main.rmi.ClientRunner;
import main.rmi.RemoteHelper;
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
		
//		AccountDao ad = RemoteHelper.getInstance().getAccountDao();
//		
//		PictureDao pictureDao = RemoteHelper.getInstance().getPictureDao();
//		
//		String imgFile = "d:\\PictureDatabase\\00001\\1.jpg";  
//        
//		try {
//			System.out.println(pictureDao.saveImage(PictureHelper.imageToBytes(imgFile), "12345", "1"));
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
	}
}
