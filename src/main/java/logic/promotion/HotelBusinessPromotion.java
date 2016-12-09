package logic.promotion;

import java.text.DecimalFormat;
import java.util.ArrayList;

import Message.VipType;
import logic.mockObject.MockGetClientVipInfo;
import logic.user.GetClientVipInfo;
import logic.utility.DataFormat;
import vo.OrderVO;
import vo.PromotionVO;
import vo.VipVO;

/**
 * 酒店的合作企业优惠  PromotionType.HOTEL_COOPREATE_BUSINESS
 * @param promotionID
 * @param hotelID
 * @param promotionName
 * @param discount
 * @param cooperateBusiness
 */
public class HotelBusinessPromotion implements Promotion {

	private String promotionID;
	private String hotelID;
	private String promotionName;
	private double discount;
	private String cooperateBusiness;
	private GetClientVipInfo clientVip;
	
	/**
	 * @param promotionID
	 * @param hotelID
	 * @param promotionName
	 * @param discount
	 * @param cooperateBusiness
	 */
	public HotelBusinessPromotion(String promotionID, String hotelID, String promotionName, double discount,
			String cooperateBusiness) {
		this.promotionID = promotionID;
		this.hotelID = hotelID;
		this.promotionName = promotionName;
		this.discount = discount;
		this.cooperateBusiness = cooperateBusiness;
		this.clientVip = new MockGetClientVipInfo();
	}

	@Override
	public boolean judgePromotion(OrderVO vo) {
		if(vo.hotelID == this.hotelID) {
			if(this.clientVip.isVIP(vo.userID)) {
				VipVO v = this.clientVip.getVipInfo(vo.userID);
				
				if(v.vipType == VipType.BUSINESS_VIP) {
					if(v.info == this.cooperateBusiness) {
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
		return new PromotionVO(this.promotionID, this.hotelID, this.promotionName, this.discount, this.cooperateBusiness);
	}
	
	public String getPromotionID() {
		return promotionID;
	}

	public String getPromotionName() {
		return promotionName;
	}

}
