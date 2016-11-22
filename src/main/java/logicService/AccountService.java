package logicService;

import Message.Identity;
import Message.ResultMessage;
import vo.AccountVO;

/**
 * Account的logicservice
 * @author XueWang
 *
 */

public interface AccountService {
	
	public ResultMessage register(AccountVO accountVO);
	
	public ResultMessage login(AccountVO accountVO) ;
	
	public ResultMessage logout(AccountVO accountVO);
	
	public ResultMessage modifyPassword(AccountVO accountVO);
	
	public Identity getIdentity (AccountVO accountVO);
	
}
