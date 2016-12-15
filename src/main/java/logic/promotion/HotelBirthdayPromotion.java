package logic.promotion;


import Message.VipType;
import logic.user.Client;
import logic.user.ClientVipInfo;
import logic.utility.DataFormat;
import logic.utility.Time;
import vo.OrderVO;
import vo.PromotionVO;
import vo.VipVO;

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
	private double discount;
	private ClientVipInfo clientVip;
	
	/**
	 * @param promotionID
	 * @param hotelID
	 * @param promotionName
	 * @param birthday
	 * @param discount
	 */
	public HotelBirthdayPromotion(String promotionID, String hotelID,
			String promotionName, double discount) {
		this.promotionID = promotionID;
		this.hotelID = hotelID;
		this.promotionName = promotionName;
		this.discount = discount;
		
		this.clientVip = new Client();
	}

	@Override
	public boolean judgePromotion(OrderVO vo) {
		
		if(vo.hotelID == this.hotelID) {
			if(this.clientVip.isVIP(vo.userID)) {
				
				VipVO v = this.clientVip.getVipInfo(vo.userID);
				
				if(v.vipType == VipType.BIRTHDAY_VIP) {
					if(new Time(v.info).sameDay((new Time(Time.getCurrentTime())))) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	@Override
	public OrderVO calculate(OrderVO vo) {
	
		if(this.discount != 0) {
			double temp = vo.beforePrice * this.discount;
			
			if(temp < vo.afterPrice) {
				vo.afterPrice = DataFormat.getInstance().formatDouble(temp);
				vo.promotion = this.changeToVO();
			}
		}
		
		return vo;
	}
	
	@Override
	public PromotionVO changeToVO() {
		return new PromotionVO(this.promotionID, this.hotelID, this.promotionName, this.discount);
	}

	public String getPromotionID() {
		return promotionID;
	}

	public String getPromotionName() {
		return promotionName;
	}

}
