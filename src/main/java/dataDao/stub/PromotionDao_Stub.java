package dataDao.stub;

import java.util.ArrayList;

import dataDao.promotion.PromotionDao;
import po.PromotionPO;

public class PromotionDao_Stub implements PromotionDao {


	public PromotionPO getPromotion(String promotionID) {
		return null;
	}

	public boolean addPromotion(PromotionPO promotionPO) {
		return false;
	}

	public boolean updatePromotion(PromotionPO promotionPO) {
		return false;
	}

	@Override
	public ArrayList<PromotionPO> getHotelPromotions(String hotel, int promotionType) {
		return null;
	}

	@Override
	public ArrayList<PromotionPO> getWebPromotions(int promotionType) {
		return null;
	}


}
