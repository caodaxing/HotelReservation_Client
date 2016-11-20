package logic.credit;

import java.util.ArrayList;

import Message.CreditChange;
import vo.CreditHistoryVO;

/**
 * 历史信用记录类
 * @author Xue.W
 */
public class CreditHistory {
	String userID;
	String orderID;
	CreditChange creditChange;
	int creditNum;
	
	
	/**
	 * 获得用户历史信用记录
	 * @param user_ID 传入的用户ID信息
	 * @return 返回用户历史信用记录列表
	 * @author Xue.W
	 */
	public ArrayList<CreditHistoryVO> getHistoryList(String user_ID){
		return null;
	}
	
}
