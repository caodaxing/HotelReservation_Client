package view.right.vistor;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import view.helpTools.DefaultNums;
import view.left.VistorUI;
import viewController.VistorController;

public class Blank {
	
	private VistorController controller;
	
	private Scene scene;
	
	private GridPane root ;
	
	private VistorUI vistorUI = new VistorUI();
	
	public Blank(VistorController controller){
		
		this.controller = controller ;
		
		root = vistorUI.getPane();
		root.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}

}
