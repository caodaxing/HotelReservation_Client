package logic.promotion;

import java.text.DecimalFormat;
import java.util.ArrayList;

import Message.VipType;
import logic.mockObject.MockGetClientVipInfo;
import logic.user.GetClientVipInfo;
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
	private GetClientVipInfo clientVip;
	
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
		this.clientVip = new MockGetClientVipInfo();
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
		
		vo.afterPrice = DataFormat.getInstance().formatDouble(vo.beforePrice * this.discount);
		
		if(vo.promotions == null) {
			vo.promotions = new ArrayList<PromotionVO>();
		}
		vo.promotions.add(this.changeToVO());
		
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
