package logic.mockObject;

import logic.promotion.PromotionInfo;
import vo.PromotionVO;

public class MockPromotionInfo implements PromotionInfo{

	@Override
	public PromotionVO getPromotion(String promotionID) {
		return null;
	}

}
