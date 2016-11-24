package view.account;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 注册界面
 * @author XueWang
 *
 */
public class SignUpUI {

	public void start (Stage stage){
		
		try{
			
			Parent root = FXMLLoader.load( getClass().getResource("登录界面.fxml") );
			
			Scene scene = new Scene(root , 800 , 600);
			
			stage.setScene(scene);
			stage.show();
			
		}catch(Exception e){
			
			e.printStackTrace();
		
		}
		
	}
	
}
