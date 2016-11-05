package vo;

public class UserInfoVO {
	String username;
	String typeOfVIP;
	String nowCredit;
	
	public UserInfoVO(String username,String typeOfVIP,String nowCredit){
		super();
		this.username = username;
		this.typeOfVIP = typeOfVIP;
		this.nowCredit = nowCredit;
	}
}
