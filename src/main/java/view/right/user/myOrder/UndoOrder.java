package view.right.user.myOrder;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import viewController.UserMyOrderController;

/**
 * 客户界面_我的订单_已撤销订单
 * @author XueWang
 *
 */
public class UndoOrder {
	
	private UserMyOrderController controller;
	
	private Scene scene ;
	
	private UserUI userUI = new UserUI();	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	TextField orderID ;
	TextField hotelName ; 
	TextField roomType ;
	TextField undoTime ;

	Button back ;
	
	public UndoOrder(UserMyOrderController controller){
		
		this.controller = controller;
		
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
		
	}
	
	private void setTextField(){
		
		//初始化textField
		orderID = new TextField();
		hotelName = new TextField();
		roomType = new TextField();
		undoTime = new TextField();

		//设置textField可操作性
		orderID.setEditable(false);
		hotelName.setEditable(false);
		roomType.setEditable(false);
		undoTime.setEditable(false);
		
		//设置textField大小
		orderID.setPrefSize(200, 30);
		hotelName.setPrefSize(200, 30);
		roomType.setPrefSize(200, 30);
		undoTime.setPrefSize(200, 30);
		
		//右侧pane添加组件
		rightPane.getChildren().add(orderID);
		rightPane.getChildren().add(hotelName);
		rightPane.getChildren().add(roomType);
		rightPane.getChildren().add(undoTime);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(orderID, 200.0);
		AnchorPane.setLeftAnchor(hotelName, 200.0);
		AnchorPane.setLeftAnchor(roomType, 200.0);
		AnchorPane.setLeftAnchor(undoTime, 200.0);
				
		AnchorPane.setTopAnchor(orderID, 150.0);
		AnchorPane.setTopAnchor(hotelName, 200.0);
		AnchorPane.setTopAnchor(roomType, 250.0);
		AnchorPane.setTopAnchor(undoTime, 300.0);
		
	}
	
	private void setButton(){
		
		//初始化Button
		back = new Button();
		
		//设置Button文字
		back.setText("返回");
				
		//设置Button大小
		back.setPrefSize(100, 40);
		
		//添加listener
		back.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
			}
			
		});
		
		//添加Button组件
		rightPane.getChildren().add(back);
		
		//设置Button位置
		AnchorPane.setLeftAnchor(back, 425.0);
		AnchorPane.setTopAnchor(back, 525.0);
				
	}
	
	public Scene getScene(){
		
		return scene;
	
	}

}
