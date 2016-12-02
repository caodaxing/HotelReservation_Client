package vo.promotion;

import Message.PromotionType;

/**
 * @param promotionID
 * @param hotelID
 * @param promotionType
 * @param promotionName
 * @param discount
 * @param cooperateBusiness
 * @param startTime
 * @param endTime
 */
public class HotelPromotionVO extends PromotionVO{

	public String hotelID;
	public String cooperateBusiness;
	public String startTime;
	public String endTime;

	public HotelPromotionVO(String promotionID, String hotelID, PromotionType promotionType, 
			String promotionName,
			double discount, String startTime, String endTime) {
		super(promotionID, promotionType, promotionName,discount);
		this.hotelID = hotelID;
		this.cooperateBusiness = null;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public HotelPromotionVO(String promotionID, String hotelID, PromotionType promotionType, 
			String promotionName,
			double discount, String cooperateBusiness, String startTime, String endTime) {
		this(promotionID, hotelID, promotionType,promotionName,discount,startTime,endTime);
		this.cooperateBusiness = cooperateBusiness;
	}
	
	
	

}
