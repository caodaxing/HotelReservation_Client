package logic.promotion;

import vo.OrderVO;
import vo.PromotionVO;

/**
 * 酒店3间及以上预定特惠
 * @param promotionID
 * @param hotelID
 * @param promotionName
 * @param discount
 * @param roomsAndDiscount
 */
public class HotelThreeRoomsPromotion implements Promotion{

	private String promotionID;
	private String hotelID;
	private String promotionName;
	private double[] roomsAndDiscount;
	
	/**
	 * @param promotionID
	 * @param hotelID
	 * @param promotionName
	 * @param discount
	 * @param roomsAndDiscount
	 */
	public HotelThreeRoomsPromotion(String promotionID, String hotelID, 
			String promotionName, double[] roomsAndDiscount) {
		this.promotionID = promotionID;
		this.hotelID = hotelID;
		this.promotionName = promotionName;
		this.roomsAndDiscount = roomsAndDiscount;
	}

	@Override
	public boolean judgePromotion(OrderVO orderVO) {
		return false;
	}

	@Override
	public OrderVO calculate(OrderVO vo) {
		return null;
	}
	
	@Override
	public PromotionVO changeToVO() {
		return null;
	}
	
	public String getPromotionID() {
		return promotionID;
	}

	public String getPromotionName() {
		return promotionName;
	}

}
