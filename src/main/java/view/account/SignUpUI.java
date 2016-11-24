package view.account;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.helpTools.DefaultNums;

/**
 * 注册界面
 * @author XueWang
 *
 */
public class SignUpUI extends Application {

	public void start (Stage stage){
		
		try{
			
			Parent root = FXMLLoader.load( getClass().getResource("登录界面.fxml") );
			
			Scene scene = new Scene(root , DefaultNums.WIDTH , DefaultNums.HEIGHT);
			
			stage.setScene(scene);
			stage.show();
			
		}catch(Exception e){
			
			e.printStackTrace();
		
		}
		
	}
	
	public static void main(String[] args) {
		Application.launch(SignUpUI.class,args);
	}
	
	
}
