package vo;

import Message.Identity;

/**
 * 账户的VO类
 * @param userId 用户Id
 * @param password 密码
 * @param confirmedPassword 确认的密码
 * @param identity 用户身份
 * @author Rukawa
 */
public class AccountVO {

	public String userId;
	public String password;
	public Identity identity;
	
	public AccountVO(String user_id, String password,Identity identity) {
		this.userId=user_id;
		this.password=password;
		this.identity=identity;
	}
	
}