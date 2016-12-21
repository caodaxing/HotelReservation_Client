package logic.account;

import java.rmi.RemoteException;

import Message.CreditChangeType;
import Message.Identity;
import Message.ResultMessage;
import dataDao.account.AccountDao;
import logic.credit.Credit;
import logic.credit.CreditChange;
import logic.credit.CreditChangeInfo;
import logic.user.AddClientInfo;
import logic.user.Client;
import logic.utility.Time;
import logicService.account.AccountService;
import main.rmi.RemoteHelper;
import po.AccountPO;
import po.ClientPO;
import vo.AccountVO;
import vo.CreditChangeVO;

/**
 * 提供帐号的注册、修改、登录、登出、获取身份功能。
 * @author bcy
 *
 */
public class Account implements AccountService{
	private AccountDao accountDao;
	private CreditChangeInfo creditChange;
	private AddClientInfo clientInfo;
		
	public Account(){
		this.creditChange = new CreditChange();
		this.clientInfo = new Client();
		
//		accountDao = new AccountDao_Stub();
		accountDao = RemoteHelper.getInstance().getAccountDao();
		
	}
	
	/**
	 * 注册账户
	 * @param accountVO 传入的VO信息
	 * @return ResultMessage 返回注册的结果（成功/失败）
	 * @author bcy
	 */
	public ResultMessage register(AccountVO accountVO){
		
		assert (accountVO == null) : "logic.account.register参数错误";
		
		if(accountVO.password != null && accountVO.userId != null 
				 && accountVO.identity != null) {
			
			try {
				if(!this.accountDao.userIDExists(accountVO.userId)) {
					
					AccountPO po = transToPO(accountVO);
					if(accountDao.addAccount(po)) {
						if(accountVO.identity == Identity.CLIENT) {
							
							//客户注册初始化信用值和clientpo
							if(this.initCredit(po.getAccountID())) {
								ClientPO clientPO = new ClientPO(accountVO.userId, "", "", "", Identity.CLIENT.ordinal(), 0, "");
								if(ResultMessage.SUCCESS == this.clientInfo.addClient(clientPO)) {
									return ResultMessage.SUCCESS;
								}
								
							}
						} else {
							return ResultMessage.SUCCESS;
						}
						
					}
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
		}
		
		return ResultMessage.FAILURE;	
	}
	
	private boolean initCredit(String accountID) {
		CreditChangeVO vo = new CreditChangeVO(accountID, Time.getCurrentTime(), null, CreditChangeType.INIT_CREDIT, 0, Credit.INIT_CREDIT_NUM);
		if(this.creditChange.changeCredit(vo) == ResultMessage.SUCCESS) {
			return true;
		}
		
		return false;
	}

	/**
	 * 登录
	 * @param accountVO 传入的VO信息
	 * @return RusultMessage 返回登录的结果（成功/失败）
	 * @author bcy
	 */
	public ResultMessage login(AccountVO accountVO) {
		
		if(accountVO.identity == null) {
			return ResultMessage.USERNAME_NOT_EXIST;
		}
		
		if(accountVO == null || accountVO.userId == null || accountVO.password == null) {
			
			return ResultMessage.FAILURE;
		}
		
		try {
			if(this.accountDao.hasLogin(accountVO.userId)) {
				return ResultMessage.USER_HAS_LOGIN;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		AccountPO po = null;
		try {
			po = accountDao.getAccountInfo(accountVO.userId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(po == null) {
			return ResultMessage.USERNAME_NOT_EXIST;
		}
		
		if(!po.getPassword().equals(accountVO.password)) {
			return ResultMessage.UNMATCHED_PASSWORD;
		} else {
			
			try {
				if(this.accountDao.setLogin(accountVO.userId)) {
					return ResultMessage.SUCCESS;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
		return ResultMessage.FAILURE;
	}
	
	
	/**
	 * 登出
	 * @param accountVO 传入的VO信息
	 * @return RusultMessage 返回登出的结果（成功/失败）
	 * @author bcy
	 */ 
	public ResultMessage logout(String userID) {
		try {
			if(this.accountDao.setLogout(userID)) {
				return ResultMessage.SUCCESS;
			}
		} catch (RemoteException e) { 
			e.printStackTrace();
		}
		
		return ResultMessage.FAILURE;
	}
	
	/**
	 * 修改账户密码信息
	 * @param accountVO 传入的VO信息
	 * @return RusultMessage 返回修改的结果（成功/失败）
	 * @author bcy
	 */
	public ResultMessage modifyPassword(AccountVO accountVO){
		assert (accountVO == null || accountVO.userId == null || 
				accountVO.identity == null || accountVO.password == null) : "logic.account.modifyPassword参数错误";
		
		try {
			if(accountDao.modifyPassword(transToPO(accountVO))) {
				return ResultMessage.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		
		return ResultMessage.FAILURE;
	}

	
	public Identity getIdentity(String accountID){
		AccountPO po = null;
		try {
			po = this.accountDao.getAccountInfo(accountID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(po != null && po.getIdentity() <4) {
			return Identity.values()[po.getIdentity()];
		}
		
		return null;
	}
	
	@Override
	public boolean userIDExists(String userID) {
	
		try {
			if(this.accountDao.userIDExists(userID)){
				return true;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public ResultMessage canModifyPassword(AccountVO vo) {
		if(vo == null || vo.userId == null || vo.userId == "") {
			return ResultMessage.FAILURE;
		}
		
		AccountPO po = null;
		try {
			po = this.accountDao.getAccountInfo(vo.userId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(po != null) {
			if(po.getPassword().equals(vo.password)) {
				return ResultMessage.SUCCESS;
			}
		}
		
		return ResultMessage.FAILURE;
	}
	
	private AccountPO transToPO(AccountVO accountVO) {
		return new AccountPO(accountVO.userId, accountVO.password, accountVO.identity.ordinal());
	}

}

