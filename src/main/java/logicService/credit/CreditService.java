package logicService.credit;

import Message.ResultMessage;

/**
 * 用户信用信息及VIP升级所需信用的管理
 * @author Xue.W
 */
public interface CreditService {
	
	/**
	 * 获得信用值， 
	 * @param user_ID 传入的用户ID信息
	 * @return 返回用户信用
	 * @author Xue.W
	 */
	public int getCredit(String userID);
	
	/**
	 * 设置VIP每升一级所需的信用
	 * @param credit_num 传入的升级VIP信用值
	 * @return 返回是否成功
	 * @author Xue.W
	 */
	public ResultMessage setVIPCredit(int level, int credit_num);
	
	/**
	 * 获得VIP每升一级所需的信用
	 * @return 返回用户信用
	 * @author Xue.W
	 */
	public int getVIPCredit(int level);
	
}
