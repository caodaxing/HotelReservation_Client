package view.right.webManager.hotelManagerInfo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.WebManagerUI;
import viewController.WMHotelManagerInfoController;
import viewController.WMUserInfoController;
import vo.HotelManagerVO;

/**
 * 网站管理人员界面_酒店工作人员管理_修改信息
 * @author XueWang
 *
 */
public class ModifyHotelManager {

	private WMHotelManagerInfoController controller ;
	
	private Scene scene ;
	
	private WebManagerUI webManagerUI;

	private GridPane leftPane ;
	
	private AnchorPane rightPane ;
	
	TextField name;
	TextField phone;
	TextField id;
	TextField password;
	
	Button confirm;
	Button cancel;
	
	public ModifyHotelManager(WMHotelManagerInfoController controller){
		
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
	
	}
	
	private void setTextField (){
		
		name = new TextField();
		phone = new TextField();
		id = new TextField();
		password = new TextField();
		
		//根据controller内容修改
		HotelManagerVO vo = controller.getHotelMangerInfo();
		name.setText(vo.trueName);
		phone.setText(vo.phoneNumber);
		id.setText(vo.numberOfIdentityCard);
		
		name.setPrefSize(200, 30);
		phone.setPrefSize(200, 30);
		id.setPrefSize(200, 30);
		password.setPrefSize(200, 30);
		
		name.setEditable(true);
		phone.setEditable(true);
		id.setEditable(true);
		password.setEditable(true);
		
		rightPane.getChildren().add(name);
		rightPane.getChildren().add(phone);
		rightPane.getChildren().add(id);
		rightPane.getChildren().add(password);
		
		AnchorPane.setLeftAnchor(name, 200.0);
		AnchorPane.setLeftAnchor(phone, 200.0);
		AnchorPane.setLeftAnchor(id, 200.0);
		AnchorPane.setLeftAnchor(password, 200.0);
		
		AnchorPane.setTopAnchor(name, 150.0);
		AnchorPane.setTopAnchor(phone, 225.0);
		AnchorPane.setTopAnchor(id, 300.0);
		AnchorPane.setTopAnchor(password, 375.0);
		
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
				controller.modifyHotelManagerInfo();
				controller.getStage().show();
			}
			
		});
		cancel.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//取消修改，清空textfield，返回查看界面
				setBlank();
				controller.setCheckHotelManagerView();
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
	
	public String getPassword(){
		return password.getText();
	}
	
	public void setBlank(){
		name.setText("");
		phone.setText("");
		id.setText("");
		password.setText("");
	}
	
}
