package logic.user;


import java.rmi.RemoteException;

import Message.ResultMessage;
import Message.VipType;
import dataDao.picture.PictureDao;
import dataDao.stub.ClientDao_Stub;
import dataDao.user.ClientDao;
import logic.utility.ClientTransform;
import logicService.user.ClientService;
import main.rmi.PictureHelper;
import main.rmi.RemoteHelper;
import po.ClientPO;
import vo.ClientVO;
import vo.VipVO;

/**
 * 管理客户信息的类
 * 在vo中保存了credit，因为界面上需要credit
 * po中没有保存credit，以防止credit被更改
 * @author Xue.W
 */
public class Client implements ClientService, ClientVipInfo, UpdateClientVip{
	
	private ClientDao clientDao;

	public Client(){
		this.clientDao = new ClientDao_Stub();
	}	
	
	/**
	 * 获得用户（会员）信息,包括信用值
	 * @param clientID 传入的用户ID信息
	 * @return 返回用户信息
	 * @author Xue.W
	 */
	public ClientVO getClientInfo(String clientID){
		ClientPO po = null;
		
		try {
			po = this.clientDao.getClientInfo(clientID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ClientTransform.getInstance().clientTransToVO(po);
	}
	
	/**
	 * 修改用户信息,如果有头像更新就更新头像
	 * @param  clientInfo 传入的用户信息
	 * @return 返回是否修改成功
	 * @author Xue.W
	 */
	public ResultMessage updateClientInfo(ClientVO clientVO){
		
		if(clientVO == null) {
			return ResultMessage.FAILURE;
		}
		
		ClientPO po = null;
		try {
			po = this.clientDao.getClientInfo(clientVO.userID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		po.setPhoneNumber(clientVO.phoneNumber);
		po.setTrueName(clientVO.trueName);
		po.setIdentityID(clientVO.identityID);
		
		try {
			if(clientDao.updateClientInfo(po)){

				if(clientVO.headImagePath != null) {
					byte[] image = PictureHelper.imageToBytes(clientVO.headImagePath);
					PictureDao pictureDao = RemoteHelper.getInstance().getPictureDao();
					try {
						if(pictureDao.saveUserImage(image, clientVO.userID)) {
							return ResultMessage.SUCCESS;
						}
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				
			}
		} catch (RemoteException e) {
			e.printStackTrace();
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
		
		if(vipVO != null && !this.isVIP(vipVO.userID)) {
			
			ClientPO po = null;
			try {
				po = this.clientDao.getClientInfo(vipVO.userID);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			po.setVipType(vipVO.vipType.ordinal());
			po.setVipLevel(vipVO.level);
			po.setVipInfo(vipVO.info);
			
			try {
				if(clientDao.updateClientInfo(po)){
					return ResultMessage.SUCCESS;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
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
		if(this.isVIP(userID)) {
			
			ClientPO clientPO = null;
			try {
				clientPO = this.clientDao.getClientInfo(userID);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			if(clientPO != null) {
				return new VipVO(clientPO.getUserID(), VipType.values()[clientPO.getVipType()], 
						clientPO.getVipLevel(), clientPO.getVipInfo());
			}
		}
		
		return null;
	}
	
	/**
	 * 判断用户是否是vip
	 * @param userID
	 * @return
	 */
	public boolean isVIP(String userID) {
		ClientPO clientPO = null;
		try {
			clientPO = this.clientDao.getClientInfo(userID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	
		if(clientPO != null) {
			if(clientPO.getVipType() == 1 || clientPO.getVipType() == 2) {
				return true;
			}
		}
 		return false;
	}

	@Override
	public boolean updateClientVip(String userID, int level) {
		ClientPO clientPO = null;
		try {
			clientPO = this.clientDao.getClientInfo(userID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(level == clientPO.getVipLevel()) {
			return true;
		}
		
		clientPO.setVipLevel(level);
		try {
			if(this.clientDao.updateClientInfo(clientPO))  {
				return true;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
