package viewController;

import Message.Identity;
import Message.ResultMessage;
import javafx.stage.Stage;
import logic.picture.Picture;
import logic.user.Client;
import logicService.picture.PictureService;
import logicService.user.ClientService;
import view.right.webManager.userInfo.Blank;
import view.right.webManager.userInfo.CheckUser;
import view.right.webManager.userInfo.ModifyUser;
import vo.ClientVO;

public class WMUserInfoController extends WebManagerLeftController{

	private ClientService clientService ;
	private PictureService pictureService;
	
	private Blank blankUI ;
	private CheckUser checkUserUI ;
	private ModifyUser modifyUserUI ;
	
	private String clientID = null;
	
	public WMUserInfoController(Stage stage ,String userID){
		
		super(stage,userID);
		
		clientService = new Client();
		pictureService = new Picture();
		
	}
	
	public void setClientID(String clientID){
		this.clientID = clientID;
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setBlankView(){
		blankUI = new Blank(this);
		stage.setScene(blankUI.getScene());
	}
	
	public void setCheckUserView(){
		//判断id是否为null,为空则出错
		if(clientID == null ){
			showDialog("系统错误，返回搜索界面");
			setSearchHotelManagerView();
			stage.show();
			return ;
		}
		
		//判断是否输入了客户id
		if(clientID.equals("")){
			//若为空，则搜索界面未输入，要求输入
			showDialog("请输入要查询的客户ID");
			return ;
		}
		
		//判断客户是否存在
		if(!accountService.userIDExists(clientID)){
			//若不存在,清空id
			showDialog("客户不存在");
			clientID = null;
			return;
		}
		//判断是否为客户
		if(! (accountService.getIdentity(clientID) == Identity.CLIENT) ){
			//若不是客户
			showDialog("此ID对应用户不是客户");
			clientID = null;
			return ;
		}
		checkUserUI = new CheckUser(this);
		stage.setScene(checkUserUI.getScene());
		checkUserUI.setText();
		
	}
	
	public void setModifyUserUI(){
		modifyUserUI = new ModifyUser(this);
		stage.setScene(modifyUserUI.getScene());
		modifyUserUI.setText();
	}
	
	public void modifyUserInfo(){
		String name = modifyUserUI.getName();
		String id = modifyUserUI.getId();
		String phone = modifyUserUI.getPhone();
		
		ClientVO vo = getClientInfo();
		vo.trueName = name;
		vo.identityID = id ;
		vo.phoneNumber = phone;
		//不需要判断信息完整性
		
		ResultMessage result = clientService.updateClientInfo(vo);
		if(result == ResultMessage.SUCCESS){
			showDialog("修改成功");
			modifyUserUI.setBlank();
			setCheckUserView();
		}else{
			//出错
			showDialog("修改失败，请重试");
			return ;
		}
			
	}
	
	public ClientVO getClientInfo(){
		return clientService.getClientInfo(clientID);
	}

}
