package vo;

import Message.Identity;

public class AccountVO {

	public String user_id;
	public String password;
	public Identity identity;
	
	/**
	 * 账户的VO类
	 * @param user_id 用户Id
	 * @param password 密码
	 * @param identity 用户身份
	 * @author Rukawa
	 */
	public AccountVO(String user_id,String password,Identity identity) {
		super();
		this.user_id=user_id;
		this.password=password;
		this.identity=identity;
	}
}
