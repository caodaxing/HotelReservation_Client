package logicService.stub;

import java.util.HashMap;

import logicService.promotion.PromotionService;
import vo.HotelPromotionVO;

public class PromotionService_Stub implements PromotionService {

	public HashMap<String, String> hotelSetPromotion(String promotionid, String hotelPromotion) {
		return null;
	}

	public String hotelGetPromotion(String promtionid) {
		return null;
	}

	public HashMap<String, String> hotelAddPromotion(String promtionid, String content) {
		return null;
	}

	public HashMap<String, String> hotelDeletePromotion(String promtionid) {
		return null;
	}

	public HashMap<String, String> hotelUpdatePromotion(String promtionid, String content) {
		return null;
	}

	public HashMap<String, String> webSetPromotion(String promotionid, String webPromotion) {
		return null;
	}

	public String webGetPromotion(String promotionid) {
		return null;
	}

	public HashMap<String, String> webAddPromotion(String promtionid, String content) {
		return null;
	}

	public HashMap<String, String> webDeletePromotion(String promtionid) {
		return null;
	}

	public HashMap<String, String> webUpdatePromotion(String promtionid, String content) {
		return null;
	}

	@Override
	public HotelPromotionVO getPromotionInfo(String promotionID) {
		return null;
	}
	
}
