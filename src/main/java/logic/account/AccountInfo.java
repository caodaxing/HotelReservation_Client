package logic.account;

import Message.Identity;
import vo.AccountVO;


/**
 * 为user提供的获取用户类型的接口
 * @author Mark.W
 *
 */
public interface AccountInfo {

	public Identity getIdentity (AccountVO accountVO);
}
