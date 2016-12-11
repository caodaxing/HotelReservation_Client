package view.right.webBusiness.promotion;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import viewController.WBPromotionController;
import viewController.WebBusinessLeftController;

public class Prompt {
	private Stage stage ;
	
	private Label label ;
	
	private Button button1 ;
	
	public Prompt(String labelText){
		
		stage = new Stage();
		stage.setTitle("提示");
		stage.centerOnScreen();
		stage.setAlwaysOnTop(true);
		
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(300.0, 150.0);
		
		label = new Label();
		label.setText(labelText);
		label.setPrefSize(200.0, 30);
		label.setAlignment(Pos.CENTER);
		pane.getChildren().add(label);
		AnchorPane.setLeftAnchor(label, 50.0);
		AnchorPane.setTopAnchor(label, 40.0);
		
		button1 = new Button();
		button1.setText("确认");
		button1.setPrefSize(60.0, 30.0);
		button1.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				Event.fireEvent(stage, new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST ));
				
			}
		});
		pane.getChildren().add(button1);
		AnchorPane.setLeftAnchor(button1, 120.0);
		AnchorPane.setTopAnchor(button1, 100.0);
		
		Scene scene = new Scene(pane,300,150);
		stage.setScene(scene);
		
	}
	
	public void show(){
		stage.show();
	}
}
