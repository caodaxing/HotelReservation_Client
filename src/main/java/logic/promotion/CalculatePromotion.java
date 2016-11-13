package logic.promotion;

import java.util.HashMap;

import logicService.order.Order;
import vo.OrderVO;
/**
 * 根据促销策略计算价格
 * @author Rukawa
 *
 */
public class CalculatePromotion implements JudgePromotion{
	
	/**
	 * 判断是否满足促销策略
	 * @param webPromotion 网站营销策略
	 * @param promotionid 策略名称
	 * @return 满足的促销策略
	 * @author Rukawa
	 */
	public HashMap<String,String> judge(String webPromotion, String promotionid){
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
