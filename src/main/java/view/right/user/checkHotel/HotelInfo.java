package view.right.user.checkHotel;

import java.util.ArrayList;

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
import view.left.UserUI;
import viewController.UserCheckHotelController;
import vo.HotelVO;

/**
 * 客户界面_查看酒店_酒店详情
 * @author XueWang
 *
 */
public class HotelInfo{

	private UserCheckHotelController controller;
	
	private Scene scene ;
	
	private UserUI userUI ;	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	TextField hotelStar ;
	TextField address ; 
	TextField introduction ;
	TextField facility ;
	
	ImageView hotelImage ;
	
	Button historyOrderList ;
	Button roomList ;
	Button evaluationList ;
	Button makeOrder ;
	
	Button next;
	Button back;
	
	private int index = 1;
	
	public HotelInfo(UserCheckHotelController controller){
		
		this.controller = controller;
		
		userUI = new UserUI(controller);
		
		// 初始化左侧Pane
		leftPane = userUI.getPane() ;
		leftPane.setPrefSize ( DefaultNums.LEFT_WIDTH , DefaultNums.HEIGHT );
		
		//初始化右侧Pane
		rightPane = new AnchorPane();
		rightPane.setPrefSize( DefaultNums.RIGHT_WIDTH , DefaultNums.HEIGHT );
		
		//设置TextField
		setTextField();
		
		//设置Button
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
		address = new TextField();
		introduction = new TextField();
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
		
		//初始化Button
		historyOrderList = new Button();
		roomList = new Button();
		evaluationList = new Button();
		makeOrder = new Button();
		
		//设置Button文字
		historyOrderList.setText("历史订单");
		roomList.setText("查看房间");
		evaluationList.setText("查看评价");
		makeOrder.setText("生成订单");
				
		//设置Button大小
		historyOrderList.setPrefSize(100, 40);
		roomList.setPrefSize(100, 40);
		evaluationList.setPrefSize(100, 40);
		makeOrder.setPrefSize(100, 40);
		
		//添加listener
		historyOrderList.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setHistoryOrderListView();
				controller.getStage().show();
			}
			
		});
		roomList.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setRoomListView();
				controller.getStage().show();
			}
			
		});
		evaluationList.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setEvaluationListView();
				controller.getStage().show();
			}
			
		});
		makeOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setMakeOrderView();
				controller.getStage().show();
			}
			
		});
		
		//添加Button组件
		rightPane.getChildren().add(historyOrderList);
		rightPane.getChildren().add(roomList);
		rightPane.getChildren().add(evaluationList);
		rightPane.getChildren().add(makeOrder);
		
		//设置Button位置
		AnchorPane.setLeftAnchor(historyOrderList, 450.0);
		AnchorPane.setTopAnchor(historyOrderList, 350.0);
		AnchorPane.setLeftAnchor(roomList, 450.0);
		AnchorPane.setTopAnchor(roomList, 400.0);
		AnchorPane.setLeftAnchor(evaluationList, 450.0);
		AnchorPane.setTopAnchor(evaluationList, 450.0);
		AnchorPane.setLeftAnchor(makeOrder, 450.0);
		AnchorPane.setTopAnchor(makeOrder, 500.0);
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
		
		hotelImage.setFitHeight(200.0);
		hotelImage.setFitWidth(250.0);

		rightPane.getChildren().add(hotelImage);
		AnchorPane.setLeftAnchor(hotelImage, 150.0);
		AnchorPane.setTopAnchor(hotelImage, 360.0);
		
		next = new Button("下一张");
		next.setPrefSize(250, 30);
	
		next.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				ArrayList<Image> paths = controller.getHotelImage();
				if(paths.size()>index ){	
					try{
//						hotelImage.setImage(new Image(paths.get(index),250,200,false,true));
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
		hotelStar.setText(Double.toString(vo.levelOfHotel));
		address.setText(vo.locationOfHotel);
		introduction.setText(vo.introduction);;
		facility.setText(vo.facilities);
	}
	
	public void setFirstImage(){
		ArrayList<Image> paths = controller.getHotelImage();
		if(paths.isEmpty()){
			return;
		}else {
			try{
//				hotelImage.setImage(new Image(paths.get(0),250,200,false,true));
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
