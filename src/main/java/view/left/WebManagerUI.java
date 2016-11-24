package view.left;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.helpTools.DefaultNums;

/**
 * 网站管理人员的左侧导航栏
 * @author XueWang
 *
 */
public class WebManagerUI extends Application{

	public void refreshLeft(){
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Rookie Travel");
		primaryStage.show();
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.BASELINE_LEFT);
		grid.setVgap(DefaultNums.GAP_HEIGHT);
		
		Pane pane = new GridPane();
		Image image = new Image("Image\\index.jpg");
		ImageView headImage = new ImageView(image);
		pane.getChildren().add(headImage);
		grid.add(pane, 0, 0);
		
		Button webBusinessInfo = new Button("网站营销人员管理");
		webBusinessInfo.setId("LightButton");
		grid.add(webBusinessInfo, 0, 1);
		
		Button hotelManagerInfo = new Button("酒店工作人员管理");
		hotelManagerInfo.setId("LightButton");
		grid.add(hotelManagerInfo, 0, 2);
		
		Button userInfo = new Button("客户信息管理");
		userInfo.setId("LightButton");
		grid.add(userInfo, 0, 3);
		
		Button hotelInfo = new Button("酒店管理");
		hotelInfo.setId("LightButton");
		grid.add(hotelInfo, 0, 4);
		
		Button addHotel = new Button("添加酒店");
		addHotel.setId("DarkButton");
		grid.add(addHotel, 0, 5);
		
		Button addHotelManager = new Button("添加酒店工作人员");
		addHotelManager.setId("DarkButton");
		grid.add(addHotelManager, 0, 6);
		
		Button signOut = new Button("注销");
		signOut.setId("LightButton");
		grid.add(signOut, 0, 11);
		
		Scene scene = new Scene(grid, DefaultNums.WIDTH, DefaultNums.HEIGHT);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("wb.css").toExternalForm());
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
