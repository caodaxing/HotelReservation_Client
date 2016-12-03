package logic.promotion;

import java.util.ArrayList;

import vo.OrderVO;
/**
 * 根据促销策略计算价格
 * @author Rukawa
 *
 */
public class CalculatePromotion implements promotionCalculation{
	
	ArrayList<Promotion> promotions;
	
	
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
