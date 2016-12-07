package viewController;

import javafx.stage.Stage;
import view.right.webManager.webBusinessInfo.AddWebBusiness;
import view.right.webManager.webBusinessInfo.CheckWebBusiness;
import view.right.webManager.webBusinessInfo.First;
import view.right.webManager.webBusinessInfo.ModifyWebBusiness;
import view.right.webManager.webBusinessInfo.SearchWebBusiness;

public class WMWebBusinessInfoController {

	private Stage stage ;
	
	private AddWebBusiness addWebBusinessUI;
	private CheckWebBusiness checkWebBusinessUI;
	private First firstUI;
	private ModifyWebBusiness modifyWebBusinessUI;
	private SearchWebBusiness searchWebBusinessUI;
	
	public WMWebBusinessInfoController(Stage stage){
		
		this.stage = stage ;
		
		addWebBusinessUI = new AddWebBusiness(this);
		checkWebBusinessUI = new CheckWebBusiness(this);
		firstUI = new First(this);
		modifyWebBusinessUI = new ModifyWebBusiness(this);
		searchWebBusinessUI = new SearchWebBusiness(this);
		
	}
	
	public void setAddWebBusinessView(){
		
		stage.setScene(addWebBusinessUI.getScene());
		
	}
	
	public void setCheckWebBusinessView(){
		
		stage.setScene(checkWebBusinessUI.getScene());
		
	}
	
	public void setFirstView(){
		
		stage.setScene(firstUI.getScene());
		
	}
	
	public void setModifyWebBusinessView(){
		
		stage.setScene(modifyWebBusinessUI.getScene());
		
	}
	
	public void setSearchWebBusiness(){
		
		stage.setScene(searchWebBusinessUI.getScene());
		
	}
	
}
