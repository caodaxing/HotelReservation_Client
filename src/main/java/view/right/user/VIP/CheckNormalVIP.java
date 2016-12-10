package view.right.user.VIP;

import java.time.LocalDate;

import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import viewController.UserLeftController;
import vo.VipVO;

public class CheckNormalVIP {

	private UserLeftController controller;
	
	private Scene scene ;
	
	private UserUI userUI ;	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	TextField birthday ;
	
	public CheckNormalVIP(UserLeftController controller){
		
		this.controller = controller;
		
		userUI = new UserUI(controller);
		
		// 初始化左侧Pane
		leftPane = userUI.getPane() ;
		leftPane.setPrefSize ( DefaultNums.LEFT_WIDTH , DefaultNums.HEIGHT );
		
		//初始化右侧Pane
		rightPane = new AnchorPane();
		rightPane.setPrefSize( DefaultNums.RIGHT_WIDTH , DefaultNums.HEIGHT );
		
		setTextField();
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);
		
	}
	
	private void setTextField(){
		
		birthday = new TextField();
		
		//根据controller显示数据
		VipVO vo = controller.getVIPInfo();
		birthday.setText(vo.info);
		
		birthday.setPrefSize(200, 30);
		
		rightPane.getChildren().add(birthday);
		
		AnchorPane.setLeftAnchor(birthday, 200.0);
		AnchorPane.setTopAnchor(birthday, 150.0);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
}
