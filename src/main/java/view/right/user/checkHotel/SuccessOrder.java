package view.right.user.checkHotel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.helpTools.MessageHelper;
import view.left.UserUI;
import viewController.UserCheckHotelController;
import vo.OrderVO;

/**
 * 客户界面_查看酒店_生成订单成功反馈
 * @author XueWang
 *
 */
public class SuccessOrder {

	private UserCheckHotelController controller;
	
	private Scene scene ;
	
	private UserUI userUI;	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	private OrderVO vo;
	
	TextField hotelName ;
	TextField roomType ;
	TextField roomNums ; 
	TextField arriveTime ;
	//原有最晚到达时间因自动设定改为promotion
	TextField promotion ;
	TextField originalPrice ;
	TextField actualPrice ;
	TextField peopleNums ;
	TextField haveChild ;
	
	Button confirm ;
	
	/*
	 * 根据controller传入的OrderVO显示，相当于大型对话框
	 */
	public SuccessOrder(UserCheckHotelController controller,OrderVO vo){
		
		this.controller = controller;
		this.vo = vo;
		
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

		//添加样式表
		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/hotelAndOrder/查看酒店_预订成功反馈界面背景.jpg\")");
	}
	
	private void setTextField(){
		
		//初始化textField
		hotelName = new TextField();
		roomType = new TextField();
		roomNums = new TextField();
		arriveTime = new TextField();
		promotion = new TextField();
		originalPrice = new TextField();
		actualPrice = new TextField();
		peopleNums = new TextField();
		haveChild = new TextField();
	
		//根据vo设置值
		hotelName.setText(controller.getHotelName(vo.hotelID));
		roomType.setText(MessageHelper.roomTypeToString(vo.roomType));
		roomNums.setText(Integer.toString(vo.roomNum));
		arriveTime.setText(vo.startTime);
		if(vo.promotion == null){
			promotion.setText("无");
		}else
			promotion.setText(vo.promotion.promotionName+":  "+vo.promotion.discount+" 折");
		originalPrice.setText(Double.toString(vo.beforePrice));
		actualPrice.setText(Double.toString(vo.afterPrice));
		peopleNums.setText(Integer.toString(vo.numOfPeople));
		String have = "否";
		if(vo.hasChild){
			have = "是";
		}
		haveChild.setText(have);
		
		//设置textField可操作性
		hotelName.setEditable(false);
		roomType.setEditable(false);
		roomNums.setEditable(false);
		arriveTime.setEditable(false);
		promotion.setEditable(false);
		originalPrice.setEditable(false);
		actualPrice.setEditable(false);
		peopleNums.setEditable(false);
		haveChild.setEditable(false);
		
		//设置textField大小
		hotelName.setPrefSize(200, 30);
		roomType.setPrefSize(200, 30);
		roomNums.setPrefSize(200, 30);
		arriveTime.setPrefSize(200, 30);
		promotion.setPrefSize(200, 30);
		originalPrice.setPrefSize(200, 30);
		actualPrice.setPrefSize(200, 30);
		peopleNums.setPrefSize(200, 30);
		haveChild.setPrefSize(200, 30);
		
		//右侧pane添加组件
		rightPane.getChildren().add(hotelName);
		rightPane.getChildren().add(roomType);
		rightPane.getChildren().add(roomNums);
		rightPane.getChildren().add(arriveTime);
		rightPane.getChildren().add(promotion);
		rightPane.getChildren().add(originalPrice);
		rightPane.getChildren().add(actualPrice);
		rightPane.getChildren().add(peopleNums);
		rightPane.getChildren().add(haveChild);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(hotelName, 200.0);
		AnchorPane.setLeftAnchor(roomType, 200.0);
		AnchorPane.setLeftAnchor(roomNums, 200.0);
		AnchorPane.setLeftAnchor(arriveTime, 200.0);
		AnchorPane.setLeftAnchor(promotion, 200.0);
		AnchorPane.setLeftAnchor(originalPrice, 200.0);
		AnchorPane.setLeftAnchor(actualPrice, 200.0);
		AnchorPane.setLeftAnchor(peopleNums, 200.0);
		AnchorPane.setLeftAnchor(haveChild, 200.0);
		
		AnchorPane.setTopAnchor(hotelName, 100.0);
		AnchorPane.setTopAnchor(roomType, 150.0);
		AnchorPane.setTopAnchor(roomNums, 200.0);
		AnchorPane.setTopAnchor(arriveTime, 250.0);
		AnchorPane.setTopAnchor(promotion, 300.0);
		AnchorPane.setTopAnchor(originalPrice, 350.0);
		AnchorPane.setTopAnchor(actualPrice, 400.0);
		AnchorPane.setTopAnchor(peopleNums, 450.0);
		AnchorPane.setTopAnchor(haveChild, 500.0);
		
	}
	
	private void setButton(){
		
		//初始化Button
		confirm = new Button();
		
		//设置Button文字
		confirm.setText("确认");
				
		//设置Button大小
		confirm.setPrefSize(100, 40);
		
		//添加listener
		confirm.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//返回首页,清空
				controller.setHotelFirstView();
				controller.getStage().show();
			}
			
		});
		
		//添加Button组件
		rightPane.getChildren().add(confirm);
		
		//设置Button位置
		AnchorPane.setLeftAnchor(confirm, 425.0);
		AnchorPane.setTopAnchor(confirm, 550.0);
				
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
}
