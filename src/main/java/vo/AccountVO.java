package vo;

import Message.Identity;

/**
 * 账户的VO类
 * @param accountId 用户Id
 * @param password 密码
 * @param confirmedPassword 确认的密码
 * @param identity 用户身份
 * @author Rukawa
 */
public class AccountVO {

	public String accountId;
	public String password;
	public String confirmedPassword;
	public Identity identity;
	
	public AccountVO(String user_id, String password,Identity identity) {
		this.accountId=user_id;
		this.password=password;
		this.identity=identity;
	}
	
	public AccountVO(String user_id, String password, String newPassword, Identity identity) {
		this(user_id, password, identity);
		this.confirmedPassword = newPassword;
	}
}
