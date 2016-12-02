package vo.promotion;

import Message.PromotionType;

/**
 * 特定时期预定特惠
 * @param promotionID
 * @param promotionType
 * @param promotionName
 * @param discount
 * @param hotelID
 * @param startTime
 * @param endTime
 */
public class SpecificTimePromotionVO extends PromotionVO{

	public String hotelID;
	public String startTime;
	public String endTime;
	
	//酒店特定时期酒店折扣
	public SpecificTimePromotionVO(String promotionID, String promotionName,
			double discount, String hotelID, String startTime, String endTime) {
		super(promotionID, PromotionType.HOTEL_11_11, promotionName, discount);
		this.hotelID = hotelID;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	//网站特定时期酒店折扣
	public SpecificTimePromotionVO(String promotionID, String promotionName,
			double discount, String startTime, String endTime) {
		super(promotionID, PromotionType.WEB_11_11, promotionName, discount);
		this.hotelID = null;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
	

}
