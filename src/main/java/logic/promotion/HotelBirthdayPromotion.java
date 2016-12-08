package logic.promotion;

import logic.utility.Time;
import vo.OrderVO;

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
	public double calculate() {
		return 0;
	}
}
