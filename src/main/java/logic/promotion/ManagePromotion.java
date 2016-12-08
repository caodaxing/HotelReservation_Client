package logic.promotion;

import java.util.ArrayList;

import Message.PromotionType;
import Message.ResultMessage;
import dataDao.promotion.PromotionDao;
import dataDao.stub.PromotionDao_Stub;
import logicService.promotion.PromotionService;
import vo.PromotionVO;

public class ManagePromotion implements PromotionService{
	private PromotionDao promotionDao;
	
	public ManagePromotion() {
		this.promotionDao = new PromotionDao_Stub();
	}

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
