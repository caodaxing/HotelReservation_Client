package view.right.vistor;

import java.util.ArrayList;

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
	
	TextField hotelStar ;
	TextArea address ; 
	TextArea introduction ;
	TextField facility ;
	
	ImageView hotelImage ;
	
	private int index = 1;
	
	//游客没有其他所有按钮（省事
	Button next;
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
		hotelStar = new TextField();
		address = new TextArea();
		introduction = new TextArea();
		facility = new TextField();

		//设置textField可操作性
		hotelStar.setEditable(false);
		address.setEditable(false);
		introduction.setEditable(false);
		facility.setEditable(false);
		
		//设置textField大小
		hotelStar.setPrefSize(250, 30);
		address.setPrefSize(400, 30);
		introduction.setPrefSize(300, 60);
		facility.setPrefSize(300, 60);
		
		//右侧pane添加组件
		rightPane.getChildren().add(hotelStar);
		rightPane.getChildren().add(address);
		rightPane.getChildren().add(introduction);
		rightPane.getChildren().add(facility);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(hotelStar, 150.0);
		AnchorPane.setLeftAnchor(address, 150.0);
		AnchorPane.setLeftAnchor(introduction, 150.0);
		AnchorPane.setLeftAnchor(facility, 150.0);
				
		AnchorPane.setTopAnchor(hotelStar, 100.0);
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
				//返回酒店列表界面
				controller.setSearchResultListView();
				controller.getStage().show();
			}
			
		});
		
		rightPane.getChildren().add(back);
		
		AnchorPane.setLeftAnchor(back, 450.0);
		AnchorPane.setTopAnchor(back, 550.0);
		
	}
	
	private void setImageView(){
		hotelImage = new ImageView();
		
		hotelImage.setFitWidth(250.0);
		hotelImage.setFitHeight(200.0);

		rightPane.getChildren().add(hotelImage);
		AnchorPane.setLeftAnchor(hotelImage, 150.0);
		AnchorPane.setTopAnchor(hotelImage, 360.0);
		
		next = new Button("下一张");
		next.setPrefSize(250, 30);

		next.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){

				ArrayList<String> paths = controller.getHotelImage();
				if(paths.size()>index ){	
					try{
						hotelImage.setImage(new Image(paths.get(index),250,200,false,true));
					}catch(Exception e){
						controller.showDialog("酒店图片路径无效");
						return;
					}
					index++;
				}else{
					index=1;
					setFirstImage();
				}
			}
			
		});
		rightPane.getChildren().add(next);
		AnchorPane.setLeftAnchor(next, 150.0);
		AnchorPane.setTopAnchor(next, 560.0);
		
	}
	
	public void setText(){
		HotelVO vo = controller.getHotelInfo();
		hotelStar.setText(Integer.toString(vo.levelOfHotel));
		address.setText(vo.locationOfHotel);
		introduction.setText(vo.introduction);;
		facility.setText(vo.facilities);
	}
	
	public void setFirstImage(){
		ArrayList<String> paths = controller.getHotelImage();
		if(paths.isEmpty()){
			return;
		}else {
			try{
				hotelImage.setImage(new Image(paths.get(0),250,200,false,true));
			}catch(Exception e){
				controller.showDialog("酒店图片路径无效");
				return;
			}
		}
	}

	public Scene getScene(){
		
		return scene;
	
	}
	
}
