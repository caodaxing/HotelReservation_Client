package logicService.user;

import Message.ResultMessage;
import vo.ClientVO;
import vo.VipVO;

/**
 * 有关客户基本信息处理的接口
 * @author Mark.W
 *
 */
public interface ClientService {
	
	//客户
	public ClientVO getClientInfo(String user_ID);
	
	public ResultMessage updateClientInfo(ClientVO new_userInfo);
	
	public ResultMessage registerVIP(VipVO VIPInfo);
	
	public boolean isVIP(String userID);
	
	public VipVO getVipInfo(String userID);
	
}
