package view.account;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.helpTools.DefaultNums;

/**
 * 打开系统的第一个页面
 * @author XueWang
 *
 */
public class FirstUI extends Application {

	public void start (Stage stage){
		
		try{
			
			Parent root = FXMLLoader.load( getClass().getResource("首页.fxml") );
			
			Scene scene = new Scene(root , DefaultNums.WIDTH , DefaultNums.HEIGHT);
			
			stage.setScene(scene);
			stage.show();
			
		}catch(Exception e){
			
			e.printStackTrace();
		
		}
		
	}
	
	public static void main(String[] args) {
		Application.launch(FirstUI.class,args);
	}
	
}
