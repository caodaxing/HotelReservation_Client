package view.right.hotelManager.hotelInfo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.HotelManagerUI;
import viewController.HotelManagerLeftController;

/**
 * 酒店工作人员界面_酒店信息_维护酒店信息界面
 * @author XueWang
 *
 */
public class ModifyHotelInfo {
	
	private HotelManagerLeftController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	TextField hotelStar;
	TextField hotelLocation;
	TextArea hotelBriefing;
	TextArea hotelFacility;
	TextArea HotelImage;
	
	Button cancel;
	Button ok;
	
	public ModifyHotelInfo(HotelManagerLeftController controller){
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add(getClass().getResource("hmhotelInfo.css").toExternalForm());
		
		//添加文本内容
		setTextContent();
		
		//添加按钮
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextContent(){
		
		//ArrayList<String> orderInfoList = controller.getInfoList();
		
		//设置酒店信息的文本信息
		hotelStar = new TextField();
		hotelLocation = new TextField();
		hotelBriefing = new TextArea();
		hotelFacility = new TextArea();
		HotelImage = new TextArea();
		
		/*
		//根据Controller设置textField文字
		 
		*/
		
		//设置TextField不可更改
		hotelStar.setEditable(true);
		hotelLocation.setEditable(true);
		hotelBriefing.setEditable(true);
		hotelFacility.setEditable(true);
		HotelImage.setEditable(true);
		
		//设置textField大小
		hotelStar.setPrefSize(250, 30);
		hotelLocation.setPrefSize(400, 30);
		hotelBriefing.setPrefSize(300, 60);
		hotelFacility.setPrefSize(300, 60);
		HotelImage.setPrefSize(200, 200);
		
		//右侧pane添加组件
		rightPane.getChildren().add(hotelStar);
		rightPane.getChildren().add(hotelLocation);
		rightPane.getChildren().add(hotelBriefing);
		rightPane.getChildren().add(hotelFacility);
		rightPane.getChildren().add(HotelImage);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(hotelStar, 150.0);
		AnchorPane.setLeftAnchor(hotelLocation, 150.0);
		AnchorPane.setLeftAnchor(hotelBriefing, 150.0);
		AnchorPane.setLeftAnchor(hotelFacility, 150.0);
		AnchorPane.setLeftAnchor(HotelImage, 150.0);
						
		AnchorPane.setTopAnchor(hotelStar, 100.0);
		AnchorPane.setTopAnchor(hotelLocation, 150.0);
		AnchorPane.setTopAnchor(hotelBriefing, 200.0);
		AnchorPane.setTopAnchor(hotelFacility, 280.0);
		AnchorPane.setTopAnchor(HotelImage, 360.0);
	}
	
	private void setButton(){
		//添加按钮
		ok = new Button("确认");
		ok.setId("ModifyHotelInfo");
		ok.setPrefSize(100, 40);
		
		cancel = new Button("取消");
		cancel.setId("ModifyHotelInfo");
		cancel.setPrefSize(100, 40);
						
		//设置按钮位置
		ok.setLayoutX(625);
		ok.setLayoutY(450);
		
		cancel.setLayoutX(650);
		cancel.setLayoutY(510);
						
		//设置按钮监听
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
						
		//右侧pane添加
		rightPane.getChildren().add(cancel);
		rightPane.getChildren().add(ok);
						
		AnchorPane.setLeftAnchor(ok, 450.0);
		AnchorPane.setLeftAnchor(cancel, 450.0);
		
		AnchorPane.setTopAnchor(ok, 450.0);
		AnchorPane.setTopAnchor(cancel, 510.0);
		
	}
	
}
