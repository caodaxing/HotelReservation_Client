package dataDao.promotion;

import java.util.ArrayList;

import po.PromotionPO;

public interface PromotionDao {

	public ArrayList<PromotionPO> getHotelPromotions(String hotel);
	
	public PromotionPO getPromotion(String promotionID);
	
	public ArrayList<PromotionPO> getWebPromotions();
	
	public boolean addPromotion(PromotionPO promotionPO);
	
	public boolean updatePromotion(PromotionPO promotionPO);
	
	
}
