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
	
	private UserUI userUI = new UserUI();
	
	public Blank(UserMyInfoController controller){
		
		this.controller = controller ;
		
		root = userUI.getPane();
		root.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
}