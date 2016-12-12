package view.right.webManager.hotelInfo;

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
import viewController.WebManagerLeftController;

/**
 * 网站管理人员界面_酒店管理_添加酒店工作人员
 * @author XueWang
 *
 */
public class AddHotelManager {
	
	private WebManagerLeftController controller ;
	
	private Scene scene ;
	
	private WebManagerUI webManagerUI ;

	private GridPane leftPane ;
	
	private AnchorPane rightPane ;
	
	TextField hotelID ;
	TextField name ;
	TextField id ;
	TextField phone ;
	TextField password ;
	
	Button confirm;
	Button cancel;
	
	public AddHotelManager(WebManagerLeftController controller){
		
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
	//addhotel后跳入对应酒店添加工作人员的界面
	public AddHotelManager(WebManagerLeftController controller, String ID){
		this(controller);
		hotelID.setText(ID);
	}
	
	private void setTextField (){
		
		hotelID = new TextField();
		name = new TextField();
		id = new TextField();
		phone = new TextField();
		password = new TextField();
		
		hotelID.setPrefSize(200, 30);
		name.setPrefSize(200, 30);
		id.setPrefSize(200, 30);
		phone.setPrefSize(200, 30);
		password.setPrefSize(200, 30);
		
		hotelID.setEditable(true);
		name.setEditable(true);
		id.setEditable(true);
		phone.setEditable(true);
		password.setEditable(true);
		
		rightPane.getChildren().add(hotelID);
		rightPane.getChildren().add(name);
		rightPane.getChildren().add(id);
		rightPane.getChildren().add(phone);
		rightPane.getChildren().add(password);
		
		AnchorPane.setLeftAnchor(hotelID, 200.0);
		AnchorPane.setLeftAnchor(name, 200.0);
		AnchorPane.setLeftAnchor(id, 200.0);
		AnchorPane.setLeftAnchor(phone, 200.0);
		AnchorPane.setLeftAnchor(password, 200.0);
		
		AnchorPane.setTopAnchor(hotelID, 150.0);
		AnchorPane.setTopAnchor(name, 225.0);
		AnchorPane.setTopAnchor(id, 300.0);
		AnchorPane.setTopAnchor(phone, 375.0);
		AnchorPane.setTopAnchor(password, 450.0);
		
	}
	
	private void setButton() {
		
		confirm = new Button();
		cancel = new Button();
		
		confirm.setText("确认");
		cancel.setText("取消");
		
		confirm.setPrefSize(100, 40);
		cancel.setPrefSize(100, 40);
		
		confirm.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//确认添加
				controller.addHotelManager();
				controller.getStage().show();
			}
			
		});
		cancel.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//取消添加，清空输入框
				setBlank();
			}
			
		});
		
		rightPane.getChildren().add(confirm);
		rightPane.getChildren().add(cancel);
		
		AnchorPane.setLeftAnchor(confirm, 150.0);
		AnchorPane.setTopAnchor(confirm, 525.0);
		
		AnchorPane.setLeftAnchor(cancel, 350.0);
		AnchorPane.setTopAnchor(cancel, 525.0);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
	public String getHotelID(){
		return hotelID.getText();
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
		hotelID.setText("");
		name.setText("");
		phone.setText("");
		id.setText("");
		password.setText("");
	}
	
}
