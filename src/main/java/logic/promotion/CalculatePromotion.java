package logic.promotion;

import Message.ResultMessage;
import logic.order.JudgePromotion;
import vo.OrderVO;
/**
 * 根据促销策略计算价格
 * @author Rukawa
 *
 */
public class CalculatePromotion implements JudgePromotion{
	
	
	
	/**
	 * 判断是否满足促销策略
	 * @param ordervo
	 * @return ResultMessage
	 * @author Rukawa
	 */
	public ResultMessage judge(OrderVO order){
		return null;
	}
	
	/**
	 * 计算订单折扣后的价格
	 * @param order 订单的VO类
	 * @return 折扣后订单价格
	 * @author Rukawa
	 */
	public double calculate(OrderVO order){
		return 0;
	}
	
}
