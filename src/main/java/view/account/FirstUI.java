package view.account;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 打开系统的第一个页面
 * @author XueWang
 *
 */
public class FirstUI {

	public void start (Stage stage){
		
		try{
			
			Parent root = FXMLLoader.load( getClass().getResource("首页.fxml") );
			
			Scene scene = new Scene(root , 800 , 600);
			
			stage.setScene(scene);
			stage.show();
			
		}catch(Exception e){
			
			e.printStackTrace();
		
		}
		
	}
	
}
