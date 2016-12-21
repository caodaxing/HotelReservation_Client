package view.right.hotelManager.hotelInfo;

import java.io.File;
import java.util.ArrayList;

import Message.ResultMessage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.helpTools.DefaultNums;
import view.left.HotelManagerUI;
import viewController.HMHotelInfoController;
import viewController.HotelManagerLeftController;
import vo.HotelVO;

/**
 * 酒店工作人员界面_酒店信息_维护酒店信息界面
 * @author XueWang
 *
 */
public class ModifyHotelInfo {
	
	private HotelManagerLeftController controller;
	private HMHotelInfoController hmcontroller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private HotelManagerUI hmui;
	
	TextField hotelStar;
	TextField hotelLocation;
	TextArea hotelBriefing;
	TextArea hotelFacility;
	TextArea HotelImage;
	FileChooser fileChooser;
	
	Button cancel;
	Button ok;
	Button choosePicture;
	
	public ModifyHotelInfo(HotelManagerLeftController controller){
		
		this.controller = controller;
		hmui = new HotelManagerUI(controller);
		
		leftPane = hmui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		rightPane.getStylesheets().add("/CSS/right.css");
		
		//添加文本内容
		setTextContent();
		
		//添加按钮
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.setStyle("-fx-background-image:url(\"/infoManagement/管理酒店信息背景.jpg\")");
		
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextContent(){
		
		//设置酒店信息的文本信息
		hotelStar = new TextField();
		hotelLocation = new TextField();
		hotelBriefing = new TextArea();
		hotelFacility = new TextArea();
		HotelImage = new TextArea();
		
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
	
	private void openFileChooser(){
		
		fileChooser = new FileChooser();
		fileChooser.setTitle("选择头像");
		fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
		Stage s = new Stage();
		File file = fileChooser.showOpenDialog(s);
		if(file==null){
			controller.showDialog("请选择图片");
			return;
		}
		String exportFilePath= file.getAbsolutePath();
		HotelImage.setText(exportFilePath);
		
	}
	
	private void setButton(){
		//添加按钮
		ok = new Button("确认");
		ok.setId("ModifyHotelInfo");
		ok.setPrefSize(100, 40);
		
		cancel = new Button("取消");
		cancel.setId("ModifyHotelInfo");
		cancel.setPrefSize(100, 40);
		
		choosePicture = new Button("选择图片");
		choosePicture.setId("ModifyHotelInfo");
		choosePicture.setPrefSize(100, 40);
						
		//设置按钮位置
		ok.setLayoutX(625);
		ok.setLayoutY(450);
		
		cancel.setLayoutX(650);
		cancel.setLayoutY(510);
		
		choosePicture.setLayoutX(625);
		choosePicture.setLayoutY(390);
						
		//设置按钮监听
		ok.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				//传输vo
				String star = hotelStar.getText();
				String hotelLocal = hotelLocation.getText();
				String hotelBrief = hotelBriefing.getText();
				String hoteltool = hotelFacility.getText();
				String ImagePath = HotelImage.getText();
				try{
					HotelVO vo = controller.getHotelVO(controller.getUserId());
					int i = Integer.parseInt(star);
					HotelVO hotelvo = new HotelVO(vo.hoteID,vo.hotelName,vo.city,vo.tradingArea,
							hotelLocal,vo.evaluationGrades,i,hotelBrief,hoteltool,vo.bussiness);
					if(controller.getUpdateHotelResult(hotelvo) == ResultMessage.SUCCESS){
						controller.showDialog("修改成功");
					}else{
						controller.showDialog("修改失败");
					}
				}catch(NumberFormatException e){
					controller.showDialog("酒店星级输入错误");
				}
			}
							
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				HMHotelInfoController hmcontroller = new HMHotelInfoController(controller.getStage(), controller.getUserId());
				hmcontroller.setBlankView();
			}
							
		});
		
		choosePicture.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				openFileChooser();
			}
							
		});
						
		//右侧pane添加
		rightPane.getChildren().add(cancel);
		rightPane.getChildren().add(ok);
		rightPane.getChildren().add(choosePicture);
						
		AnchorPane.setLeftAnchor(ok, 450.0);
		AnchorPane.setLeftAnchor(cancel, 450.0);
		AnchorPane.setLeftAnchor(choosePicture, 450.0);
		
		AnchorPane.setTopAnchor(choosePicture, 390.0);
		AnchorPane.setTopAnchor(ok, 450.0);
		AnchorPane.setTopAnchor(cancel, 510.0);
		
	}
	
	public void setHotelInfo(){
		HotelVO vo= controller.getHotelVO(controller.getUserId());
		ArrayList<Image> pictureList = controller.getPicture(controller.getUserId());
		String text = "";
		for(int i=0;i<pictureList.size();i++){
			text += pictureList.get(i)+"\n";
		}
		hotelStar.setText(String.valueOf(vo.levelOfHotel));
		hotelLocation.setText(vo.locationOfHotel);
		hotelBriefing.setText(vo.introduction);
		hotelFacility.setText(vo.facilities);
		HotelImage.setText(text);
	}
	
}
