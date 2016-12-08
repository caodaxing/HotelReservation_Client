package logic.promotion;

import vo.OrderVO;

/**
 * 给order提供的接口，判断生成订单时能否优惠
 * @author Mark.W
 *
 */
public interface CalculationPromotionInfo {
	
	public OrderVO calculate(OrderVO order);
	
}