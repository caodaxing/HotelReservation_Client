package vo.promotion;

import java.util.HashMap;

import Message.PromotionType;

/**
 * 酒店预定三间及以上预定特惠
 * @param promotionID
 * @param promotionType
 * @param promotionName
 * @param discount
 * @param roomsAndDiscount
 */
public class ThreeRoomOrMorePromotion extends PromotionVO{

	public HashMap<Integer, Double> roomsAndDiscount;


	public ThreeRoomOrMorePromotion(String promotionID, String promotionName,
			double discount, HashMap<Integer, Double> roomsAndDiscount) {
		super(promotionID, PromotionType.HOTEL_3_ROOMS_OR_MORE, promotionName, discount);
		this.roomsAndDiscount = roomsAndDiscount;
	}
	
	
}
