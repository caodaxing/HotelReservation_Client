package logic.mockObject;

import logic.promotion.PromotionCalculation;
import vo.OrderVO;

public class MockCalculatePromotion implements PromotionCalculation {

	@Override
	public OrderVO calculate(OrderVO order) {
		return null;
	}

}
