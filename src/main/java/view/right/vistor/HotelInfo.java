package view.right.vistor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.VistorUI;
import viewController.VistorController;

/**
 * 游客界面_查看酒店_酒店详情
 * @author XueWang
 *
 */
public class HotelInfo {

	private VistorController controller;
	
	private Scene scene ;
	
	private VistorUI vistorUI = new VistorUI();	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	TextField hotelName ;
	TextField address ; 
	TextField introduction ;
	TextField facility ;
	
	ImageView hotelImage ;
	
	//游客没有所有按钮（省事
	
	public HotelInfo(VistorController controller){
		
		this.controller = controller;
		
		// 初始化左侧Pane
		leftPane = vistorUI.getPane() ;
		leftPane.setPrefSize ( DefaultNums.LEFT_WIDTH , DefaultNums.HEIGHT );
		
		//初始化右侧Pane
		rightPane = new AnchorPane();
		rightPane.setPrefSize( DefaultNums.RIGHT_WIDTH , DefaultNums.HEIGHT );
		
		//设置TextField
		setTextField();
		
		//设置图片域
		setImage();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		
	}
	
	private void setTextField(){
		
		//初始化textField
		hotelName = new TextField();
		address = new TextField();
		introduction = new TextField();
		facility = new TextField();

		//设置textField可操作性
		hotelName.setEditable(false);
		address.setEditable(false);
		introduction.setEditable(false);
		facility.setEditable(false);
		
		//设置textField大小
		hotelName.setPrefSize(250, 30);
		address.setPrefSize(400, 30);
		introduction.setPrefSize(300, 60);
		facility.setPrefSize(300, 60);
		
		//右侧pane添加组件
		rightPane.getChildren().add(hotelName);
		rightPane.getChildren().add(address);
		rightPane.getChildren().add(introduction);
		rightPane.getChildren().add(facility);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(hotelName, 150.0);
		AnchorPane.setLeftAnchor(address, 150.0);
		AnchorPane.setLeftAnchor(introduction, 150.0);
		AnchorPane.setLeftAnchor(facility, 150.0);
				
		AnchorPane.setTopAnchor(hotelName, 100.0);
		AnchorPane.setTopAnchor(address, 150.0);
		AnchorPane.setTopAnchor(introduction, 200.0);
		AnchorPane.setTopAnchor(facility, 280.0);
		
	}
	
	private void setImage(){
		
		//从controller得到图片
		Image image = new Image("", 250, 200,false ,true);
		
		hotelImage = new ImageView(image);
		
		rightPane.getChildren().add(hotelImage);
		
		AnchorPane.setLeftAnchor(hotelImage, 150.0);
		AnchorPane.setTopAnchor(hotelImage, 360.0);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
}
