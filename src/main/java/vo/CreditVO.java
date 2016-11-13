package vo;

public class CreditVO {
	
	String accountOfUser;
	String nowCredit;
	int modifyCredit;
	
	/**
	 * 信用的VO类
	 * @param nowCredit 当前信用
	 * @param modifyCredit 修改信用值
	 * @param accountOfUser 用户账户
	 * @author Rukawa
	 */
	public CreditVO(String nowCredit,int modifyCredit,String accountOfUser){
		
		super();
		this.nowCredit = nowCredit;
		this.modifyCredit = modifyCredit;
		this.accountOfUser = accountOfUser;
	}

}
