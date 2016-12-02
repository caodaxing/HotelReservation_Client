package vo.promotion;

import Message.PromotionType;

/**
 * HOTEL_COOPREATE_BUSINESS酒店合作企业特惠
 * @param promotionID
 * @param promotionType
 * @param promotionName
 * @param discount
 * @param cooperateBusiness
 */
public class BusinessPromotionVO extends PromotionVO{

	public String hotelID;
	public String cooperateBusiness;
	
	public BusinessPromotionVO(String promotionID, PromotionType promotionType,
			String promotionName, double discount, String cooperateBusiness) {
		super(promotionID, PromotionType.HOTEL_COOPREATE_BUSINESS, promotionName, discount);
		this.cooperateBusiness = cooperateBusiness;
	}

}
