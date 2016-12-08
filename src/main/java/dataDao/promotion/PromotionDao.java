package dataDao.promotion;

import java.util.ArrayList;

import po.PromotionPO;

public interface PromotionDao {

	// promotionType 参数若为0，则表示要拿hotel的所有promotion
	public ArrayList<PromotionPO> getHotelPromotions(String hotel, int promotionType);
	
	public ArrayList<PromotionPO> getWebPromotions(int promotionType);
	
	public PromotionPO getPromotion(String promotionID);
	
	public boolean addPromotion(PromotionPO promotionPO);
	
	public boolean updatePromotion(PromotionPO promotionPO);
}
