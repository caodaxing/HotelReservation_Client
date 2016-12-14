package view.right.hotelManager.hotelInfo;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.HotelManagerUI;
import viewController.HotelManagerLeftController;

/**
 * 酒店管理人员的右侧空白页
 * @author Rukawa
 *
 */
public class Blank {
	
	private HotelManagerLeftController controller;
	
	private Scene scene;
	
	private GridPane leftPane ;
	private AnchorPane rightPane;
	
	private HotelManagerUI hmui;
	
	public Blank(HotelManagerLeftController controller){
		
		this.controller = controller ;
		hmui = new HotelManagerUI(controller);
		
		leftPane = hmui.getPane();
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
