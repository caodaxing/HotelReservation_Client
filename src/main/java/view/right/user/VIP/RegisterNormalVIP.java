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

public class RegisterNormalVIP {

	private UserVIPController controller;
	
	private Scene scene ;
	
	private UserUI userUI = new UserUI();	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	DatePicker birthday ;
	
	Button confirm ;
	Button cancel ;
	
	public RegisterNormalVIP(UserVIPController controller){
		
		this.controller = controller;
		
		// 初始化左侧Pane
		leftPane = userUI.getPane() ;
		leftPane.setPrefSize ( DefaultNums.LEFT_WIDTH , DefaultNums.HEIGHT );
		
		//初始化右侧Pane
		rightPane = new AnchorPane();
		rightPane.setPrefSize( DefaultNums.RIGHT_WIDTH , DefaultNums.HEIGHT );
		
		setDatePicker();
		
		//设置Button
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		
	}
	
	private void setDatePicker(){
		
		birthday = new DatePicker();

		birthday.setEditable(true);
		
		birthday.setValue(LocalDate.now());
		
		birthday.setPrefSize(200, 30);
		
		rightPane.getChildren().add(birthday);
		
		AnchorPane.setLeftAnchor(birthday, 200.0);
		AnchorPane.setTopAnchor(birthday, 150.0);
		
	}
	
	private void setButton(){
		
		//初始化Button
		confirm = new Button();
		cancel = new Button();
		
		//设置Button文字
		confirm.setText("确认");
		cancel.setText("取消");
				
		//设置Button大小
		confirm.setPrefSize(100, 40);
		cancel.setPrefSize(100, 40);
		
		//添加listener
		confirm.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		cancel.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		
		//添加Button组件
		rightPane.getChildren().add(confirm);
		rightPane.getChildren().add(cancel);
		
		//设置Button位置
		AnchorPane.setLeftAnchor(confirm, 200.0);
		AnchorPane.setTopAnchor(confirm, 450.0);
		
		AnchorPane.setLeftAnchor(cancel, 400.0);
		AnchorPane.setTopAnchor(cancel, 450.0);
	
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
}