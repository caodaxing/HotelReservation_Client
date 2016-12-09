package logic.promotion;

import java.text.DecimalFormat;
import java.util.ArrayList;

import logic.utility.DataFormat;
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
	public boolean judgePromotion(OrderVO vo) {
		if(this.hotelID == vo.hotelID) {
			if(vo.rooms != null && vo.rooms.size() >= 3) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public OrderVO calculate(OrderVO vo) {
		
		double discount = 0;
		if(vo.rooms.size() <= this.roomsAndDiscount.length) {
			discount = this.roomsAndDiscount[vo.rooms.size()];
		} else {
			discount = this.roomsAndDiscount[this.roomsAndDiscount.length-1];
		}
		
		vo.afterPrice = DataFormat.getInstance().formatDouble(vo.beforePrice * discount);
		
		if(vo.promotions == null) {
			vo.promotions = new ArrayList<PromotionVO>();
		}
		vo.promotions.add(this.changeToVO());
		
		return vo;
	}
	
	@Override
	public PromotionVO changeToVO() {
		return new PromotionVO(this.promotionID, this.hotelID, this.promotionID, this.roomsAndDiscount);
	}

	public String getPromotionID() {
		return promotionID;
	}

	public String getPromotionName() {
		return promotionName;
	}

}
