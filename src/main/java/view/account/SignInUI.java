package view.account;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import view.helpTools.DefaultNums;
import viewController.AccountController;

/**
 * 登录界面
 * @author XueWang
 *
 */
public class SignInUI{

	private Scene scene ;
	
	private AnchorPane root ;
	
	private Button yes ;
	private Button no ;
	
	private TextField name ;
	
	private PasswordField password ;
	
	public SignInUI(AccountController controller){
		
		root = new AnchorPane();
		root.setPrefSize(DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
		setButton();
		
		setTextField();
		
		setPasswordField();
		
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		
		return scene;
		
	}
	
	private void setButton(){
		
		yes = new Button();
		no = new Button();
		
		yes.setText("登录");
		no.setText("取消");
		
		yes.setPrefSize(80.0, 30.0);
		no.setPrefSize(80.0, 30.0);
		
		yes.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		no.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		
		root.getChildren().add(yes);
		root.getChildren().add(no);
		
		AnchorPane.setLeftAnchor(yes, 350.0);
		AnchorPane.setLeftAnchor(no, 420.0);
		
		AnchorPane.setTopAnchor(yes, 450.0);
		AnchorPane.setTopAnchor(no, 450.0);
		
	}
	
	private void setTextField(){
		
		name = new TextField();
		
		name.setEditable(true);
		
		name.setPrefSize(150.0, 30.0);
		
		root.getChildren().add(name);
		
		AnchorPane.setLeftAnchor(name, 350.0);
		AnchorPane.setTopAnchor(name, 325.0);
		
	}
	
	private void setPasswordField(){
		
		password = new PasswordField();
		
		password.setEditable(true);
		
		password.setPrefSize(150.0, 30.0);
		
		root.getChildren().add(password);
		
		AnchorPane.setLeftAnchor(password, 350.0);
		AnchorPane.setTopAnchor(password, 375.0);
		
	}
	
}
