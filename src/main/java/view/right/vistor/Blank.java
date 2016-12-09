package view.right.vistor;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import view.helpTools.DefaultNums;
import view.left.VistorUI;
import viewController.VistorController;

public class Blank {
	
	private VistorController controller;
	
	private Scene scene;
	
	private GridPane leftPane ;
	
	private VistorUI vistorUI ; 
	
	public Blank(VistorController controller){
		
		this.controller = controller ;
		
		vistorUI = new VistorUI(controller);
		
		leftPane = vistorUI.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		AnchorPane root = new AnchorPane();
		root.setPrefSize(DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.getChildren().add(leftPane);
		AnchorPane.setLeftAnchor(leftPane, 0.0);
		AnchorPane.setTopAnchor(leftPane, 0.0);
		
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}

}
