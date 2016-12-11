package view.right.webBusiness.VIPInfo;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.WebBusinessUI;
import viewController.WBVIPInfoController;
import viewController.WebBusinessLeftController;

/**
 * 网站营销人员右侧空白页
 * @author Rukawa
 *
 */
public class Blank {
	
	private WBVIPInfoController wbController;
	private WebBusinessLeftController controller;
	private Scene scene;
	
	private GridPane leftPane ;
	private AnchorPane rightPane;
	
	private WebBusinessUI webUI;
	
	public Blank(WebBusinessLeftController controller){
		
		this.controller = controller ;
		webUI = new WebBusinessUI(controller);
		
		leftPane = webUI.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
}
