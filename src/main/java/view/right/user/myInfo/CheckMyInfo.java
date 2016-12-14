package view.right.user.myInfo;

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
import viewController.UserLeftController;
import viewController.UserMyInfoController;
import vo.ClientVO;

/**
 * 客户界面_我的信息_查看基本信息（初始界面）
 * @author XueWang
 *
 */
public class CheckMyInfo {
	
	private UserLeftController controller ;
	
	private Scene scene ;
	
	private UserUI userUI;

	private GridPane leftPane ;
	
	private AnchorPane rightPane ;
	
	TextField name;
	TextField phone;
	TextField id;
	TextField credit ;
	
	Button historyCredit;
	Button modify;
	
	public CheckMyInfo(UserLeftController controller){
		
		this.controller = controller;
		
		userUI = new UserUI(controller);
		
		leftPane = userUI.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		setTextField() ;
		
		setButton() ;
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
	
	}
	
	private void setTextField (){
		
		name = new TextField();
		phone = new TextField();
		id = new TextField();
		credit = new TextField();
		
		name.setPrefSize(200, 30);
		phone.setPrefSize(200, 30);
		id.setPrefSize(200, 30);
		credit.setPrefSize(200, 30);
		
		name.setEditable(false);
		phone.setEditable(false);
		id.setEditable(false);
		credit.setEditable(false);
		
		rightPane.getChildren().add(name);
		rightPane.getChildren().add(phone);
		rightPane.getChildren().add(id);
		rightPane.getChildren().add(credit);
		
		AnchorPane.setLeftAnchor(name, 200.0);
		AnchorPane.setLeftAnchor(phone, 200.0);
		AnchorPane.setLeftAnchor(id, 200.0);
		AnchorPane.setLeftAnchor(credit, 200.0);
		
		AnchorPane.setTopAnchor(name, 150.0);
		AnchorPane.setTopAnchor(phone, 225.0);
		AnchorPane.setTopAnchor(id, 300.0);
		AnchorPane.setTopAnchor(credit, 375.0);
		
	}
	
	private void setButton() {
		
		historyCredit = new Button();
		modify = new Button();
		
		historyCredit.setText("查看信用记录");
		modify.setText("修改");
		
		historyCredit.setPrefSize(100, 30);
		modify.setPrefSize(100, 40);
		
		historyCredit.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//查看历史信用记录
				UserMyInfoController right = new UserMyInfoController(controller.getStage(),controller.getUserID());
				setBlank();
				right.setHistoryCreditView();
				right.getStage().show();
			}
			
		});
		modify.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//修改个人信息
				UserMyInfoController right = new UserMyInfoController(controller.getStage(),controller.getUserID());
				setBlank();
				right.setModifyMyInfoView();
				right.getStage().show();
			}
			
		});
		
		rightPane.getChildren().add(historyCredit);
		rightPane.getChildren().add(modify);
		
		AnchorPane.setLeftAnchor(historyCredit, 450.0);
		AnchorPane.setTopAnchor(historyCredit, 375.0);
		
		AnchorPane.setLeftAnchor(modify, 250.0);
		AnchorPane.setTopAnchor(modify, 475.0);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
	
	public void setBlank(){

		name.setText("");
		phone.setText("");
		id.setText("");
		credit.setText("");
		
	}
	
	public void setText(){
		
		ClientVO vo = controller.getMyInfo();
		//根据controller设置text
		name.setText(vo.trueName);
		phone.setText(vo.phoneNumber);
		id.setText(vo.identityID);
		credit.setText(Integer.toString(vo.credit));
		
	}

}
