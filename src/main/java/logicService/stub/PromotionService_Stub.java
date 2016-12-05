package logicService.stub;

import java.util.ArrayList;

import Message.PromotionType;
import Message.ResultMessage;
import logicService.promotion.PromotionService;
import vo.PromotionVO;

public class PromotionService_Stub implements PromotionService {

	@Override
	public ResultMessage addPromotion(PromotionVO promotionVO) {
		return null;
	}

	@Override
	public PromotionVO getPromotion(String promotionID) {
		return null;
	}

	@Override
	public ArrayList<PromotionVO> getHotelPromotions(String hotelID, PromotionType promotionType) {
		return null;
	}

	@Override
	public ArrayList<PromotionVO> getWebPromotions(PromotionType promotionType) {
		return null;
	}

	
}
