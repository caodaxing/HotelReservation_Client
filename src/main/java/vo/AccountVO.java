package vo;

import Message.Identity;

public class AccountVO {

	String user_id;
	String password;
	Identity identity;
	
	public AccountVO(String user_id,String password,Identity identity) {
		super();
		this.user_id=user_id;
		this.password=password;
		this.identity=identity;
	}
}
