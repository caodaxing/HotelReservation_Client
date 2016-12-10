package view.right.webManager.userInfo;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import view.helpTools.DefaultNums;
import view.left.WebManagerUI;
import viewController.WMUserInfoController;

public class Blank {

	private WMUserInfoController controller;
	
	private Scene scene;
	
	private GridPane root ;
	
	private WebManagerUI leftUI ;
	
	public Blank(WMUserInfoController controller){
		
		this.controller = controller ;

		leftUI = new WebManagerUI(controller);
		
		root = leftUI.getPane();
		root.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}

}
