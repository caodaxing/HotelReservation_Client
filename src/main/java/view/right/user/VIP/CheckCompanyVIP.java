package view.right.user.VIP;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import view.helpTools.DefaultNums;
import view.left.UserUI;
import viewController.UserLeftController;
import vo.VipVO;

public class CheckCompanyVIP {

	private UserLeftController controller;
	
	private Scene scene ;
	
	private UserUI userUI ;	
	
	private GridPane leftPane ;
	
	private AnchorPane rightPane;
	
	TextField company;
	
	public CheckCompanyVIP(UserLeftController controller){
		
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
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root,DefaultNums.WIDTH,DefaultNums.HEIGHT);

		rightPane.getStylesheets().add("/CSS/right.css");
		root.setStyle("-fx-background-image:url(\"/vipImage/会员_企业会员界面背景.png\")");
	}
	
	private void setTextField(){
		
		company = new TextField();
		
		company.setEditable(false);
		
		company.setPrefSize(200, 30);
		
		rightPane.getChildren().add(company);
		
		AnchorPane.setLeftAnchor(company, 250.0);
		AnchorPane.setTopAnchor(company, 150.0);
		
	}
	
	public Scene getScene(){
		
		return scene;
	
	}
	
	public void setText(){

		//根据controller显示数据
		VipVO vo = controller.getVIPInfo();
		company.setText(vo.info);
	}

}
