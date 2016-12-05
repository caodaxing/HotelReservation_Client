package logic.user;


import Message.ResultMessage;
import dataDao.stub.ClientDao_Stub;
import dataDao.user.ClientDao;
import logic.utility.ClientTransform;
import logicService.user.ClientService;
import po.ClientPO;
import vo.ClientVO;
import vo.VipVO;

/**
 * 管理客户信息的类
 * 在vo中保存了credit，因为界面上需要credit
 * po中没有保存credit，以防止credit被更改
 * @author Xue.W
 */
public class Client implements ClientService{
	
	private String clientID;
	private ClientPO clientPO;
	private ClientDao clientDao;
	private ClientTransform clientTrans;

	public Client(String clientID){
		this.clientID = clientID;
		this.initClientPO();
		this.clientDao = new ClientDao_Stub();
		this.clientTrans = ClientTransform.getInstance();
	}	
	
	//初始化成员变量clientpo
	private void initClientPO() {
		ClientPO po = clientDao.getClientInfo(this.clientID);
		if(po != null) {
			this.clientPO = po;
		}
	}
	
	
	/**
	 * 获得用户（会员）信息,包括信用值
	 * @param clientID 传入的用户ID信息
	 * @return 返回用户信息
	 * @author Xue.W
	 */
	public ClientVO getClientInfo (String clientID){
		if(clientPO != null) {
			return this.clientTrans.clientTransToVO(clientPO);
		} else {
			return null;
		}
		
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
				clientVO.identityID, clientVO.headImagePath, clientPO.getVipType(), 
				clientPO.getVipLevel(), clientPO.getVipInfo());
		
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
		
		if(!isVIP(vipVO.userID) && vipVO.userID.equals(this.clientID)) {
			
			if(clientDao.updateClientInfo(clientPO)){
				//同时更新clientpo中的vip信息
				this.clientPO.setVipType(vipVO.type);
				this.clientPO.setVipLevel(vipVO.level);
				this.clientPO.setVipInfo(vipVO.info);
				return ResultMessage.SUCCESS;
			}
		}
		
		return ResultMessage.FAILURE;
	}
	
	/**
	 * 获得VIP信息
	 * @param userID
	 * @return
	 */
	public VipVO getVipInfo(String userID){
		if(userID == this.clientID) {
			return new VipVO(clientPO.getUserID(), clientPO.getVipType(), 
				clientPO.getVipLevel(), clientPO.getVipInfo());
		} else {
			ClientPO po = clientDao.getClientInfo(userID);
			return new VipVO(po.getUserID(), po.getVipType(), po.getVipLevel(), po.getVipInfo());
		}
	}
	
	/**
	 * 判断用户是否是vip
	 * @param userID
	 * @return
	 */
	public boolean isVIP(String userID) {
		if(this.clientPO != null && this.clientPO.getVipType() != 0) {
			return true;
		}
		return false;
	}
	
	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public ClientPO getClientPO() {
		return clientPO;
	}

	public void setClientPO(ClientPO clientPO) {
		this.clientPO = clientPO;
	}

}
