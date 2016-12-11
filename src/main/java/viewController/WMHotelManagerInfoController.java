package viewController;

import Message.Identity;
import Message.ResultMessage;
import javafx.stage.Stage;
import view.right.webManager.hotelManagerInfo.CheckHotelManager;
import view.right.webManager.hotelManagerInfo.ModifyHotelManager;
import vo.AccountVO;
import vo.HotelManagerVO;

public class WMHotelManagerInfoController extends WebManagerLeftController{
	
	private CheckHotelManager checkHotelManagerUI ;
	private ModifyHotelManager modifyHotelManagerUI ;
	
	private String hotelID = null ;

	public WMHotelManagerInfoController(Stage stage ,String userID){
		
		this.stage = stage ;
		this.userID = userID ;
		
		checkHotelManagerUI = new CheckHotelManager(this);
		modifyHotelManagerUI = new ModifyHotelManager(this);
		
	}
	
	public void setHotelID(String hotelID){
		this.hotelID = hotelID;
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setCheckHotelManagerView(){
		//判断酒店ID是否为null
		if(hotelID == null){
			//若为空，则出错，返回搜索界面
			showDialog("系统错误，返回搜索界面");
			setSearchHotelManagerView();
			stage.show();
			return ;
		}
		
		//判断是否输入了酒店ID
		if(hotelID.equals("")){
			//若为空，则搜索界面未输入，要求输入
			showDialog("请输入酒店工作人员ID");
			return ;
		}
		
		//判断hotel是否存在
		if(updateHotelService.hotelIDExist(hotelID) == ResultMessage.FAILURE ){
			//若不存在
			showDialog("酒店不存在");
			return ;
		}
		
		//判断酒店工作人员是否存在
		if(updateHotelService.hotelHasManager(hotelID) == ResultMessage.FAILURE){
			//若不存在,清空id，什么也没发生
			showDialog("当前酒店没有酒店工作人员");
			hotelID = null;
			return;
		}
		//判断id是否为酒店工作人员
		if(!accountService.userIDExists(hotelID)){
			//若不是
			showDialog("当前ID不是酒店工作人员");
			hotelID = null ;
			return;
		}
		
		//若一切正常
		stage.setScene(checkHotelManagerUI.getScene());
		
	}
	
	public void setModifyHotelManagerView(){
		
		stage.setScene(modifyHotelManagerUI.getScene());
		
	}
	
	public HotelManagerVO getHotelMangerInfo(){
		
		return webManagerService.getHotelManagerInfo(hotelID);
		
	}
	
	public void modifyHotelManagerInfo(){
		String name = modifyHotelManagerUI.getName();
		String id = modifyHotelManagerUI.getId();
		String phone = modifyHotelManagerUI.getPhone();
		String password = modifyHotelManagerUI.getPassword();
		if(name.equals("") || id.equals("") || phone.equals("") || password.equals("")){
			//信息不完整
			showDialog("信息不完整");
			return ;
		}
		HotelManagerVO vo = new HotelManagerVO(hotelID,phone,name,id);
		// 添加酒店工作人员
		ResultMessage result0 = webManagerService.updateHotelManagerInfo(vo);
		// 修改密码
		ResultMessage result1 = accountService.modifyPassword(new AccountVO(hotelID, password, Identity.HOTELMANAGER));
		if(result0 == ResultMessage.SUCCESS && result1 == ResultMessage.SUCCESS){
			//修改成功,清空，返回查看界面
			showDialog("修改成功");
			modifyHotelManagerUI.setBlank();
			setCheckHotelManagerView();
		}else{
			//出错
			showDialog("修改失败，请重试");
			return ;
		}
	}
	
}
