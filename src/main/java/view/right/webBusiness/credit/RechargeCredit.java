package view.right.webBusiness.credit;

import Message.ResultMessage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import logicService.credit.CreditChangeService;
import logicService.stub.CreditChangeService_Stub;
import view.helpTools.DefaultNums;
import view.helpTools.OneButtonDialog;
import view.left.WebBusinessUI;
import viewController.WBCreditController;
import viewController.WebBusinessLeftController;
import vo.CreditChangeVO;

/**
 * 网站营销人员界面_信用充值_信用充值
 * @author XueWang
 *
 */
public class RechargeCredit {
	
	private WebBusinessLeftController controller;
	private WBCreditController wbcontroller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui;
	
	TextField userID;
	TextField rechargeAmount;
	
	Button ok;
	Button cancel;
	
	public RechargeCredit(WebBusinessLeftController controller){
		
		this.controller = controller;
		wbui = new WebBusinessUI(controller);
		
		leftPane = wbui.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		
		//添加文本框
		setTextField();
		
		//添加按钮
		setButton();
		
		rightPane.getStylesheets().add("/CSS/right.css");
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		root.setStyle("-fx-background-image:url(\"/infoManagement/信用充值背景.jpg\")");
	}
	
	public Scene getScene(){
		return scene;
	}
	
	public void setTextField(){
		
		//添加文本框
		userID = new TextField();
		userID.setPrefSize(200, 30);
		
		rechargeAmount = new TextField();
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
		ok.setPrefSize(100, 40);
		
		cancel = new Button("取消");
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
				wbcontroller = new WBCreditController(controller.getStage(),controller.getUserId());
				//传输vo
				
				try{
					String userId = userID.getText();
					int rechargeCredit = Integer.parseInt(rechargeAmount.getText());
					if(userId != null){ 
						CreditChangeVO creditChangeVO = new CreditChangeVO(userId, rechargeCredit);
						if(wbcontroller.getRechargeResult(creditChangeVO) == ResultMessage.SUCCESS){
							controller.showDialog("充值成功");
						}else{
							controller.showDialog("充值失败");
						}
					}else{
						controller.showDialog("请输入用户名");
					}
				}catch(NumberFormatException e){
					controller.showDialog("信用金额输入错误");
				}
				
				
				//
				
			}
			
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				controller.setBlankView();
				controller.getStage().show();
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
