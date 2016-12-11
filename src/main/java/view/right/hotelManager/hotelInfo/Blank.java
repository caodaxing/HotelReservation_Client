package view.right.hotelManager.hotelInfo;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
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
	
	private GridPane root ;
	
	private HotelManagerUI hmui;
	
	public Blank(HotelManagerLeftController controller){
		
		this.controller = controller ;
		hmui = new HotelManagerUI(controller);
		
		root = hmui.getPane();
		root.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
}
