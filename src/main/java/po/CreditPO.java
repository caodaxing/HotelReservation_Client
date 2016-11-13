package po;

import java.util.ArrayList;

public class CreditPO {
	
	String accountOfUser;
	int nowCredit;
	ArrayList<String> recordOfModify;
	
	/**
	 * 信用的PO类
	 * @param accountOfUser 用户账户
	 * @param nowCredit 当前信用
	 * @param recordOfModify 信用修改记录
	 * @author Rukawa
	 */
	public CreditPO(String accountOfUser,int nowCredit,ArrayList<String> recordOfModify) {
		super();
		this.accountOfUser=accountOfUser;
		this.nowCredit=nowCredit;
		this.recordOfModify=recordOfModify;
	}
	
}
