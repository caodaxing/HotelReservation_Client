package view.right.hotelManager.roomInfo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.HotelManagerUI;
import viewController.HMPromotionController;
import viewController.HMRoomInfoController;

/**
 * 酒店工作人员界面_客房管理_录入可用客房
 * @author XueWang
 *
 */
public class SetAvailableRooms {
	
	private HMRoomInfoController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui = new HotelManagerUI();
	
	TextField roomType;
	TextField roomNum;
	TextField initialPrice;
	
	Button ok;
	Button cancel;
	
	public SetAvailableRooms(HMRoomInfoController controller){
		
		this.controller = controller;
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加文本框
		setTextField();
		
		//添加按钮
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		//ArrayList<String> infoList = controller.getInfoList();
		//添加文本框
		roomType = new TextField();
		roomType.setId("SetAvailableRooms");
		roomType.setPrefSize(200, 30);
				
		roomNum = new TextField();
		roomNum.setId("SetAvailableRooms");
		roomNum.setPrefSize(200, 30);
			
		initialPrice = new TextField();
		initialPrice.setId("SetAvailableRooms");
		initialPrice.setPrefSize(200, 30);
				
		//设置文本框内容
				
		//设置文本框内容可更改
		roomType.setEditable(true);
		roomNum.setEditable(true);
		initialPrice.setEditable(true);
				
		//设置文本框位置
		roomType.setLayoutX(400);
		roomType.setLayoutY(150);
				
		roomNum.setLayoutX(400);
		roomNum.setLayoutY(200);
				
		initialPrice.setLayoutX(400);
		initialPrice.setLayoutY(250);
				
		//添加组件
		rightPane.getChildren().add(roomType);
		rightPane.getChildren().add(roomNum);
		rightPane.getChildren().add(initialPrice);
				
		AnchorPane.setLeftAnchor(roomType, 200.0);
		AnchorPane.setLeftAnchor(roomNum, 200.0);
		AnchorPane.setLeftAnchor(initialPrice, 200.0);
				
		AnchorPane.setTopAnchor(roomType, 150.0);
		AnchorPane.setTopAnchor(roomNum, 200.0);
		AnchorPane.setTopAnchor(initialPrice, 250.0);
	}
	
	private void setButton(){
		
		//添加按钮
		ok = new Button("确认");
		ok.setId("SetAvailableRooms");
		ok.setPrefSize(100, 40);
		
		cancel = new Button("取消");
		cancel.setId("SetAvailableRooms");
		cancel.setPrefSize(100, 40);
		
		//设置按钮位置
		ok.setLayoutX(450);
		ok.setLayoutY(525);
		
		cancel.setLayoutX(625);
		cancel.setLayoutY(525);
		
		//添加按钮监听
		ok.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
						
			}
					
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
						
			}
					
		});
		
		//添加组件
		rightPane.getChildren().add(ok);
		rightPane.getChildren().add(cancel);
		
		AnchorPane.setLeftAnchor(ok, 250.0);
		AnchorPane.setLeftAnchor(cancel, 425.0);
		
		AnchorPane.setTopAnchor(ok, 525.0);
		AnchorPane.setTopAnchor(cancel, 525.0);
	}
}
