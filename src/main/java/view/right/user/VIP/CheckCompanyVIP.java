package view.right.user.VIP;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import viewController.UserVIPController;

public class CheckCompanyVIP {

	private UserVIPController controller;
	
	private Scene scene ;
	
	private UserUI userUI = new UserUI();	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	TextField company;
	
	public CheckCompanyVIP(UserVIPController controller){
		
		this.controller = controller;
		
		// 初始化左侧Pane
		leftPane = userUI.getPane() ;
		leftPane.setPrefSize ( DefaultNums.LEFT_WIDTH , DefaultNums.HEIGHT );
		
		//初始化右侧Pane
		rightPane = new AnchorPane();
		rightPane.setPrefSize( DefaultNums.RIGHT_WIDTH , DefaultNums.HEIGHT );
		
		//设置TextField
		setTextField();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		
	}
	
	private void setTextField(){
		
		company = new TextField();
		
		company.setEditable(false);
		
		company.setPrefSize(200, 30);
		
		rightPane.getChildren().add(company);
		
		AnchorPane.setLeftAnchor(company, 250.0);
		AnchorPane.setTopAnchor(company, 150.0);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}

}
