package dataDao.promotion;

import java.util.ArrayList;

import po.PromotionPO;

public interface PromotionDao {

	public ArrayList<PromotionPO> getHotelPromotions(String hotel);
	
	public ArrayList<PromotionPO> getWebPromotions();
	
	public PromotionPO getPromotion(String promotionID);
	
	public boolean addPromotion(PromotionPO promotionPO);
	
	public boolean updatePromotion(PromotionPO promotionPO);
}
