package view.right.user.VIP;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import viewController.UserVIPController;

public class CheckNormalVIP {

	private UserVIPController controller;
	
	private Scene scene ;
	
	private UserUI userUI = new UserUI();	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	DatePicker birthday ;
	
	public CheckNormalVIP(UserVIPController controller){
		
		this.controller = controller;
		
		// 初始化左侧Pane
		leftPane = userUI.getPane() ;
		leftPane.setPrefSize ( DefaultNums.LEFT_WIDTH , DefaultNums.HEIGHT );
		
		//初始化右侧Pane
		rightPane = new AnchorPane();
		rightPane.setPrefSize( DefaultNums.RIGHT_WIDTH , DefaultNums.HEIGHT );
		
		setDatePicker();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		
	}
	
	private void setDatePicker(){
		
		birthday = new DatePicker();

		birthday.setEditable(false);
		
		birthday.setValue(LocalDate.now());
		
		birthday.setPrefSize(200, 30);
		
		rightPane.getChildren().add(birthday);
		
		AnchorPane.setLeftAnchor(birthday, 200.0);
		AnchorPane.setTopAnchor(birthday, 150.0);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
}
