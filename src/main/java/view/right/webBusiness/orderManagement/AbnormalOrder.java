package view.right.webBusiness.orderManagement;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.WebBusinessUI;
import viewController.WBCreditController;
import viewController.WBOrderManagementController;

/**
 * 网站营销人员界面_订单管理_异常订单详情
 * @author XueWang
 *
 */
public class AbnormalOrder {
	
	private WBOrderManagementController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui = new WebBusinessUI();
	
	TextField orderID;
	TextField hotelName;
	TextField roomType;
	TextField lastExecuteTime;
	
	Button halfCredit;
	Button allCredit;
	Button revert;
	
	public AbnormalOrder(WBOrderManagementController controller){
		
		this.controller = controller;
		
		leftPane = wbui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		//添加文本框
		setTextField();
		
		//添加按钮
		setButton();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
	}
	
	public Scene getScene(){
		return scene;
	}
	
	public void setTextField(){
		
		//ArrayList<String> infoList = controller.getInfoList();
		//添加文本框
		orderID = new TextField();
		orderID.setId("AbnormalOrder");
		orderID.setPrefSize(200, 30);
		
		hotelName = new TextField();
		hotelName.setId("AbnormalOrder");
		hotelName.setPrefSize(200, 30);
		
		roomType = new TextField();
		roomType.setId("AbnormalOrder");
		roomType.setPrefSize(200, 30);
		
		lastExecuteTime = new TextField();
		lastExecuteTime.setId("AbnormalOrder");
		lastExecuteTime.setPrefSize(200, 30);
		
		//设置文本框内容
		
		//设置文本框内容不可更改
		orderID.setEditable(false);
		hotelName.setEditable(false);
		roomType.setEditable(false);
		lastExecuteTime.setEditable(false);
		
		//设置文本框位置
		orderID.setLayoutX(400);
		orderID.setLayoutY(150);
		
		hotelName.setLayoutX(400);
		hotelName.setLayoutY(250);
		
		roomType.setLayoutX(400);
		roomType.setLayoutY(350);
		
		lastExecuteTime.setLayoutX(400);
		lastExecuteTime.setLayoutY(450);
		
		//添加组件
		rightPane.getChildren().add(orderID);
		rightPane.getChildren().add(hotelName);
		rightPane.getChildren().add(roomType);
		rightPane.getChildren().add(lastExecuteTime);
		
		AnchorPane.setLeftAnchor(orderID, 200.0);
		AnchorPane.setLeftAnchor(hotelName, 200.0);
		AnchorPane.setLeftAnchor(roomType, 200.0);
		AnchorPane.setLeftAnchor(lastExecuteTime, 200.0);
		
		AnchorPane.setTopAnchor(orderID, 150.0);
		AnchorPane.setTopAnchor(hotelName, 250.0);
		AnchorPane.setTopAnchor(roomType, 350.0);
		AnchorPane.setTopAnchor(lastExecuteTime, 450.0);
		
	}
	
	public void setButton(){
		
		//添加按钮
		halfCredit = new Button("撤销并恢复一半信用");
		halfCredit.setId("AbnormalOrder");
		halfCredit.setPrefSize(150, 40);
		
		allCredit = new Button("撤销并恢复全部信用");
		allCredit.setId("AbnormalOrder");
		allCredit.setPrefSize(150, 40);
		
		revert = new Button("返回");
		revert.setId("AbnormalOrder");
		revert.setPrefSize(100, 40);
				
		//设置按钮位置
		halfCredit.setLayoutX(275);
		halfCredit.setLayoutY(525);
		
		allCredit.setLayoutX(450);
		allCredit.setLayoutY(525);
		
		revert.setLayoutX(625);
		revert.setLayoutY(525);
		
		//添加按钮监听
		halfCredit.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		allCredit.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		revert.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//添加组件
		rightPane.getChildren().add(halfCredit);
		rightPane.getChildren().add(allCredit);
		rightPane.getChildren().add(revert);
		
		AnchorPane.setLeftAnchor(halfCredit, 75.0);
		AnchorPane.setLeftAnchor(allCredit, 250.0);
		AnchorPane.setLeftAnchor(revert, 425.0);
		
		AnchorPane.setTopAnchor(halfCredit, 525.0);
		AnchorPane.setTopAnchor(allCredit, 525.0);
		AnchorPane.setTopAnchor(revert, 525.0);
		
	}
	
}
