package VO;

public class CreditVO {
	
	String accountOfUser;
	String nowCredit;
	int modifyCredit;
	
	public CreditVO(String nowCredit,int modifyCredit,String accountOfUser){
		
		super();
		this.nowCredit = nowCredit;
		this.modifyCredit = modifyCredit;
		this.accountOfUser = accountOfUser;
	}

}
