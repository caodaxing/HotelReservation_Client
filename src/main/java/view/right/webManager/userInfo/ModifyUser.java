package view.right.webManager.userInfo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.WebManagerUI;
import viewController.WMUserInfoController;
import vo.ClientVO;

/**
 * 网站管理人员界面_客户管理_修改客户信息
 * @author XueWang
 *
 */
public class ModifyUser {

	private WMUserInfoController controller ;
	
	private Scene scene ;
	
	private WebManagerUI webManagerUI;

	private GridPane leftPane ;
	
	private AnchorPane rightPane ;
	
	TextField name;
	TextField phone;
	TextField id;
	TextField head;
	
	Button confirm;
	Button cancel;
	
	public ModifyUser(WMUserInfoController controller){
		
		this.controller = controller;
		
		webManagerUI = new WebManagerUI(controller);
		
		leftPane = webManagerUI.getPane();
		leftPane.setPrefSize(DefaultNums.LEFT_WIDTH, DefaultNums.HEIGHT);
		
		rightPane = new AnchorPane();
		rightPane.setPrefSize(DefaultNums.RIGHT_WIDTH, DefaultNums.HEIGHT);
		
		setTextField() ;
		
		setButton() ;
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);

		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/infoManagement/用户管理_修改客户信息背景.jpg\")");
	}
	
	private void setTextField (){
		
		name = new TextField();
		phone = new TextField();
		id = new TextField();
		head = new TextField();
		
		name.setPrefSize(200, 30);
		phone.setPrefSize(200, 30);
		id.setPrefSize(200, 30);
		head.setPrefSize(200, 30);
		
		name.setEditable(true);
		phone.setEditable(true);
		id.setEditable(true);
		head.setEditable(false);
		
		rightPane.getChildren().add(name);
		rightPane.getChildren().add(phone);
		rightPane.getChildren().add(id);
		rightPane.getChildren().add(head);
		
		AnchorPane.setLeftAnchor(name, 200.0);
		AnchorPane.setLeftAnchor(phone, 200.0);
		AnchorPane.setLeftAnchor(id, 200.0);
		AnchorPane.setLeftAnchor(head, 200.0);
		
		AnchorPane.setTopAnchor(name, 150.0);
		AnchorPane.setTopAnchor(phone, 225.0);
		AnchorPane.setTopAnchor(id, 300.0);
		AnchorPane.setTopAnchor(head, 375.0);
		
	}
	
	private void setButton() {
		
		confirm = new Button();
		cancel = new Button();
		
		confirm.setText("确认");
		cancel.setText("取消");
		
		confirm.setPrefSize(100,40);
		cancel.setPrefSize(100, 40);
		
		confirm.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//确定修改（userID已保存在controller中）
				controller.modifyUserInfo();
				controller.getStage().show();
			}
			
		});
		cancel.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//取消修改，清空textfield，返回查看界面
				setBlank();
				controller.setCheckUserView();
				controller.getStage().show();
			}
			
		});
		
		rightPane.getChildren().add(confirm);
		rightPane.getChildren().add(cancel);
		
		AnchorPane.setLeftAnchor(confirm, 150.0);
		AnchorPane.setTopAnchor(confirm, 475.0);
		
		AnchorPane.setLeftAnchor(cancel, 350.0);
		AnchorPane.setTopAnchor(cancel, 475.0);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	public String getName(){
		return name.getText();
	}
	
	public String getPhone(){
		return phone.getText();
	}
	
	public String getId(){
		return id.getText();
	}
	
	public void setBlank(){
		name.setText("");
		phone.setText("");
		id.setText("");
	}
	
	public void setText(){
		//根据controller显示
		ClientVO vo = controller.getClientInfo();
		name.setText(vo.trueName);
		phone.setText(vo.phoneNumber);
		id.setText(vo.identityID);
		head.setText(controller.getHeadPath());
	}
}
