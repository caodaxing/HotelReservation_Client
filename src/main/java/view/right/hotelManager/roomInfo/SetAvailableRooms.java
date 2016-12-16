package view.right.hotelManager.roomInfo;

import Message.RoomType;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.helpTools.OneButtonDialog;
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
	
	ChoiceBox roomType;
	TextField roomNum;
	TextField initialPrice;
	
	Button ok;
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
				
		//设置文本框内容
				
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
		
		//待修改，根据controller
		roomType = new ChoiceBox(FXCollections.observableArrayList("单人房","标准房","三人房","大床房","套房"));
		roomType.setId("SetAvailableRooms");
		roomType.setPrefSize(200, 30);
		
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
					break;
				}
				String num = roomNum.getText();
				double price = Double.parseDouble(initialPrice.getText());
				RoomVO roomvo = new RoomVO(controller.getUserId(), type, Integer.parseInt(num), price);
				//
				roomNum.setText("");
				initialPrice.setText("");
				OneButtonDialog dialog = new OneButtonDialog("设置成功");
				dialog.show();
			}
					
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				roomNum.setText("");
				initialPrice.setText("");
				controller.setFirstView();
				controller.getStage().show();
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
