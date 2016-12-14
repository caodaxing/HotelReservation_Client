package view.right.user.checkHotel;

import java.time.LocalDate;

import Message.RoomType;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.helpTools.TimeHelper;
import view.left.UserUI;
import viewController.UserCheckHotelController;
import viewController.UserLeftController;
import vo.OrderVO;

/**
 * 客户界面_查看酒店_生成订单
 * @author XueWang
 *
 */
public class MakeOrder{

	private UserCheckHotelController controller;
	
	private Scene scene ;
	
	private UserUI userUI ;	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	ChoiceBox roomType ;
	TextField roomNums ; 
	DatePicker arriveTime ;
	DatePicker leaveTime ;
	DatePicker latestTime ;
	TextField peopleNums ;
	ChoiceBox haveChild ;
	
	Button makeOrder ;
	Button back ;
	
	public MakeOrder(UserCheckHotelController controller){
		
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
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		
		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/hotelAndOrder/查看酒店_生成订单背景.jpg\")");
	}
	
	private void setTextField(){
		
		//初始化textField
		roomType =new ChoiceBox(FXCollections.observableArrayList("单人房","标准房","三人房","大床房","套房"));
		
		roomNums = new TextField();
		arriveTime = new DatePicker();
		leaveTime = new DatePicker();
		latestTime = new DatePicker();
		peopleNums = new TextField();
		haveChild = new ChoiceBox(FXCollections.observableArrayList("是","否"));
		
		//设置textField可操作性
		roomNums.setEditable(true);
		arriveTime.setEditable(true);
		leaveTime.setEditable(true);
		latestTime.setEditable(true);
		peopleNums.setEditable(true);
		
		//设置DatePicker初始值
		arriveTime.setValue(LocalDate.now());
		leaveTime.setValue(LocalDate.now().plusDays(1));
		latestTime.setValue(LocalDate.now().plusDays(1));
		
		//设置textField大小
		roomType.setPrefSize(200, 30);
		roomNums.setPrefSize(200, 30);
		arriveTime.setPrefSize(200, 30);
		leaveTime.setPrefSize(200, 30);
		latestTime.setPrefSize(200, 30);
		peopleNums.setPrefSize(200, 30);
		haveChild.setPrefSize(200, 30);
		
		//右侧pane添加组件
		rightPane.getChildren().add(roomType);
		rightPane.getChildren().add(roomNums);
		rightPane.getChildren().add(arriveTime);
		rightPane.getChildren().add(leaveTime);
		rightPane.getChildren().add(latestTime);
		rightPane.getChildren().add(peopleNums);
		rightPane.getChildren().add(haveChild);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(roomType, 200.0);
		AnchorPane.setLeftAnchor(roomNums, 200.0);
		AnchorPane.setLeftAnchor(arriveTime, 200.0);
		AnchorPane.setLeftAnchor(leaveTime, 200.0);
		AnchorPane.setLeftAnchor(latestTime, 200.0);
		AnchorPane.setLeftAnchor(peopleNums, 200.0);
		AnchorPane.setLeftAnchor(haveChild, 200.0);
				
		AnchorPane.setTopAnchor(roomType, 150.0);
		AnchorPane.setTopAnchor(roomNums, 200.0);
		AnchorPane.setTopAnchor(arriveTime, 250.0);
		AnchorPane.setTopAnchor(leaveTime, 300.0);
		AnchorPane.setTopAnchor(latestTime, 350.0);
		AnchorPane.setTopAnchor(peopleNums, 400.0);
		AnchorPane.setTopAnchor(haveChild, 450.0);
		
	}
	
	private void setButton(){
		
		//初始化Button
		makeOrder = new Button();
		back = new Button();
		
		//设置Button文字
		makeOrder.setText("生成订单");
		back.setText("返回");
				
		//设置Button大小
		makeOrder.setPrefSize(100, 40);
		back.setPrefSize(100, 40);
		
		//添加listener
		makeOrder.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		back.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		
		//添加Button组件
		rightPane.getChildren().add(makeOrder);
		rightPane.getChildren().add(back);
		
		//设置Button位置
		AnchorPane.setLeftAnchor(makeOrder, 250.0);
		AnchorPane.setTopAnchor(makeOrder, 525.0);
		
		AnchorPane.setLeftAnchor(back, 425.0);
		AnchorPane.setTopAnchor(back, 525.0);
				
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
	public OrderVO getOrderVO(){
		
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
		
		String time = TimeHelper.getInstanceTimeString();
		
		String arrive = arriveTime.getValue().toString()+" "+time;
		if(arriveTime.getValue().isAfter(leaveTime.getValue())){
			controller.showDialog("入住时间不应晚于退房时间");
			//给controller用
			arrive="x";
		}else if(arriveTime.getValue().isAfter(latestTime.getValue())){
			controller.showDialog("预计入住时间不应晚于最晚入住时间");
			arrive="x";
		}else if(arriveTime.getValue().isBefore(LocalDate.now())){
			controller.showDialog("预计入住时间应晚于当前时间");
			arrive="x";
		}
		String leave = leaveTime.getValue().toString()+" "+time;
		String latest = latestTime.getValue().toString()+" "+time;
		
		int numOfR = 1;
		if(!peopleNums.getText().equals(""))
			numOfR = Integer.valueOf(roomNums.getText());
		
		int numOfP = 1;
		if(!peopleNums.getText().equals(""))
			numOfP = Integer.valueOf(peopleNums.getText());
		
		int t2 = haveChild.getSelectionModel().getSelectedIndex();
		boolean child = false;
		if(t2 == 0){
			child = true;
		}
		
		//hotelID由controller添加
		return new OrderVO(controller.getUserID(),type,numOfR,arrive,leave,"",numOfP,child);
		
	}
	
}
