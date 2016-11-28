package logic.user;


import Message.ResultMessage;
import data.stub.ClientDao_Stub;
import dataDao.ClientDao;
import po.ClientPO;
import vo.ClientVO;
import vo.VipVO;

/**
 * 管理客户信息的类
 * @author Xue.W
 */
public class Client{
	
	private String clientID;
	private ClientPO clientPO;
	private ClientDao clientDao;

	public Client(){}
	
	public Client(String clientID){
		this.clientID = clientID;
		clientDao = new ClientDao_Stub();
		this.initClientPO();
	}	
	
	//初始化成员变量clientpo
	private void initClientPO() {
		ClientPO po = clientDao.getClientInfo(this.clientID);
		if(po != null) {
			this.clientPO = po;
		}
	}
	
	
	/**
	 * 获得用户（会员）信息
	 * @param clientID 传入的用户ID信息
	 * @return 返回用户信息
	 * @author Xue.W
	 */
	public ClientVO getClientInfo (String clientID){
		ClientPO po = clientDao.getClientInfo(clientID);
		return new ClientVO(po.getUserID(),po.getPhoneNumber(), po.getTrueName(), 
				po.getCredit(), po.getVipType(), po.getVipLevel(), po.getVipInfo());
	}
	
	/**
	 * 修改用户信息
	 * @param  clientInfo 传入的用户信息
	 * @return 返回是否修改成功
	 * @author Xue.W
	 */
	public ResultMessage updateClientInfo(ClientVO clientVO){
		if(clientVO == null) {
			return ResultMessage.FAILURE;
		}
		
		ClientPO po = new ClientPO(clientVO.userID, clientVO.phoneNumber, clientVO.trueName,
				clientVO.credit, clientVO.vipType, clientVO.vipLevel, clientVO.vipInfo);
		
		if(clientDao.updateClientInfo(po)){
			this.clientPO = po;					//同时更新类中的成员变量po
			return ResultMessage.SUCCESS;
		}
		
		return ResultMessage.FAILURE;
	}
	
	/**
	 * 注册会员
	 * @param VIPInfo 传入的注册会员信息
	 * @return 返回是否注册成功
	 * @author Xue.W
	 */
	public ResultMessage registerVIP(VipVO vipVO){
		
		if(!isVIP(vipVO.userID)) {
			ClientPO po = this.clientPO;
			po.setVipType(vipVO.type);
			po.setVipLevel(vipVO.level);
			po.setVipInfo(vipVO.info);
			
			if(clientDao.updateClientInfo(po)){
				return ResultMessage.SUCCESS;
			}
		}
		
		return ResultMessage.FAILURE;
	}
	
	public boolean isVIP(String userID) {
		if(this.clientPO != null && this.clientPO.getVipType() != 0) {
			return true;
		}
		return false;
	}
}
