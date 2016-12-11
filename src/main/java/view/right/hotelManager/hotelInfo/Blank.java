package view.right.hotelManager.hotelInfo;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import view.helpTools.DefaultNums;
import view.left.HotelManagerUI;
import viewController.HMHotelInfoController;

/**
 * 酒店管理人员的右侧空白页
 * @author Rukawa
 *
 */
public class Blank {
	
	private HMHotelInfoController controller;
	
	private Scene scene;
	
	private GridPane root ;
	
	private HotelManagerUI hmUI = new HotelManagerUI();
	
	public Blank(HMHotelInfoController controller){
		
		this.controller = controller ;
		
		root = hmUI.getPane();
		root.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
}
