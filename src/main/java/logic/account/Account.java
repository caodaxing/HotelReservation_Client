package logic.account;

import Message.Identity;
import Message.ResultMessage;
import logicService.AccountService;
import vo.AccountVO;

/**
 * 提供帐号的注册、修改、登录、登出、获取身份功能。
 * @author bcy
 *
 */
public class Account implements AccountInfo, AccountService{
	String user_id;
	String password;
	Identity identity;
		
	public Account(){}

	/**
	 * 注册账户
	 * @param accountVO 传入的VO信息
	 * @return ResultMessage 返回注册的结果（成功/失败）
	 * @author bcy
	 */
	public ResultMessage register(AccountVO accountVO){
		return ResultMessage.SUCCESS;
	}
	
	
	/**
	 * 登录，并在调用时给成员变量赋值
	 * @param accountVO 传入的VO信息
	 * @return RusultMessage 返回登录的结果（成功/失败）
	 * @author bcy
	 */
	public ResultMessage login(AccountVO accountVO) {
		this.user_id = accountVO.user_id;
		this.password = accountVO.password;
		this.identity = accountVO.identity;
		return ResultMessage.SUCCESS;
		
	}
	
	
	/**
	 * 登出
	 * @param accountVO 传入的VO信息
	 * @return RusultMessage 返回登出的结果（成功/失败）
	 * @author bcy
	 */
	public ResultMessage logout(AccountVO accountVO){
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 修改账户信息
	 * @param accountVO 传入的VO信息
	 * @return RusultMessage 返回修改的结果（成功/失败）
	 * @author bcy
	 */
	public ResultMessage modify(AccountVO accountVO){
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 获取身份
	 * @param accountVO 传入的VO信息
	 * @return Identity 返回账户的身份
	 * @author bcy
	 */
	public Identity getIdentity(AccountVO accountVO){
		return Identity.ClIENT;
	}
}
