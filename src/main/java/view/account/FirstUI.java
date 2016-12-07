package view.account;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import view.helpTools.DefaultNums;
import viewController.AccountController;

/**
 * 打开系统的第一个页面
 * @author XueWang
 *
 */
public class FirstUI{
	
	private Scene scene ;
	
	private AnchorPane root ;
	
	private Button signIn ;
	
	private Button signUp ;
	
	private Button vistor ;
	
	public FirstUI(AccountController controller){
		
		root = new AnchorPane();
		root.setPrefSize(DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
		setButton();
		
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		
		return scene;
		
	}
	
	private void setButton(){
		
		signIn = new Button();
		signUp = new Button();
		vistor = new Button();
		
		signIn.setText("用户登录");
		signUp.setText("用户注册");
		vistor.setText("游客浏览");
		
		signIn.setPrefSize(200.0, 50.0);
		signUp.setPrefSize(200.0, 50.0);
		vistor.setPrefSize(200.0, 50.0);
		
		signIn.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		signUp.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		vistor.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		
		root.getChildren().add(signIn);
		root.getChildren().add(signUp);
		root.getChildren().add(vistor);
		
		AnchorPane.setLeftAnchor(signIn, 300.0);
		AnchorPane.setLeftAnchor(signUp, 300.0);
		AnchorPane.setLeftAnchor(vistor, 300.0);
		
		AnchorPane.setTopAnchor(signIn, 300.0);
		AnchorPane.setTopAnchor(signUp, 375.0);
		AnchorPane.setTopAnchor(vistor, 450.0);
		
	}
	
}
