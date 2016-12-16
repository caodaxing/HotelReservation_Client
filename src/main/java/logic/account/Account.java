package logic.account;

import java.rmi.RemoteException;

import Message.Identity;
import Message.ResultMessage;
import dataDao.account.AccountDao;
import dataDao.stub.AccountDao_Stub;
import logicService.account.AccountService;
import po.AccountPO;
import vo.AccountVO;

/**
 * 提供帐号的注册、修改、登录、登出、获取身份功能。
 * @author bcy
 *
 */
public class Account implements AccountService{
	private AccountDao accountDao;
		
	public Account(){
		accountDao = new AccountDao_Stub();
	}

	/**
	 * 注册账户
	 * @param accountVO 传入的VO信息
	 * @return ResultMessage 返回注册的结果（成功/失败）
	 * @author bcy
	 */
	public ResultMessage register(AccountVO accountVO){
		if(accountVO == null) 
			return ResultMessage.FAILURE;
		
		if(accountVO.password != null && accountVO.userId != null 
				&& accountVO.confirmedPassword != null && accountVO.identity != null) {
			
			if(accountVO.password != accountVO.confirmedPassword) {
				return ResultMessage.UNMATCHED_PASSWORD;
			} else {
				try {
					if(accountDao.addAccount(transToPO(accountVO))) {
						return ResultMessage.SUCCESS;
					}
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}	
		}
		
		return ResultMessage.FAILURE;	
	}
	
	/**
	 * 登录
	 * @param accountVO 传入的VO信息
	 * @return RusultMessage 返回登录的结果（成功/失败）
	 * @author bcy
	 */
	public ResultMessage login(AccountVO accountVO) {
		
		if(accountVO == null || accountVO.userId == null ||
				accountVO.identity == null || accountVO.password == null) {
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
		if(accountVO == null || accountVO.userId == null || accountVO.confirmedPassword == null ||
				accountVO.identity == null || accountVO.password == null) {
			return ResultMessage.FAILURE;
		}
		
		if(accountVO.password != accountVO.confirmedPassword) {
			return ResultMessage.UNMATCHED_PASSWORD;
		} 
			
		try {
			if(accountDao.modifyPassword(transToPO(accountVO))) {
				return ResultMessage.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		
		return ResultMessage.FAILURE;
	}
	
	//////用户名的分类，暂定
	public Identity getIdentity(String accountID){
		AccountPO po = null;
		try {
			po = this.accountDao.getAccountInfo(accountID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return Identity.values()[po.getIdentity()];
	}
	
	public AccountPO transToPO(AccountVO accountVO) {
		return new AccountPO(accountVO.userId, accountVO.password, accountVO.identity.ordinal());
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
	
	
}

