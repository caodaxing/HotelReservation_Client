package logic.account;

import Message.Identity;

public class MockAccount extends Account{
	String user_id;
	String password;
	Identity identity;
	public MockAccount(String user_id,String password,Identity identity) {
		this.user_id=user_id;
		this.password=password;
		this.identity=identity;
	}
	
	public Identity getIdentity(String user_id) {
		return identity;
	}
	
}
