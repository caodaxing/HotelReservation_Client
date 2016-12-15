package view.right.user.myInfo;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import viewController.UserMyInfoController;

public class Blank {

	private UserMyInfoController controller;
	
	private Scene scene;
	
	private GridPane root ;
	
	private UserUI userUI ;
	
	public Blank(UserMyInfoController controller){
		
		this.controller = controller ;
		
		userUI = new UserUI(controller);
		
		root = userUI.getPane();
		root.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);

		root.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/blank/空白背景.jpg\")");
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
}