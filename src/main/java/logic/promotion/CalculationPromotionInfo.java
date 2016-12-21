package logic.promotion;

import vo.OrderVO;

/**
 * 给order提供的接口，在生成订单时计算优惠
 * @author Mark.W
 *
 */
public interface CalculationPromotionInfo {
	
	public OrderVO calculatePromotion(OrderVO order);
	
}
