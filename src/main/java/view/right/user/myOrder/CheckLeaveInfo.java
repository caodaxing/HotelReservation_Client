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
 * 客户界面_我的订单_已执行订单_查看退房信息
 * @author XueWang
 *
 */
public class CheckLeaveInfo {

	private UserMyOrderController controller;
	
	private Scene scene ;
	
	private UserUI userUI = new UserUI();	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	TextField roomType ;
	TextField leaveTime ;
	
	Button back ;
	
	public CheckLeaveInfo(UserMyOrderController controller){
		
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
		roomType = new TextField();
		leaveTime = new TextField();

		//设置textField可操作性
		roomType.setEditable(false);
		leaveTime.setEditable(false);
		
		//设置textField大小
		roomType.setPrefSize(200, 30);
		leaveTime.setPrefSize(200, 30);
		
		//右侧pane添加组件
		rightPane.getChildren().add(roomType);
		rightPane.getChildren().add(leaveTime);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(roomType, 200.0);
		AnchorPane.setLeftAnchor(leaveTime, 200.0);
				
		AnchorPane.setTopAnchor(roomType, 150.0);
		AnchorPane.setTopAnchor(leaveTime, 200.0);
		
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
