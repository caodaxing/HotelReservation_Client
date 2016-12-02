package view.right.webManager.webBusinessInfo;

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
import viewController.WMWebBusinessInfoController;

/**
 * 网站管理人员界面_网站营销人员管理_查询界面
 * @author XueWang
 *
 */
public class SearchWebBusiness {
	
	private WMWebBusinessInfoController controller;
	
	private Scene scene;
	
	private GridPane leftPane;
	
	private AnchorPane rightPane;
	
	private WebManagerUI webManagerUI = new WebManagerUI();
	
	TextField webBusinessID;
	
	Button inquiry;
	
	public SearchWebBusiness(WMWebBusinessInfoController controller){
		
		this.controller = controller;
		
		leftPane = webManagerUI.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加按钮
		setButton();
		
		//添加文本框
		setTextField();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
	}
	
	private void setButton(){
		
		//添加按钮
		inquiry = new Button("查询");
		inquiry.setPrefSize(100, 30);
		
		//设置按钮位置
		inquiry.setLayoutX(375);
		inquiry.setLayoutY(330);
		
		//添加按钮监听
		inquiry.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});

		//添加组件
		rightPane.getChildren().add(inquiry);
		
		AnchorPane.setLeftAnchor(inquiry, 175.0);
		AnchorPane.setTopAnchor(inquiry, 330.0);
		
	}
	
	private void setTextField(){
		
		//添加文本框
		webBusinessID = new TextField();
		webBusinessID.setPrefSize(250, 30);
				
		//设置文本框位置
		webBusinessID.setLayoutX(375);
		webBusinessID.setLayoutY(250);
				
		//添加组件
				
		rightPane.getChildren().add(webBusinessID);
				
		AnchorPane.setLeftAnchor(webBusinessID, 175.0);
		AnchorPane.setTopAnchor(webBusinessID, 250.0);
		
	}

	public Scene getScene(){
		
		return scene;
		
	}
	
}
