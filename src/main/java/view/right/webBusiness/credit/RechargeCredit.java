package view.right.webBusiness.credit;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import view.helpTools.DefaultNums;
import view.helpTools.OneButtonDialog;
import view.left.WebBusinessUI;
import viewController.WBCreditController;
import viewController.WBVIPInfoController;
import viewController.WebBusinessLeftController;

/**
 * 网站营销人员界面_信用充值_信用充值
 * @author XueWang
 *
 */
public class RechargeCredit {
	
	private WBCreditController controller;
	private WebBusinessLeftController wbController;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui = new WebBusinessUI(wbController);
	
	TextField userID;
	TextField rechargeAmount;
	
	Button ok;
	Button cancel;
	
	public RechargeCredit(WBCreditController controller){
		
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
		
		//添加文本框
		userID = new TextField();
		userID.setId("RechargeCredit");
		userID.setPrefSize(200, 30);
		
		rechargeAmount = new TextField();
		rechargeAmount.setId("RechargeCredit");
		rechargeAmount.setPrefSize(200, 30);
		
		//设置文本框位置
		userID.setLayoutX(400);
		userID.setLayoutY(150);
		
		rechargeAmount.setLayoutX(400);
		rechargeAmount.setLayoutY(225);
		
		//添加组件
		rightPane.getChildren().add(userID);
		rightPane.getChildren().add(rechargeAmount);
		
		AnchorPane.setLeftAnchor(userID, 200.0);
		AnchorPane.setLeftAnchor(rechargeAmount, 200.0);
		
		AnchorPane.setTopAnchor(userID, 150.0);
		AnchorPane.setTopAnchor(rechargeAmount, 225.0);
		
	}
	
	public void setButton(){
		
		//添加按钮
		ok = new Button("确认");
		ok.setId("RechargeCredit");
		ok.setPrefSize(100, 40);
		
		cancel = new Button("取消");
		cancel.setId("RechargeCredit");
		cancel.setPrefSize(100, 40);
				
		//设置按钮位置
		ok.setLayoutX(350);
		ok.setLayoutY(475);
		
		cancel.setLayoutX(550);
		cancel.setLayoutY(475);
		
		//添加按钮监听
		ok.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				OneButtonDialog dialog = new OneButtonDialog("充值成功");
				dialog.show();
			}
			
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				WBVIPInfoController controller = new WBVIPInfoController(new Stage());
				controller.setBlankView();
				Stage stage = controller.getStage();
				stage.show();
			}
			
		});
		
		//添加组件
		rightPane.getChildren().add(ok);
		rightPane.getChildren().add(cancel);
		
		AnchorPane.setLeftAnchor(ok, 150.0);
		AnchorPane.setLeftAnchor(cancel, 350.0);
		
		AnchorPane.setTopAnchor(ok, 475.0);
		AnchorPane.setTopAnchor(cancel, 475.0);
		
	}
	
}
