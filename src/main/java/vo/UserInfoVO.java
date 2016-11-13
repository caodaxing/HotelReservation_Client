package vo;

public class UserInfoVO {
	String username;
	String typeOfVIP;
	String nowCredit;
	
	/**
	 * 用户信息的VO类
	 * @param username 用户信息
	 * @param typeOfVIP VIP的类型
	 * @param nowCredit 当前信用值
	 * @author Rukawa
	 */
	public UserInfoVO(String username,String typeOfVIP,String nowCredit){
		super();
		this.username = username;
		this.typeOfVIP = typeOfVIP;
		this.nowCredit = nowCredit;
	}
}
