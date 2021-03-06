package view.left;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import view.helpTools.DefaultNums;
import viewController.WebManagerLeftController;

/**
 * 网站管理人员的左侧导航栏
 * @author XueWang
 *
 */
public class WebManagerUI{

	private WebManagerLeftController controller ;
	
	private GridPane pane;
	
	public WebManagerUI(WebManagerLeftController controller){
		this.controller = controller;
		pane = this.initGridPane();
	}
	
	
	public GridPane getPane(){
		return pane;
	}
	
	public GridPane initGridPane(){
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.BASELINE_LEFT);
		grid.setVgap(DefaultNums.GAP_HEIGHT);
		
		Pane pane = new GridPane();
		Image image = new Image("/head/游客头像.png", 200, 200, false, true);
		ImageView headImage = new ImageView(image);
		pane.getChildren().add(headImage);
		grid.add(pane, 0, 0);
		
		Button manageWebbusiness = new Button("网站营销人员管理");
		manageWebbusiness.setId("light-button");
		manageWebbusiness.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		manageWebbusiness.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setWMWBFirstView();
				controller.getStage().show();
			}
			
		});
		grid.add(manageWebbusiness, 0, 1);
		
		Button manageHotelManager = new Button("酒店工作人员管理");
		manageHotelManager.setId("light-button");
		manageHotelManager.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		manageHotelManager.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setSearchHotelManagerView();
				controller.getStage().show();
			}
			
		});
		grid.add(manageHotelManager, 0, 2);
		
		Button manageUserInfo = new Button("客户信息管理");
		manageUserInfo.setId("light-button");
		manageUserInfo.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		manageUserInfo.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setSearchClientView();
				controller.getStage().show();
			}
			
		});
		grid.add(manageUserInfo, 0, 3);
		
		Button manageHotel = new Button("酒店管理");
		manageHotel.setId("light-button");
		manageHotel.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(manageHotel, 0, 4);
		
		Button addHotel = new Button("添加酒店");
		addHotel.setId("dark-button");
		addHotel.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setAddHotelView();
				controller.getStage().show();
			}
			
		});
		addHotel.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(addHotel, 0, 5);
		
		Button addHotelManager = new Button("添加酒店工作人员");
		addHotelManager.setId("dark-button");
		addHotelManager.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setAddHotelManagerView();
				controller.getStage().show();
			}
			
		});
		addHotelManager.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(addHotelManager, 0, 6);
		
		Button signOut = new Button("注 销");
		signOut.setId("light-button");
		signOut.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setFirstView();
			}
			
		});
		signOut.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(signOut, 0, 7);
		
		grid.getStylesheets().add("/CSS/left.css");
		
		return grid;
	}
	
}
