package logic.promotion;

import logic.utility.Time;
import vo.OrderVO;
import vo.PromotionVO;

/**
 * 酒店客户生日折扣 PromotionType.HOTEL_BIRTHDAY
 * @param promotionID
 * @param hotelID
 * @param promotionName
 * @param birthday
 * @param discount
 */
public class HotelBirthdayPromotion implements Promotion {
	private String promotionID;
	private String hotelID;
	private String promotionName;
	private Time birthday;
	private double discount;
	
	/**
	 * @param promotionID
	 * @param hotelID
	 * @param promotionName
	 * @param birthday
	 * @param discount
	 */
	public HotelBirthdayPromotion(String promotionID, String hotelID, String promotionName, Time birthday,
			double discount) {
		this.promotionID = promotionID;
		this.hotelID = hotelID;
		this.promotionName = promotionName;
		this.birthday = birthday;
		this.discount = discount;
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
