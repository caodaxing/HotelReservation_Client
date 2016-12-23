package logic.promotion;


import logic.utility.DataFormat;
import logic.utility.Time;
import vo.OrderVO;
import vo.PromotionVO;

/**
 * 酒店特定时间优惠 promotionType.HOTEL_11_1
 * @param promotionID
 * @param hotelID
 * @param promotionName
 * @param discount
 * @param startTime 
 * @param endTime
 */
public class HotelDoubleElevenPromotion  implements Promotion{

	private String promotionID;
	private String hotelID;
	private String promotionName;
	private double discount;
	private Time startTime;
	private Time endTime;
	
	
	/**
	 * @param promotionID
	 * @param hotelID
	 * @param promotionName
	 * @param discount
	 * @param startTime
	 * @param endTime
	 */
	public HotelDoubleElevenPromotion(String promotionID, String hotelID, String promotionName, 
			double discount, Time startTime, Time endTime) {
		this.promotionID = promotionID;
		this.hotelID = hotelID;
		this.promotionName = promotionName;
		this.discount = discount;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public boolean judgePromotion(OrderVO vo) {
		if(vo.hotelID == this.hotelID) {
			Time t = new Time(vo.startTime);
			if(this.startTime.before(t) && this.endTime.after(t)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public OrderVO calculate(OrderVO vo) {
		if(this.discount != 0) {
			double temp = vo.beforePrice * this.discount;
			
			if(temp < vo.afterPrice) {
				vo.afterPrice = DataFormat.formatDouble(temp);
				vo.promotion = this.changeToVO();
			}
		}
		
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
