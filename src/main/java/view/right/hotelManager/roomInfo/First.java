package view.right.hotelManager.roomInfo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.HotelManagerUI;
import viewController.HMRoomInfoController;
import viewController.HotelManagerLeftController;

/**
 * 酒店工作人员界面_客房管理_初始界面（选择查看现有客房还是录入可用客房）
 * @author XueWang
 *
 */
public class First {
	
	private HotelManagerLeftController controller;
	private HMRoomInfoController hmcontroller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	Button checkNowRoom;
	Button inputAvailableRoom;
	
	public First(HotelManagerLeftController controller){
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add("/CSS/right.css");
		
		//添加按钮
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.setStyle("-fx-background-image:url(\"/infoManagement/客房管理_选择界面背景.jpg\")");
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setButton(){
		
		//添加按钮
		checkNowRoom = new Button("查看当前客房");
		checkNowRoom.setId("First");
		checkNowRoom.setPrefSize(150, 50);
		
		inputAvailableRoom = new Button("录入可用客房");
		inputAvailableRoom.setId("First");
		inputAvailableRoom.setPrefSize(150, 50);
		
		//设置按钮位置
		checkNowRoom.setLayoutX(300);
		checkNowRoom.setLayoutY(250);
		
		inputAvailableRoom.setLayoutX(550);
		inputAvailableRoom.setLayoutY(250);
		
		//添加按钮监听
		checkNowRoom.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				hmcontroller = new HMRoomInfoController(controller.getStage(),controller.getUserId());
				hmcontroller.setExistRoomsView();
				hmcontroller.getStage().show();
			}
							
		});
		
		inputAvailableRoom.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				hmcontroller = new HMRoomInfoController(controller.getStage(),controller.getUserId());
				hmcontroller.setSetAvailableRoomsView();
				hmcontroller.getStage().show();	
			}
							
		});
		
		//添加组件
		rightPane.getChildren().add(checkNowRoom);
		rightPane.getChildren().add(inputAvailableRoom);
		
		AnchorPane.setLeftAnchor(checkNowRoom, 100.0);
		AnchorPane.setLeftAnchor(inputAvailableRoom, 350.0);
		
		AnchorPane.setTopAnchor(checkNowRoom, 250.0);
		AnchorPane.setTopAnchor(inputAvailableRoom, 250.0);
		
	}
}
