package vo;

import Message.CreditChangeType;

/**
 * @param userID 用户ID
 * @param time 信用修改时间
 * @param orderID 订单ID
 * @param action 操作类型
 * @param cerditChange 信用变化值（包含正负号）
 * @author bcy
 *
 */
public class CreditChangeVO {
	
	public String userID;
	public String time;
	public String orderID;
	public CreditChangeType action;
	public int cerditChange;
	public int nowCredit;
	
	/**
	 *  提供logic层的CreditChangeVO构造方法
	 * @param userID
	 * @param time
	 * @param orderID
	 * @param action 
	 * @param cerditChange （包含正负号）
	 */
	public CreditChangeVO(String userID , String time , String orderID , 
			CreditChangeType action , int cerditChange ) {
		this.userID=userID;
		this.time=time;
		this.orderID=orderID;
		this.action=action;
		this.cerditChange=cerditChange;
	}
	
	/**
	 *  提供ui层的CreditChangeVO构造方法
	 * @param userID
	 * @param time
	 * @param orderID
	 * @param action 
	 * @param cerditChange （包含正负号）
	 */
	public CreditChangeVO(String userID , String time , 
			CreditChangeType action , int cerditChange ) {
		this.userID=userID;
		this.time=time;
		this.action=action;
		this.cerditChange=cerditChange;
	}
	
	
	/**
	 * 传回数据的VO构造方法
	 * @param userID
	 * @param time
	 * @param orderID
	 * @param action
	 * @param cerditChange
	 * @param nowCredit
	 */
	public CreditChangeVO(String userID , String time , String orderID , 
			CreditChangeType action , int cerditChange , int nowCredit ){
		this.userID=userID;
		this.time=time;
		this.orderID=orderID;
		this.action=action;
		this.cerditChange=cerditChange;
		this.nowCredit=nowCredit;
	}
	
}
