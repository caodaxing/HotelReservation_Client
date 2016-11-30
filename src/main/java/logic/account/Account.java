package logic.account;

import Message.Identity;
import Message.ResultMessage;
import dataDao.AccountDao;
import dataDao.stub.AccountDao_Stub;
import logicService.AccountService;
import po.AccountPO;
import vo.AccountVO;

/**
 * 提供帐号的注册、修改、登录、登出、获取身份功能。
 * @author bcy
 *
 */
public class Account implements AccountInfo, AccountService{
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
				if(accountDao.addAccount(transToPO(accountVO))) {
					return ResultMessage.SUCCESS;
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
	
		AccountPO po = accountDao.getAccountInfo(accountVO.userId);
		
		if(po == null) {
			return ResultMessage.USERNAME_NOT_EXIST;
		}
		
		if(!po.getPassword().equals(accountVO.password)) {
			return ResultMessage.UNMATCHED_PASSWORD;
		} else {
			return ResultMessage.SUCCESS;
		}
		
	}
	
	
	/**
	 * 登出
	 * @param accountVO 传入的VO信息
	 * @return RusultMessage 返回登出的结果（成功/失败）
	 * @author bcy
	 */ 
	public ResultMessage logout(AccountVO accountVO) {	
		if(accountVO == null || accountVO.userId == null ||
				accountVO.identity == null || accountVO.password == null) {
			return ResultMessage.FAILURE;
		}
			
		return ResultMessage.SUCCESS;
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
			
		if(accountDao.modifyPassword(transToPO(accountVO))) {
			return ResultMessage.SUCCESS;
		} 
		
		return ResultMessage.FAILURE;
	}
	
	//////用户名的分类，暂定
	public Identity getIdentity(String accountID){
		return Identity.CLIENT;
	}
	
	public AccountPO transToPO(AccountVO accountVO) {
		return new AccountPO(accountVO.userId, accountVO.password, accountVO.identity.getIndex());
	}
	
}

