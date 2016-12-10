package viewController;

import javafx.stage.Stage;
import view.right.webManager.webBusinessInfo.AddWebBusiness;
import view.right.webManager.webBusinessInfo.CheckWebBusiness;
import view.right.webManager.webBusinessInfo.First;
import view.right.webManager.webBusinessInfo.ModifyWebBusiness;
import view.right.webManager.webBusinessInfo.SearchWebBusiness;

public class WMWebBusinessInfoController extends WebManagerLeftController {
	
	private AddWebBusiness addWebBusinessUI;
	private CheckWebBusiness checkWebBusinessUI;
	private ModifyWebBusiness modifyWebBusinessUI;
	private SearchWebBusiness searchWebBusinessUI ;
	
	public WMWebBusinessInfoController(Stage stage,String userID){
		
		this.stage = stage ;
		this.userID = userID;
		
		addWebBusinessUI = new AddWebBusiness(this);
		checkWebBusinessUI = new CheckWebBusiness(this);
		modifyWebBusinessUI = new ModifyWebBusiness(this);
		searchWebBusinessUI = new SearchWebBusiness(this);
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setAddWebBusinessView(){
		
		stage.setScene(addWebBusinessUI.getScene());
		
	}
	
	public void setCheckWebBusinessView(){
		
		stage.setScene(checkWebBusinessUI.getScene());
		
	}
	
	public void setModifyWebBusinessView(){
		
		stage.setScene(modifyWebBusinessUI.getScene());
		
	}
	
	public void setSearchWebBusinessView(){
		
		stage.setScene(searchWebBusinessUI.getScene());
		
	}
	
}
