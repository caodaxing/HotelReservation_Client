package view.right.webBusiness.VIPInfo;

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
import viewController.WBVIPInfoController;
import viewController.WebBusinessLeftController;

/**
 * 网站营销人员界面_会员_管理会员等级
 * @author XueWang
 *
 */
public class SetVIPCredit {
	
	private WebBusinessLeftController controller;
	private Scene scene;
	private GridPane leftPane;
	private AnchorPane rightPane;
	private WebBusinessUI wbui;
	
	TextField updateVIP1;
	TextField updateVIP2;
	TextField updateVIP3;
	
	Button cancel;
	Button ok;
	
	public SetVIPCredit(WebBusinessLeftController controller){
		
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
		
		HBox root = new HBox(leftPane, rightPane);
		scene = new Scene(root, DefaultNums.WIDTH, DefaultNums.HEIGHT);
	}
	
	public Scene getScene(){
		return scene;
	}
	
	private void setTextField(){
		
		//ArrayList<String> infoList = controller.getInfoList();
		//添加文本框
		updateVIP1 = new TextField();
		updateVIP1.setId("SetVIPCredit");
		updateVIP1.setPrefSize(200, 30);
				
		updateVIP2 = new TextField();
		updateVIP2.setId("SetVIPCredit");
		updateVIP2.setPrefSize(200, 30);
			
		updateVIP3 = new TextField();
		updateVIP3.setId("SetVIPCredit");
		updateVIP3.setPrefSize(200, 30);
				
		//设置文本框内容
				
		//设置文本框内容不可更改
		updateVIP1.setEditable(true);
		updateVIP2.setEditable(true);
		updateVIP3.setEditable(true);
				
		//设置文本框位置
		updateVIP1.setLayoutX(400);
		updateVIP1.setLayoutY(150);
				
		updateVIP2.setLayoutX(400);
		updateVIP2.setLayoutY(200);
				
		updateVIP3.setLayoutX(400);
		updateVIP3.setLayoutY(250);
				
				
		//添加组件
		rightPane.getChildren().add(updateVIP1);
		rightPane.getChildren().add(updateVIP2);
		rightPane.getChildren().add(updateVIP3);
				
		AnchorPane.setLeftAnchor(updateVIP1, 200.0);
		AnchorPane.setLeftAnchor(updateVIP2, 200.0);
		AnchorPane.setLeftAnchor(updateVIP3, 200.0);
				
		AnchorPane.setTopAnchor(updateVIP1, 150.0);
		AnchorPane.setTopAnchor(updateVIP2, 200.0);
		AnchorPane.setTopAnchor(updateVIP3, 250.0);
		
	}
	
	private void setButton(){
		
		//添加按钮
		ok = new Button("确认");
		ok.setId("SetVIPCredit");
		ok.setPrefSize(100, 40);
		
		cancel = new Button("取消");
		cancel.setId("SetVIPCredit");
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
				OneButtonDialog dialog = new OneButtonDialog("设置成功");
				dialog.show();
				//传输vo
				updateVIP1.getText();
				updateVIP2.getText();
				updateVIP3.getText();
				//
				updateVIP1.setText("");
				updateVIP2.setText("");
				updateVIP3.setText("");
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
