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
	
	private AccountController controller ;
	
	private AnchorPane root ;
	
	private Button signIn ;
	
	private Button signUp ;
	
	private Button vistor ;
	
	public FirstUI(AccountController controller){
		
		this.controller = controller;
		
		root = new AnchorPane();
		root.setPrefSize(DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.setStyle("-fx-background-image:url(\"/signImage/首页背景.jpg\")");
		
		setButton();
		
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		scene.getStylesheets().add("/CSS/account.css");
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
		
		signIn.setId("BigButton");
		signUp.setId("BigButton");
		vistor.setId("BigButton");
		
		signIn.setPrefSize(200.0, 50.0);
		signUp.setPrefSize(200.0, 50.0);
		vistor.setPrefSize(200.0, 50.0);
		
		signIn.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setSignInView();
				showStage();
			}
			
		});
		signUp.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setSignUpView();
				showStage();
			}
			
		});
		vistor.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setVistorBlankView();
				showStage();
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
	
	private void showStage(){
		controller.getStage().show();
	}

}
