package logicService.account;

import Message.Identity;
import Message.ResultMessage;
import vo.AccountVO;

/**
 * 有关登录和注册和修改密码的接口
 * @author Mark.W
 */
public interface AccountService {
	
	public ResultMessage register(AccountVO accountVO);
	
	public ResultMessage login(AccountVO accountVO) ;
	
	public ResultMessage logout(String userID);
	
	public ResultMessage modifyPassword(AccountVO accountVO);
	
	public Identity getIdentity (String accountID);
	
	public boolean userIDExists(String userID);
	
}
