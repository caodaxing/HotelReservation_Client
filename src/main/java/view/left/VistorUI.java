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
import viewController.VistorLeftController;

/**
 * 游客左侧导航栏
 * @author XueWang
 *
 */
public class VistorUI{
	
	private GridPane pane;
	
	private VistorLeftController controller;
	
	public VistorUI(VistorLeftController controller ){
		
		this.controller = controller;
		pane = this.initGridPane();
		
		Pane imagePane = new GridPane();
		Image image = new Image("/head/游客头像.png", 200, 200, false, true);
		ImageView headImage = new ImageView(image);
		pane.getChildren().add(headImage);
		pane.add(imagePane, 0, 0);
		
	}
	
	public GridPane getPane(){
		return pane;
	}
	
	public GridPane initGridPane(){
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.BASELINE_LEFT);
		grid.setVgap(DefaultNums.GAP_HEIGHT);
		
		GridPane pane = new GridPane();
		pane.setPrefSize(200, 200);
		grid.add(pane, 0, 0);
		
		Button signIn = new Button("登 录");
		signIn.setId("light-button");
		signIn.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(signIn, 0, 1);
		
		Button signUp = new Button("注 册");
		signUp.setId("light-button");
		signUp.setPrefSize(DefaultNums.LEFT_BUTTON_WIDTH, DefaultNums.LEFT_BIG_BUTTON_HEIGHT);
		grid.add(signUp, 0, 2);
		
		signIn.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setSignInView();
			}
			
		});
		signUp.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				controller.setSignUpView();
			}
			
		});
		
		grid.getStylesheets().add("/CSS/left.css");
		
		return grid;
		
	}
	
}
