package viewController;

import javafx.stage.Stage;
import view.right.webBusiness.promotion.First;

public class WebBusinessLeftController {
	
	protected First firstUI;
	private Stage stage;
	
	public WebBusinessLeftController(){
		firstUI = new First(this);
	}
	
	public WebBusinessLeftController(Stage stage){
		this();
		this.stage = stage;
	}
	
	public void setFirstVeiw(){
		firstUI = new First(this);
		stage = new Stage();
		stage.setScene(firstUI.getScene());
		stage.show();
	}
	
	public Stage getStage(){
		return stage;
	}
}
