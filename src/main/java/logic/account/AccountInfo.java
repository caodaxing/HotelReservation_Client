package logic.account;

import Message.Identity;


/**
 * 为user提供的获取用户类型的接口
 * @author Mark.W
 *
 */
public interface AccountInfo {

	public Identity getIdentity (String userID);
}
