package view.right.hotelManager.hotelInfo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.HotelManagerUI;
import viewController.HotelManagerLeftController;

public class ModifyPassword {
	
	private HotelManagerLeftController controller ;
	
	private Scene scene ;
	
	private HotelManagerUI hmui ;

	private GridPane leftPane ;
	
	private AnchorPane rightPane ;
	
	TextField oldPassword;
	PasswordField newPassword;
	PasswordField repeatPassword;
	
	Button yes;
	Button no;
	
	public ModifyPassword(HotelManagerLeftController controller){
		
		this.controller = controller;
		
		hmui = new HotelManagerUI(controller);
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		setTextField() ;
		
		setButton() ;
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
	
		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/infoManagement/修改密码_修改密码界面背景.jpg\")");
	}

	private void setTextField (){
		
		oldPassword = new TextField();
		newPassword = new PasswordField();
		repeatPassword = new PasswordField();
		
		oldPassword.setPrefSize(200, 30);
		newPassword.setPrefSize(200, 30);
		repeatPassword.setPrefSize(200, 30);
		
		oldPassword.setEditable(true);
		newPassword.setEditable(true);
		repeatPassword.setEditable(true);
		
		rightPane.getChildren().add(oldPassword);
		rightPane.getChildren().add(newPassword);
		rightPane.getChildren().add(repeatPassword);
		
		AnchorPane.setLeftAnchor(oldPassword, 200.0);
		AnchorPane.setLeftAnchor(newPassword, 200.0);
		AnchorPane.setLeftAnchor(repeatPassword, 200.0);
		
		AnchorPane.setTopAnchor(oldPassword, 150.0);
		AnchorPane.setTopAnchor(newPassword, 225.0);
		AnchorPane.setTopAnchor(repeatPassword, 300.0);
		
	}
	
	private void setButton() {
		
		yes = new Button();
		no = new Button();
		
		yes.setText("确认");
		no.setText("取消");
		
		yes.setPrefSize(100,40);
		no.setPrefSize(100, 40);
		
		yes.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.modifyPassword();
			}
			
		});
		no.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//取消直接清空textfield
				setBlank();				
			}
			
		});
		
		rightPane.getChildren().add(yes);
		rightPane.getChildren().add(no);
		
		AnchorPane.setLeftAnchor(yes, 150.0);
		AnchorPane.setTopAnchor(yes, 475.0);
		
		AnchorPane.setLeftAnchor(no, 350.0);
		AnchorPane.setTopAnchor(no, 475.0);
		
	}
	
	public void setBlank(){

		oldPassword.setText("");
		newPassword.setText("");
		repeatPassword.setText("");
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
	public String getOldPassword(){
		return oldPassword.getText();
	}
	
	public String getNewPassword(){
		return newPassword.getText();
	}
	
	public String getRepeatPassword(){
		return repeatPassword.getText();
	}
}
