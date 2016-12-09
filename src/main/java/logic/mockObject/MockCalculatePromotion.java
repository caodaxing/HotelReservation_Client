package logic.mockObject;

import java.util.ArrayList;

import logic.promotion.CalculationPromotionInfo;
import vo.OrderVO;
import vo.PromotionVO;

public class MockCalculatePromotion implements CalculationPromotionInfo {

	@Override
	public OrderVO calculatePromotion(OrderVO order) {
		
		ArrayList<PromotionVO> pros = new ArrayList<PromotionVO>();
		pros.add(new PromotionVO("ppp", "全网折扣", 0.8, "2016-12-09 12:00:00", "2016-12-31 12:00:00"));
		
		order.promotions = pros;
		order.afterPrice = 0.8 * order.beforePrice;
		
		return order;
	}

}
