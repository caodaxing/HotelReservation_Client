package view.right.user.myInfo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import viewController.UserMyInfoController;

/**
 * 客户界面_我的信息_修改基本信息
 * @author XueWang
 *
 */
public class ModifyMyInfo {

	private UserMyInfoController controller ;
	
	private Scene scene ;
	
	private UserUI userUI = new UserUI();

	private GridPane leftPane ;
	
	private AnchorPane rightPane ;
	
	TextField name;
	TextField phone;
	TextField id;
	//头像待修改，or放弃？
	TextField head ;
	
	Button confirm;
	Button cancel;
	
	public ModifyMyInfo(UserMyInfoController controller){
		
		this.controller = controller;
		
		leftPane = userUI.getPane();
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
		head = new TextField();
		
		name.setPrefSize(200, 30);
		phone.setPrefSize(200, 30);
		id.setPrefSize(200, 30);
		head.setPrefSize(200, 30);
		
		name.setEditable(true);
		phone.setEditable(true);
		id.setEditable(true);
		head.setEditable(true);
		
		rightPane.getChildren().add(name);
		rightPane.getChildren().add(phone);
		rightPane.getChildren().add(id);
		rightPane.getChildren().add(head);
		
		AnchorPane.setLeftAnchor(name, 200.0);
		AnchorPane.setLeftAnchor(phone, 200.0);
		AnchorPane.setLeftAnchor(id, 200.0);
		AnchorPane.setLeftAnchor(head, 200.0);
		
		AnchorPane.setTopAnchor(name, 150.0);
		AnchorPane.setTopAnchor(phone, 225.0);
		AnchorPane.setTopAnchor(id, 300.0);
		AnchorPane.setTopAnchor(head, 375.0);
		
	}
	
	private void setButton() {
		
		confirm = new Button();
		cancel = new Button();
		
		confirm.setText("确认");
		cancel.setText("取消");
		
		confirm.setPrefSize(100, 40);
		cancel.setPrefSize(100, 40);
		
		confirm.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		cancel.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		
		rightPane.getChildren().add(confirm);
		rightPane.getChildren().add(cancel);
		
		AnchorPane.setLeftAnchor(confirm, 150.0);
		AnchorPane.setTopAnchor(confirm, 475.0);
		
		AnchorPane.setLeftAnchor(cancel, 350.0);
		AnchorPane.setTopAnchor(cancel, 475.0);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
}
