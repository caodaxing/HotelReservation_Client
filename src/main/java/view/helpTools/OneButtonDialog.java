package view.helpTools;

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

public class OneButtonDialog {

	private Stage stage ;
	
	private Label label ;
	
	private Button button ;
	
	public OneButtonDialog(String labelText){
		
		stage = new Stage();
		stage.setTitle("提示");
		stage.centerOnScreen();
		stage.setAlwaysOnTop(true);
		stage.setResizable(false);
		
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(320.0, 150.0);
		
		label = new Label();
		label.setText(labelText);
		label.setPrefSize(240.0, 30);
		label.setAlignment(Pos.CENTER);
		pane.getChildren().add(label);
		AnchorPane.setLeftAnchor(label, 40.0);
		AnchorPane.setTopAnchor(label, 40.0);
		
		button = new Button();
		button.setText("确认");
		button.setPrefSize(60.0, 30.0);
		button.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				Event.fireEvent(stage, new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST ));
			}
		});
		pane.getChildren().add(button);
		AnchorPane.setLeftAnchor(button, 130.0);
		AnchorPane.setTopAnchor(button, 100.0);
		
		Scene scene = new Scene(pane,320,150);
		scene.getStylesheets().add("/CSS/right.css");
		stage.setScene(scene);
		
	}
	
	public void show(){
		stage.show();
	}
	
}
