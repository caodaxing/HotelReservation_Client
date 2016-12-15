package view.right.user.VIP;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import viewController.UserLeftController;
import viewController.UserVIPController;

public class Choose {
	
	private UserLeftController controller ;
	
	private Scene scene;
	
	private UserUI userUI ;
	
	private GridPane leftPane;
	
	private AnchorPane rightPane;
	
	Button normal ;
	Button company ;
	
	public Choose(UserLeftController controller) {
		
		this.controller = controller;
		userUI = new UserUI(controller);
		
		leftPane = userUI.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		setButton();
		
		HBox root = new HBox(leftPane,rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);

		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/vipImage/会员_尚未注册会员界面_背景.jpg\")");
	}
	
	public Scene getScene(){
		
		return scene;
		
	}
	
	private void setButton(){
		
		//初始化Button
		normal = new Button();
		company = new Button();
		
		//设置Button文字
		normal.setText("注册普通会员");
		company.setText("注册企业会员");
		
		//设置Button大小
		normal.setPrefSize(150,50);
		company.setPrefSize(150,50);
		
		//设置listener
		normal.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//跳至注册普通会员
				UserVIPController right = new UserVIPController(controller.getStage(),controller.getUserID());
				right.setRegisterNormalVIPView();
				right.getStage().show();
			}
			
		});
		company.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//跳转注册企业会员界面
				UserVIPController right = new UserVIPController(controller.getStage(),controller.getUserID());
				right.setRegisterCompanyVIPView();
				right.getStage().show();
			}
			
		});
		
		//右侧Pane添加组件
		rightPane.getChildren().add(normal);
		rightPane.getChildren().add(company);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(normal, 100.0);
		AnchorPane.setTopAnchor(normal, 200.0);
		
		AnchorPane.setLeftAnchor(company, 350.0);
		AnchorPane.setTopAnchor(company, 200.0);
		
	}

}
