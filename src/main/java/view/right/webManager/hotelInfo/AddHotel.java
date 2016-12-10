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
 * 网站管理人员界面_酒店管理_添加酒店
 * @author XueWang
 *
 */
public class AddHotel {

	private WebManagerLeftController controller ;
	
	private Scene scene ;
	
	private WebManagerUI webManagerUI ;

	private GridPane leftPane ;
	
	private AnchorPane rightPane ;
	
	TextField hotelID;
	TextField hotelName;
	TextField city;
	TextField area;
	
	Button confirm;
	Button cancel;
	
	public AddHotel(WebManagerLeftController controller){
		
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
		
		hotelID = new TextField();
		hotelName = new TextField();
		city = new TextField();
		area = new TextField();
		
		hotelID.setPrefSize(200, 30);
		hotelName.setPrefSize(200, 30);
		city.setPrefSize(200, 30);
		area.setPrefSize(200, 30);
		
		hotelID.setEditable(true);
		hotelName.setEditable(true);
		city.setEditable(true);
		area.setEditable(true);
		
		rightPane.getChildren().add(hotelID);
		rightPane.getChildren().add(hotelName);
		rightPane.getChildren().add(city);
		rightPane.getChildren().add(area);
		
		AnchorPane.setLeftAnchor(hotelID, 200.0);
		AnchorPane.setLeftAnchor(hotelName, 200.0);
		AnchorPane.setLeftAnchor(city, 200.0);
		AnchorPane.setLeftAnchor(area, 200.0);
		
		AnchorPane.setTopAnchor(hotelID, 150.0);
		AnchorPane.setTopAnchor(hotelName, 225.0);
		AnchorPane.setTopAnchor(city, 300.0);
		AnchorPane.setTopAnchor(area, 375.0);
		
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
				controller.addHotel();
				controller.getStage().show();
			}
			
		});
		cancel.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				//取消，清空textfield
				setBlank();
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
	
	public String getHotelID(){
		return hotelID.getText();
	}
	
	public String getHotelName(){
		return hotelName.getText();
	}
	
	public String getCity(){
		return city.getText();
	}
	
	public String getArea(){
		return area.getText();
	}
	
	public void setBlank(){
		hotelID.setText("");
		hotelName.setText("");
		city.setText("");
		area.setText("");
	}
}
