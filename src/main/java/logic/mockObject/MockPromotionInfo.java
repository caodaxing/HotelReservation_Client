package logic.mockObject;

import logic.promotion.PromotionInfo;
import vo.PromotionVO;

public class MockPromotionInfo implements PromotionInfo{

	@Override
	public PromotionVO getPromotion(String promotionID) {
		return new PromotionVO("ppp", "全网折扣", 0.8, "2016-09-09 12:00:00", "2016-12-12 12:00:00");
	}

}
