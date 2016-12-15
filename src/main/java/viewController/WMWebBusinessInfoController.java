package viewController;

import Message.Identity;
import Message.ResultMessage;
import javafx.stage.Stage;
import logic.utility.Encryption;
import logicService.stub.WebBusinessService_Stub;
import logicService.user.WebBusinessService;
import view.right.webManager.webBusinessInfo.AddWebBusiness;
import view.right.webManager.webBusinessInfo.CheckWebBusiness;
import view.right.webManager.webBusinessInfo.ModifyWebBusiness;
import view.right.webManager.webBusinessInfo.SearchWebBusiness;
import vo.AccountVO;
import vo.WebBusinessVO;

public class WMWebBusinessInfoController extends WebManagerLeftController {
	
	private WebBusinessService webBusinessService;
	
	private AddWebBusiness addWebBusinessUI;
	private CheckWebBusiness checkWebBusinessUI;
	private ModifyWebBusiness modifyWebBusinessUI;
	private SearchWebBusiness searchWebBusinessUI ;
	
	private String webBusinessID = null ;
	
	public WMWebBusinessInfoController(Stage stage,String userID){
		
		this.stage = stage ;
		this.userID = userID;
		
		webBusinessService = new WebBusinessService_Stub();
		
		addWebBusinessUI = new AddWebBusiness(this);
		checkWebBusinessUI = new CheckWebBusiness(this);
		modifyWebBusinessUI = new ModifyWebBusiness(this);
		searchWebBusinessUI = new SearchWebBusiness(this);
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setWebBusinessID(String webBusinessID){
		this.webBusinessID = webBusinessID;
	}
	
	public void setAddWebBusinessView(){
		
		stage.setScene(addWebBusinessUI.getScene());
		
	}
	
	public void setCheckWebBusinessView(){
		//判断是否为null，是则出错
		if(webBusinessID == null){
			showDialog("系统错误，返回搜索界面");
			setSearchWebBusinessView();
		}
		
		//判断是否输入了网站营销人员id
		if(webBusinessID.equals("")){
			showDialog("请输入要查询的ID");
			return ;
		}
		
		//判断是否存在
		if(!accountService.userIDExists(webBusinessID)){
			showDialog("ID不存在");
			webBusinessID = null;
			return ;
		}
		
		//判断是否为网站营销人员
		if(! (accountService.getIdentity(webBusinessID) == Identity.WEBBUSSINESS) ){
			//若不是网站营销人员
			showDialog("此ID对应用户不是网站营销人员");
			webBusinessID = null;
			return ;
		}
		
		stage.setScene(checkWebBusinessUI.getScene());
		checkWebBusinessUI.setText();
	}
	
	public void setModifyWebBusinessView(){
		
		stage.setScene(modifyWebBusinessUI.getScene());
		modifyWebBusinessUI.setText();
		
	}
	
	public void setSearchWebBusinessView(){
		
		stage.setScene(searchWebBusinessUI.getScene());
		
	}
	
	public WebBusinessVO getWebBusinessInfo(){
		
		return webBusinessService.getWebBusinessInfo(webBusinessID);
				
	}
	
	public void addWebBusiness(){
		
		String webBusinessID = addWebBusinessUI.getId();
		String name = addWebBusinessUI.getName();
		String phone = addWebBusinessUI.getPhone();
		String password = addWebBusinessUI.getPassword();
		
		if(webBusinessID.equals("") || name.equals("") || phone.equals("") || password.equals("")){
			//信息填写不完整
			showDialog("请填写完整");
			return ;
		}
		
		if(webBusinessID.length()<6 || webBusinessID.length()>12){
			//长度<6或长度>12
			showDialog("网站营销人员ID需为6-12位");
			return ;
		}
		
		if(accountService.userIDExists(webBusinessID)){
			//若id已存在
			showDialog("此ID已存在，请重新输入");
			return ;
		}
		
		WebBusinessVO vo = new WebBusinessVO(webBusinessID,name,phone,"");
		ResultMessage result0 = webManagerService.addWebBusiness(vo);
		ResultMessage result1 = accountService.register(Encryption.getInstance().encrypt(new AccountVO(webBusinessID,password,Identity.WEBBUSSINESS)));
		if(result0 == ResultMessage.SUCCESS && result1 == ResultMessage.SUCCESS){
			//成功，清空输入框，跳至选择界面
			showDialog("添加成功");
			addWebBusinessUI.setBlank();
			setWMWBFirstView();
		}else{
			showDialog("添加失败，请重试");
			return ;
		}
	}
	
	public void modifyWebBusinessInfo(){
		String name = modifyWebBusinessUI.getName();
		String phone = modifyWebBusinessUI.getPhone();
		String password = modifyWebBusinessUI.getPassword();
		
		if(name.equals("") || phone.equals("") || password.equals("")){
			showDialog("请填写完整");
			return ;
		}
		
		WebBusinessVO vo = getWebBusinessInfo();
		vo.trueName = name;
		vo.phoneNumber = phone ;
		
		ResultMessage result0 = webManagerService.updateWebBusinessInfo(vo);
		ResultMessage result1 = accountService.modifyPassword(Encryption.getInstance().encrypt(new AccountVO(webBusinessID,password,Identity.WEBBUSSINESS)));
		if(result0 == ResultMessage.SUCCESS && result1 == ResultMessage.SUCCESS){
			showDialog("修改成功");
			modifyWebBusinessUI.setBlank();
			setCheckWebBusinessView();
		}else{
			//出错
			showDialog("修改失败，请重试");
			return ;
		}
		
		
		
	}
	
}
