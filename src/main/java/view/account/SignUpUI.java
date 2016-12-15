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
 * 注册界面
 * @author XueWang
 *
 */
public class SignUpUI{

	private Scene scene ;
	
	private AccountController controller ;
	
	private AnchorPane root ;
	
	private Button yes ;
	private Button no ;
	
	private TextField name ;
	
	private PasswordField password ;
	private PasswordField rePassword ;
	
	public SignUpUI(AccountController controller){
		
		this.controller = controller;
		
		root = new AnchorPane();
		root.setPrefSize(DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.setStyle("-fx-background-image:url(\"/signImage/注册界面.jpg\")");
		root.getStylesheets().add("/CSS/account.css");
		
		setButton();
		
		setTextField();
		
		setPasswordField();
		
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		
		return scene;
		
	}
	
	public String getID(){
		return name.getText();
	}
	
	public String getPassword(){
		return password.getText();
	}
	
	public String getRePassword(){
		return rePassword.getText();
	}
	
	public void setBlank(){
		name.setText("");
		password.setText("");
		rePassword.setText("");
	}
	
	private void setButton(){
		
		yes = new Button();
		no = new Button();
		
		yes.setText("注册");
		no.setText("取消");
		
		yes.setId("SmallButton");
		no.setId("SmallButton");
		
		yes.setPrefSize(80.0, 30.0);
		no.setPrefSize(80.0, 30.0);
		
		yes.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.register();
			}
			
		});
		no.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setFirstView();
				showStage();
			}
			
		});
		
		root.getChildren().add(yes);
		root.getChildren().add(no);
		
		AnchorPane.setLeftAnchor(yes, 300.0);
		AnchorPane.setLeftAnchor(no, 420.0);
		
		AnchorPane.setTopAnchor(yes, 480.0);
		AnchorPane.setTopAnchor(no, 480.0);
		
	}
	
	private void setTextField(){
		
		name = new TextField();
		
		name.setEditable(true);
		
		name.setPrefSize(150.0, 30.0);
		
		root.getChildren().add(name);
		
		AnchorPane.setLeftAnchor(name, 350.0);
		AnchorPane.setTopAnchor(name, 300.0);
		
	}
	
	private void setPasswordField(){
		
		password = new PasswordField();
		rePassword = new PasswordField();
		
		password.setEditable(true);
		rePassword.setEditable(true);
		
		password.setPrefSize(150.0, 30.0);
		rePassword.setPrefSize(150.0, 30.0);
		
		root.getChildren().add(password);
		root.getChildren().add(rePassword);
		
		AnchorPane.setLeftAnchor(password, 350.0);
		AnchorPane.setLeftAnchor(rePassword, 350.0);
		
		AnchorPane.setTopAnchor(password, 355.0);
		AnchorPane.setTopAnchor(rePassword, 410.0);
	
	}
	
	private void showStage(){
		controller.getStage().show();
	}
	
}
