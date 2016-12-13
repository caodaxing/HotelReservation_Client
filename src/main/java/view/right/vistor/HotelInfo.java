package view.right.vistor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.VistorUI;
import viewController.VistorController;
import vo.HotelVO;

/**
 * 游客界面_查看酒店_酒店详情
 * @author XueWang
 *
 */
public class HotelInfo {

	private VistorController controller;
	
	private Scene scene ;
	
	private VistorUI leftUI ;
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	TextField hotelName ;
	TextArea address ; 
	TextArea introduction ;
	TextField facility ;
	
	ImageView hotelImage ;
	
	//游客没有其他所有按钮（省事
	Button back;
	
	public HotelInfo(VistorController controller){
		
		this.controller = controller;
		
		leftUI = new VistorUI(controller);
		
		// 初始化左侧Pane
		leftPane = leftUI.getPane() ;
		leftPane.setPrefSize ( DefaultNums.LEFT_WIDTH , DefaultNums.HEIGHT );
		
		//初始化右侧Pane
		rightPane = new AnchorPane();
		rightPane.setPrefSize( DefaultNums.RIGHT_WIDTH , DefaultNums.HEIGHT );
		
		//设置TextField
		setTextField();
		
		setButton();
		
		//设置图片域
		setImageView();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		
		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/hotelAndOrder/查看酒店_酒店详情背景.jpg\")");
	}
	
	private void setTextField(){
		
		//初始化textField
		hotelName = new TextField();
		address = new TextArea();
		introduction = new TextArea();
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
	
	private void setButton(){
		
		back = new Button();
	
		back.setText("返回");
		
		back.setPrefSize(100, 40);
		
		back.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//返回搜索酒店界面
				controller.setSearchHotelView();
				controller.getStage().show();
			}
			
		});
		
		rightPane.getChildren().add(back);
		
		AnchorPane.setLeftAnchor(back, 450.0);
		AnchorPane.setTopAnchor(back, 510.0);
		
	}
	
	private void setImageView(){
		
		hotelImage = new ImageView();
		
		rightPane.getChildren().add(hotelImage);
		
		AnchorPane.setLeftAnchor(hotelImage, 150.0);
		AnchorPane.setTopAnchor(hotelImage, 360.0);
		
	}
	
	public void setText(){
		HotelVO vo = controller.getHotelInfo();
		hotelName.setText(vo.hotelName);
		address.setText(vo.locationOfHotel);
		introduction.setText(vo.introduction);;
		facility.setText(vo.facilities);
	}
	
	public void setImage(){
		//待补充
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
}
