package logic.evaluation;

import Message.ResultMessage;
import logic.order.EvaluationInfo;
import vo.EvaluationVO;

/**
 * 用户进行评价和获取评价
 * @author Rukawa
 *
 */
public class Evaluation implements EvaluationInfo{
	
	/**
	 * 获取酒店的评价信息
	 * @param orderId 订单Id
	 * @return 评价的VO类
	 * @author Rukawa
	 */
	public EvaluationVO getEvaluationInfo (String orderId){
		return null;
	}
	
	/**
	 * 返回评价后的状态
	 * @param orderId 订单Id
	 * @return enum类型
	 * @author Rukawa
	 */
	public ResultMessage evaluate (String orderId){
		return null;
	}
}
