package view.right.user.myInfo;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import viewController.UserMyInfoController;
import vo.ClientVO;

/**
 * 客户界面_我的信息_修改基本信息
 * @author XueWang
 *
 */
public class ModifyMyInfo {

	private UserMyInfoController controller ;
	
	private Scene scene ;
	
	private UserUI userUI;

	private GridPane leftPane ;
	
	private AnchorPane rightPane ;
	
	TextField name;
	TextField phone;
	TextField id;
	
	FileChooser fileChooser;
	TextField head ;
	
	Button confirm;
	Button cancel;
	Button choose;
	
	public ModifyMyInfo(UserMyInfoController controller){
		
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

		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/infoManagement/基本信息_修改基本信息界面背景.jpg\")");
	}
	
	private void setTextField (){
		
		ClientVO vo = controller.getMyInfo();
		
		name = new TextField();
		phone = new TextField();
		id = new TextField();
		head = new TextField();
		
		if(vo!=null){
		//根据controller设置text
			name.setText(vo.trueName);
			phone.setText(vo.phoneNumber);
			id.setText(vo.identityID);
		}
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
	
	private void openFileChooser(){
		
		fileChooser = new FileChooser();
		fileChooser.setTitle("选择头像");
		fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
		Stage s = new Stage();
		File file = fileChooser.showOpenDialog(s);
		if(file==null){
			controller.showDialog("请选择图片");
			return;
		}
		String exportFilePath= file.getAbsolutePath();
		head.setText(exportFilePath);
		
	}
	
	private void setButton() {
		
		confirm = new Button();
		cancel = new Button();
		choose = new Button();
		
		confirm.setText("确认");
		cancel.setText("取消");
		choose.setText("选择图片");
		
		confirm.setPrefSize(100, 40);
		cancel.setPrefSize(100, 40);
		choose.setPrefSize(100, 30);
		
		confirm.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//确认修改
				controller.modifyMyInfo();
			}
			
		});
		cancel.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//取消修改，清空，返回查看界面
				setBlank();
				controller.setCheckMyInfoView();
				controller.getStage().show();
			}
			
		});
		choose.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//打开文件选择器
				openFileChooser();
			}
			
		});
		
		rightPane.getChildren().add(confirm);
		rightPane.getChildren().add(cancel);
		rightPane.getChildren().add(choose);
		
		AnchorPane.setLeftAnchor(confirm, 150.0);
		AnchorPane.setTopAnchor(confirm, 475.0);
		
		AnchorPane.setLeftAnchor(cancel, 350.0);
		AnchorPane.setTopAnchor(cancel, 475.0);
		
		AnchorPane.setLeftAnchor(choose, 450.0);
		AnchorPane.setTopAnchor(choose,375.0);
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
	
	public String getHeadUrl(){
		return head.getText();
	}
	
	public String getID(){
		return id.getText();
	}
	
	public void setBlank(){
		name.setText("");
		id.setText("");
		phone.setText("");
		head.setText("");
	}
	
}
