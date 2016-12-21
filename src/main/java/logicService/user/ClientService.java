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
	
	/**
	 * 添加客户信息
	 * @param user_ID
	 * @return
	 */
	public ClientVO getClientInfo(String user_ID);
	
	/**
	 * 更新客户基本信息
	 * @param new_userInfo
	 * @return ResultMessage
	 */
	public ResultMessage updateClientInfo(ClientVO new_userInfo);
	
	/**
	 * 注册会员信息
	 * @param VIPInfo
	 * @return
	 */
	public ResultMessage registerVIP(VipVO VIPInfo);
	
	/**
	 * 判断某个用户是否时vip
	 * @param userID
	 * @return
	 */
	public boolean isVIP(String userID);
	
	/**
	 * 获取某个用户的vip信息
	 * @param userID
	 * @return
	 */
	public VipVO getVipInfo(String userID);
	
}
