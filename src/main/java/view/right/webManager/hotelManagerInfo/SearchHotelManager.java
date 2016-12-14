package view.right.webManager.hotelManagerInfo;

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
import viewController.WMHotelManagerInfoController;
import viewController.WebManagerLeftController;

/**
 * 网站管理人员界面_酒店工作人员管理_查询界面
 * @author XueWang
 *
 */
public class SearchHotelManager {

	private WebManagerLeftController controller;
	
	private Scene scene;
	
	private GridPane leftPane;
	
	private AnchorPane rightPane;
	
	private WebManagerUI webManagerUI ;

	TextField hotelManagerID;
	
	Button inquiry;
	
	public SearchHotelManager(WebManagerLeftController controller){
		
		this.controller = controller;

		webManagerUI = new WebManagerUI(controller);
		
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
		

		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/infoManagement/酒店工作人员管理_查询界面背景.jpg\")");
		
	}
	
	public void setButton(){
		
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
				//跳至对应查看界面，直接清空搜索框
				WMHotelManagerInfoController newController = new WMHotelManagerInfoController(controller.getStage(),controller.getUserID());
				newController.setHotelID(hotelManagerID.getText());
				hotelManagerID.setText("");
				newController.setCheckHotelManagerView();
				newController.getStage().show();
			}
			
		});

		//添加组件
		rightPane.getChildren().add(inquiry);
		
		AnchorPane.setLeftAnchor(inquiry, 350.0);
		AnchorPane.setTopAnchor(inquiry, 250.0);
		
	}
	
	public void setTextField(){
		
		//添加文本框
		hotelManagerID = new TextField();
		hotelManagerID.setPrefSize(200, 30);
				
		//设置文本框位置
		hotelManagerID.setLayoutX(375);
		hotelManagerID.setLayoutY(250);
				
		//添加组件
				
		rightPane.getChildren().add(hotelManagerID);
				
		AnchorPane.setLeftAnchor(hotelManagerID, 100.0);
		AnchorPane.setTopAnchor(hotelManagerID, 250.0);
		
	}

	public Scene getScene(){
		
		return scene;
		
	}
	

}
