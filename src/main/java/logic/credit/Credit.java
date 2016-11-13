package logic.credit;

import Message.CreditChange;
import logic.order.CreditInfo;

/**
 * 用户信用信息及VIP升级所需信用的管理
 * @author Xue.W
 */
public class Credit implements CreditInfo{
	
	/**
	 * 获得信用值
	 * @param user_ID 传入的用户ID信息
	 * @return 返回用户信用
	 * @author Xue.W
	 */
	public int getCredit(String user_ID){
		return 0;
	}
	
	/**
	 * 改变信用值
	 * @param user_ID 传入的用户ID信息
	 * @param change 传入的信用改变类型
	 * @param number 传入的信用改变值
	 * @return 返回是否修改成功
	 * @author Xue.W
	 */
	public boolean changeCredit(String user_ID , CreditChange change , int number){
		return false;
	}
	
	/**
	 * 设置VIP每升一级所需的信用
	 * @param credit_num 传入的升级VIP信用值
	 * @return 返回是否成功
	 * @author Xue.W
	 */
	public boolean setVIPCredit(int credit_num){
		return false;
	}
	
	/**
	 * 获得VIP每升一级所需的信用
	 * @return 返回用户信用
	 * @author Xue.W
	 */
	public int getVIPCredit(){
		return 0;
	}
	
}
