package logic.credit;

import java.util.ArrayList;

import message.SortCondition;
import vo.CreditVO;

/**
 * 历史信用记录类
 * @author Xue.W
 */
public class CreditHistoryList {
	
	/**
	 * 获得用户历史信用记录
	 * @param user_ID 传入的用户ID信息
	 * @return 返回用户历史信用记录列表
	 * @author Xue.W
	 */
	public ArrayList<CreditVO> getHistoryList(String user_ID){
		return null;
	}
	
	/**
	 * 对历史信用记录进行排序
	 * @param creditList 传入的未排序历史信用记录列表
	 * @param condition 传入的排序条件
	 * @return 返回排序后的历史信用记录
	 * @author Xue.W
	 */
	public ArrayList<CreditVO> sort(ArrayList<CreditVO> creditList , SortCondition condition ){
		return null;
	}
	
}
