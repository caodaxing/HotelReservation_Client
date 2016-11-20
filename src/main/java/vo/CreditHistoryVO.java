package vo;

import Message.CreditChange;

public class CreditHistoryVO {
	public String userID;
	public String orderID;
	public CreditChange creditChange;
	public int creditNum;
	
	public CreditHistoryVO(String userID, String orderID, CreditChange creditChange, int creditNum) {
		super();
		this.userID = userID;
		this.orderID = orderID;
		this.creditChange = creditChange;
		this.creditNum = creditNum;
	}
}
