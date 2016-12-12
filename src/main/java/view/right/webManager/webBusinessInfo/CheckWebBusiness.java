package view.right.webManager.webBusinessInfo;

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
import viewController.WMWebBusinessInfoController;
import vo.WebBusinessVO;

/**
 * 网站管理人员界面_网站营销人员管理_查看详情
 * @author XueWang
 *
 */
public class CheckWebBusiness {

	private WMWebBusinessInfoController controller ;
	
	private Scene scene ;
	
	private WebManagerUI webManagerUI ;

	private GridPane leftPane ;
	
	private AnchorPane rightPane ;
	
	TextField name;
	TextField phone;
	TextField id;
	PasswordField password;
	
	Button modify;
	Button back;
	
	public CheckWebBusiness(WMWebBusinessInfoController controller){
		
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
		password = new PasswordField();
		
		name.setPrefSize(200, 30);
		phone.setPrefSize(200, 30);
		id.setPrefSize(200, 30);
		password.setPrefSize(200, 30);
		
		name.setEditable(false);
		phone.setEditable(false);
		id.setEditable(false);
		password.setEditable(false);
		
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
		
		modify = new Button();
		back = new Button();
		
		modify.setText("修改");
		back.setText("返回");
		
		modify.setPrefSize(100,40);
		back.setPrefSize(100, 40);
		
		modify.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setModifyWebBusinessView();
				controller.getStage().show();
			}
			
		});
		back.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setSearchWebBusinessView();
				controller.getStage().show();
			}
			
		});
		
		rightPane.getChildren().add(modify);
		rightPane.getChildren().add(back);
		
		AnchorPane.setLeftAnchor(modify, 150.0);
		AnchorPane.setTopAnchor(modify, 475.0);
		
		AnchorPane.setLeftAnchor(back, 350.0);
		AnchorPane.setTopAnchor(back, 475.0);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
	public void setText(){
		WebBusinessVO vo = controller.getWebBusinessInfo();
		name.setText(vo.trueName);
		phone.setText(vo.phoneNumber);
		id.setText(vo.numberOfIdentityCard);
		password.setText("123456");
	}
}
