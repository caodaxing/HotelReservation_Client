package logic.account;

public class MockAccount {
	String user_id;
	String password;
	String identity;
	public MockAccount(String user_id,String password,String identity) {
		this.user_id=user_id;
		this.password=password;
		this.identity=identity;
	}
	
	public String getIdentity(String user_id) {
		return identity;
	}
	
}
