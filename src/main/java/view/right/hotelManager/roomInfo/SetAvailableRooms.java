package view.right.hotelManager.roomInfo;

import Message.ResultMessage;
import Message.RoomType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.helpTools.MessageHelper;
import view.left.HotelManagerUI;
import viewController.HMRoomInfoController;
import vo.RoomVO;

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
	private HotelManagerUI hmui;
	
	ComboBox roomType;
	TextField roomNum;
	TextField initialPrice;
	
	Button modify;
	Button add;
	Button cancel;
	
	public SetAvailableRooms(HMRoomInfoController controller){
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add("/CSS/right.css");
		
		//设置下拉框
		setChoiceBox();
		
		//添加文本框
		setTextField();
		
		//添加按钮
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.setStyle("-fx-background-image:url(\"/infoManagement/录入可用客房_背景.jpg\")");
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		//添加文本框
		
		roomNum = new TextField();
		roomNum.setId("SetAvailableRooms");
		roomNum.setPrefSize(200, 30);
			
		initialPrice = new TextField();
		initialPrice.setId("SetAvailableRooms");
		initialPrice.setPrefSize(200, 30);
				
		//设置文本框内容可更改
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
	
	private void setChoiceBox(){
		
		roomType = new ComboBox(FXCollections.observableArrayList("单人房","标准房","三人房","大床房","套房"));
		roomType.setVisibleRowCount(3);
		roomType.setId("SetAvailableRooms");
		roomType.setPrefSize(200, 30);
		
	}
	
	private void setButton(){
		
		//添加按钮
		modify = new Button("修改");
		modify.setId("SetAvailableRooms");
		modify.setPrefSize(100, 40);
		
		add = new Button("添加");
		add.setId("SetAvailableRooms");
		add.setPrefSize(100, 40);
		
		cancel = new Button("取消");
		cancel.setId("SetAvailableRooms");
		cancel.setPrefSize(100, 40);
		
		//设置按钮位置
		modify.setLayoutX(275);
		modify.setLayoutY(525);
		
		add.setLayoutX(450);
		add.setLayoutY(525);
		
		cancel.setLayoutX(625);
		cancel.setLayoutY(525);
		
		//添加按钮监听
		modify.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				RoomType type = controller.getRoomType();
				String num = roomNum.getText();
				String price = initialPrice.getText();
				try{
					int number = Integer.parseInt(num);
					double initialPrice = Double.parseDouble(price);
					RoomVO roomVO = new RoomVO(controller.getUserId(),type,number,initialPrice);
					if(controller.getModifyRoomResult(roomVO) == ResultMessage.SUCCESS){
						controller.showDialog("修改成功");
						controller.setExistRoomsView();
						controller.getStage().show();
					}else{
						controller.showDialog("修改失败");
					}
				}catch(NumberFormatException e){
					controller.showDialog("输入错误");
				}
			}
					
		});
		
		add.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				//传输vo
				int t = roomType.getSelectionModel().getSelectedIndex();
				RoomType type = null;
				switch(t){
				case 0:
					type = RoomType.SINGLE_ROOM;
					break;
				case 1:
					type = RoomType.STANDARD_ROOM;
					break;
				case 2:
					type = RoomType.TRIPLE_ROOM;
					break;
				case 3:
					type = RoomType.BIGBED_ROOM;
					break;
				case 4:
					type = RoomType.SUITE;
					break;
				case -1:
				default:
					type = null;
					break;
				}
				String num = roomNum.getText();
				String cost = initialPrice.getText();
				boolean result = true;
				try{
					Integer.parseInt(num);
					Double.parseDouble(cost);
				}catch(NumberFormatException e){
					result = false;
				}
				if(result && type != null){
					double price = Double.parseDouble(cost);
					RoomVO roomvo = new RoomVO(controller.getUserId(), type, Integer.parseInt(num), price);
					if(controller.getAddRoomResult(roomvo) == ResultMessage.SUCCESS){
						controller.showDialog("添加房间成功");
						setBlank();
						
					}else{
						controller.showDialog("添加房间失败");
					}
				}else{
					controller.showDialog("输入错误");
				}
				//
			}
					
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				roomNum.setText("");
				initialPrice.setText("");
				controller.setFirstView();
				controller.getStage().show();
			}
					
		});
		
		//添加组件
		rightPane.getChildren().add(modify);
		rightPane.getChildren().add(add);
		rightPane.getChildren().add(cancel);
		
		AnchorPane.setLeftAnchor(modify, 75.0);
		AnchorPane.setLeftAnchor(add, 250.0);
		AnchorPane.setLeftAnchor(cancel, 425.0);
		
		AnchorPane.setTopAnchor(modify, 525.0);
		AnchorPane.setTopAnchor(add, 525.0);
		AnchorPane.setTopAnchor(cancel, 525.0);
	}
	
	public void setText(){
		RoomType type = controller.getRoomType();
		roomType.setValue(MessageHelper.roomTypeToString(type));
		roomType.setEditable(false);
	}
	
	public void setBlank(){
		roomType.setValue("");
		roomNum.setText("");
		initialPrice.setText("");
	}
}
