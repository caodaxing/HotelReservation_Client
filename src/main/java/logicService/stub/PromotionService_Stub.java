package logicService.stub;

import java.util.ArrayList;

import Message.PromotionType;
import Message.ResultMessage;
import logicService.promotion.PromotionService;
import vo.PromotionVO;

public class PromotionService_Stub implements PromotionService {

	@Override
	public ArrayList<PromotionVO> getPromotions(PromotionType promotionTypes) {
		return null;
	}

	@Override
	public ResultMessage addPromotion(PromotionVO promotionVO) {
		return null;
	}

	@Override
	public PromotionVO getPromotion(String promotionID) {
		return null;
	}

	
}
