package view.right.user.myOrder;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import viewController.UserMyOrderController;
import vo.EvaluationVO;

/**
 * 客户界面_我的订单_已执行订单_查看评价
 * 抛弃了他
 * @author XueWang
 *
 */
public class EvaluationInfo {

	private UserMyOrderController controller;
	
	private Scene scene ;
	
	private UserUI userUI ;	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	TextField grade ;
	TextArea info ;
	
	Button confirm;
	Button back ;
	
	public EvaluationInfo(UserMyOrderController controller){
		
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
		root.setStyle("-fx-background-image:url(\"/hotelAndOrder/查看订单_评价详情背景.jpg\")");
	}
	
	private void setTextField(){
		
		//初始化textField
		grade = new TextField();
		info = new TextArea();

		//设置textField可操作性
		grade.setEditable(false);
		info.setEditable(false);
		
		//设置textField大小
		grade.setPrefSize(100, 30);
		info.setPrefSize(250, 150);
		
		//右侧pane添加组件
		rightPane.getChildren().add(grade);
		rightPane.getChildren().add(info);
		
		//右侧Pane设置位置
		AnchorPane.setLeftAnchor(grade, 200.0);
		AnchorPane.setLeftAnchor(info, 200.0);
				
		AnchorPane.setTopAnchor(grade, 150.0);
		AnchorPane.setTopAnchor(info, 200.0);
		
	}
	
	private void setButton(){
		
		//初始化Button
		back = new Button();
		
		//设置Button文字
		back.setText("取消");
				
		//设置Button大小
		back.setPrefSize(100, 40);
		
		//添加listener
		back.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//返回首页
				controller.setOrderFirstView();
				controller.getStage().show();
			}
			
		});
		
		//添加Button组件
		rightPane.getChildren().add(back);
		
		//设置Button位置
		AnchorPane.setLeftAnchor(back, 350.0);
		AnchorPane.setTopAnchor(back, 400.0);
				
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
	public void setBlank(){
		grade.setText("");
		info.setText("");
	}
	
	public void setText(){
		EvaluationVO vo = controller.getEvaluationInfo();
		grade.setText(Double.toString(vo.commentLevel) );
		info.setText(vo.evaluationContent);
	}
	
}
