package vo;

import Message.CreditChangeType;

/**
 * @param userID 用户ID
 * @param time 信用修改时间
 * @param orderID 订单ID
 * @param action 操作类型
 * @param cerditChange 信用变化值
 * @author bcy
 *
 */
public class CreditChangeVO {
	
	public String userID;
	public String time;
	public String orderID;
	public CreditChangeType action;
	public int cerditChange;
	
	public CreditChangeVO(String userID , String time , String orderID , 
			CreditChangeType action , int cerditChange ) {
		this.userID=userID;
		this.time=time;
		this.orderID=orderID;
		this.action=action;
		this.cerditChange=cerditChange;
	}
	
}
