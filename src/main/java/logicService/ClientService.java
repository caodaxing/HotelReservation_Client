package logicService;

import Message.ResultMessage;
import vo.ClientVO;
import vo.HotelManagerVO;
import vo.HotelVO;
import vo.VipVO;
import vo.WebBusinessVO;

public interface ClientService {
	
	//客户
	public ClientVO getClientInfo(String user_ID);
	
	public ResultMessage updateClientInfo(ClientVO new_userInfo);
	
	public ResultMessage registerVIP(VipVO VIPInfo);
	
	public boolean isVIP(String userID);
	
	public VipVO getVipInfo(String userID);
	
	
	//网站管理人员
	
}
