package logic.promotion;

import logic.utility.Time;
import vo.OrderVO;
import vo.PromotionVO;

/**
 * 网站特定时间优惠 PromotionType.WEB_11_11
 * @param promotionID
 * @param promotionName
 * @param discount
 * @param startTime
 * @param endTime
 */
public class WebDoubleElevenPromotion implements Promotion{


	private String promotionID;
	private String promotionName;
	private double discount;
	private Time startTime;
	private Time endTime;
	
	
	/**
	 * @param promotionID
	 * @param promotionName
	 * @param discount
	 * @param startTime
	 * @param endTime
	 */
	public WebDoubleElevenPromotion(String promotionID, String promotionName, 
			double discount, Time startTime, Time endTime) {
		this.promotionID = promotionID;
		this.promotionName = promotionName;
		this.discount = discount;
		this.startTime = startTime;
		this.endTime = endTime;
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
