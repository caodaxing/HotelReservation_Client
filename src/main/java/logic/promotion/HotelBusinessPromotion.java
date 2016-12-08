package logic.promotion;

import vo.OrderVO;
import vo.PromotionVO;

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
