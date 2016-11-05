package po;

import java.util.ArrayList;

public class CreditPO {
	String accountOfUser;
	int nowCredit;
	ArrayList<String> recordOfModify;
	
	public CreditPO(String accountOfUser,int nowCredit,ArrayList<String> recordOfModify) {
		super();
		this.accountOfUser=accountOfUser;
		this.nowCredit=nowCredit;
		this.recordOfModify=recordOfModify;
	}
	
}
