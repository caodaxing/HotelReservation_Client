package vo.promotion;

import Message.PromotionType;

/**
 * @param promotionID
 * @param promotionType
 * @param promotionName
 * @param discount
 */
public class PromotionVO {
	public String promotionID;
	public PromotionType promotionType;
	public String promotionName;
	public double discount;
	
	public PromotionVO(String promotionID, PromotionType promotionType, String promotionName, double discount) {
		this.promotionID = promotionID;
		this.promotionType = promotionType;
		this.promotionName = promotionName;
		this.discount = discount;
	}
	
	
}
