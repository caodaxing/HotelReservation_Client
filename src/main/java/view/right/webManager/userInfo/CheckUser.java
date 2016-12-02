package view.right.webManager.userInfo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.WebManagerUI;
import viewController.WMUserInfoController;

/**
 * 网站管理人员界面_客户管理_查看客户信息详情
 * @author XueWang
 *
 */
public class CheckUser {

	private WMUserInfoController controller ;
	
	private Scene scene ;
	
	private WebManagerUI webManagerUI = new WebManagerUI();

	private GridPane leftPane ;
	
	private AnchorPane rightPane ;
	
	TextField name;
	TextField phone;
	TextField id;
	TextField credit;
	
	Button modify;
	Button back;
	
	public CheckUser(WMUserInfoController controller){
		
		this.controller = controller;
		
		leftPane = webManagerUI.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		setTextField() ;
		
		setButton() ;
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
	
	}
	
	private void setTextField (){
		
		name = new TextField();
		phone = new TextField();
		id = new TextField();
		credit = new TextField();
		
		name.setPrefSize(200, 30);
		phone.setPrefSize(200, 30);
		id.setPrefSize(200, 30);
		credit.setPrefSize(200, 30);
		
		name.setEditable(false);
		phone.setEditable(false);
		id.setEditable(false);
		credit.setEditable(false);
		
		rightPane.getChildren().add(name);
		rightPane.getChildren().add(phone);
		rightPane.getChildren().add(id);
		rightPane.getChildren().add(credit);
		
		AnchorPane.setLeftAnchor(name, 200.0);
		AnchorPane.setLeftAnchor(phone, 200.0);
		AnchorPane.setLeftAnchor(id, 200.0);
		AnchorPane.setLeftAnchor(credit, 200.0);
		
		AnchorPane.setTopAnchor(name, 150.0);
		AnchorPane.setTopAnchor(phone, 225.0);
		AnchorPane.setTopAnchor(id, 300.0);
		AnchorPane.setTopAnchor(credit, 375.0);
		
	}
	
	private void setButton() {
		
		modify = new Button();
		back = new Button();
		
		modify.setText("修改");
		back.setText("返回");
		
		modify.setPrefSize(100,40);
		back.setPrefSize(100, 40);
		
		modify.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		back.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		
		rightPane.getChildren().add(modify);
		rightPane.getChildren().add(back);
		
		AnchorPane.setLeftAnchor(modify, 150.0);
		AnchorPane.setTopAnchor(modify, 475.0);
		
		AnchorPane.setLeftAnchor(back, 350.0);
		AnchorPane.setTopAnchor(back, 475.0);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
}
