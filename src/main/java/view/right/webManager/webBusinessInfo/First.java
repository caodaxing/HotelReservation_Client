package view.right.webManager.webBusinessInfo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.WebManagerUI;
import viewController.WMWebBusinessInfoController;

/**
 * 网站管理人员界面_网站营销人员管理_初始界面（选择添加网站营销人员还是查询现有营销人员）
 * @author XueWang
 *
 */
public class First {
	
	private WMWebBusinessInfoController controller ;
	
	private Scene scene;
	
	private WebManagerUI webManagerUI = new WebManagerUI();
	
	private GridPane leftPane;
	
	private AnchorPane rightPane;
	
	Button add ;
	Button modify ;
	
	public First(WMWebBusinessInfoController controller) {
		
		this.controller = controller;
		
		leftPane = webManagerUI.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		setButton();
		
		HBox root = new HBox(leftPane,rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		
		return scene;
		
	}
	
	private void setButton(){
		
		//初始化Button
		add = new Button();
		modify = new Button();
		
		//设置Button文字
		add.setText("添加网站营销人员");
		modify.setText("管理网站营销人员");
		
		//设置Button大小
		add.setPrefSize(150,50);
		modify.setPrefSize(150,50);
		
		//设置listener
		add.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		modify.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		
		//右侧Pane添加组件
		rightPane.getChildren().add(add);
		rightPane.getChildren().add(modify);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(add, 100.0);
		AnchorPane.setTopAnchor(add, 200.0);
		
		AnchorPane.setLeftAnchor(modify, 350.0);
		AnchorPane.setTopAnchor(modify, 200.0);
		
	}

}
