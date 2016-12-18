package po;

import java.io.Serializable;

/**
 * @param userID 用户ID
 * @param time 信用修改时间
 * @param orderID 订单ID
 * @param action 操作  0:正常执行订单增加 1:异常订单扣除 2.撤销订单扣除 3.充值 4.初始化
 * @param cerditChange 信用变化值
 * @param nowCredit 当前信用
 * @author bcy
 *
 */
public class CreditHistoryPO implements Serializable{
	
	private String userID;
	private String time;
	private String orderID;
	private int action;
	private int creditChange;
	private int nowCredit;
	
	/**
	 * @param userID
	 * @param time
	 * @param orderID
	 * @param action
	 * @param creditChange
	 * @param nowCredit
	 */
	public CreditHistoryPO(String userID, String time, String orderID, int action, int creditChange, int nowCredit) {
		this.userID = userID;
		this.time = time;
		this.orderID = orderID;
		this.action = action;
		this.creditChange = creditChange;
		this.nowCredit = nowCredit;
	}
	
	
	
}
