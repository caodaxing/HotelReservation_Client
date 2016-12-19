package view.right.hotelManager.orderManagement;

import Message.ResultMessage;
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
import viewController.HotelManagerLeftController;
import vo.RoomVO;

/**
 * 酒店工作人员界面_管理订单_已执行订单_更新入住信息
 * @author XueWang
 *
 */
public class SetArriveInfo {
	
	private HotelManagerLeftController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	ChoiceBox roomType;
	TextField roomNumber;
	TextField roomPrice;
	
	Button ok;
	Button cancel;
	
	public SetArriveInfo(HotelManagerLeftController controller){
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add("/CSS/right.css");
		
		//添加下拉框
		setChoiceBox();
		
		//添加文本内容
		setTextField();
		
		//添加按钮
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.setStyle("-fx-background-image:url(\"/infoManagement/房间管理_更新入住信息背景.jpg\")");
		
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setChoiceBox(){
		
		//待修改，根据controller
		roomType = new ChoiceBox(FXCollections.observableArrayList("单人房","标准房","三人房","大床房","套房"));
		roomType.setId("SetAvailableRooms");
		roomType.setPrefSize(200, 30);
		roomType.setLayoutX(400);
		roomType.setLayoutY(150);
		rightPane.getChildren().add(roomType);
		
		AnchorPane.setLeftAnchor(roomType, 200.0);
		
		AnchorPane.setTopAnchor(roomType, 150.0);
		
	}
	
	private void setTextField(){
		
		//添加文本框
		roomNumber = new TextField();
		roomNumber.setId("SetArriveInfo");
		roomNumber.setPrefSize(200, 30);
		
		roomPrice = new TextField();
		roomPrice.setId("SetArriveInfo");
		roomPrice.setPrefSize(200, 30);
		
		//设置文本框内容可更改
		roomNumber.setEditable(true);
		roomPrice.setEditable(true);
		
		//设置文本框位置
		
		roomNumber.setLayoutX(400);
		roomNumber.setLayoutY(200);
		
		roomPrice.setLayoutX(400);
		roomPrice.setLayoutY(250);
		
		//添加组件
		rightPane.getChildren().add(roomNumber);
		rightPane.getChildren().add(roomPrice);
		
		AnchorPane.setLeftAnchor(roomNumber, 200.0);
		AnchorPane.setLeftAnchor(roomPrice, 200.0);
		
		AnchorPane.setTopAnchor(roomNumber, 200.0);
		AnchorPane.setTopAnchor(roomPrice, 250.0);
		
	}
	
	private void setButton(){
		
		//添加按钮
		ok = new Button("确定");
		ok.setId("SetArriveInfo");
		ok.setPrefSize(100, 40);
		
		cancel = new Button("取消");
		cancel.setId("SetArriveInfo");
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
				String num = roomNumber.getText();
				String price = roomPrice.getText();
				try{
					int number = Integer.parseInt(num);
					double d = Double.parseDouble(price);
					if(type != null){
						RoomVO roomvo = new RoomVO(controller.getUserId(),type,number,d);
						if(controller.getUpdaterRoomResult(roomvo) == ResultMessage.SUCCESS){
							controller.showDialog("更新成功");
						}else{
							controller.showDialog("更新失败");
						}
					}else{
						controller.showDialog("输入错误");
					}
				}catch(NumberFormatException e){
					controller.showDialog("输入错误");
				}
			}
			
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				controller.setBlankView();
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
