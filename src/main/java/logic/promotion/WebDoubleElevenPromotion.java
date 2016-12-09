package logic.promotion;

import java.util.ArrayList;

import logic.utility.DataFormat;
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
	public boolean judgePromotion(OrderVO vo) {
		Time t = new Time(vo.startTime);
		if(this.startTime.before(t) && this.endTime.after(t)) {
			return true;
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
		return new PromotionVO(this.promotionID, this.promotionName, this.discount, 
				this.startTime.toString(), this.endTime.toString());
	}
	
	public String getPromotionID() {
		return promotionID;
	}

	public String getPromotionName() {
		return promotionName;
	}

}
