package logic.promotion;


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
			if(vo.roomNum >= 3) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public OrderVO calculate(OrderVO vo) {
		
		double discount = 0;
		//roomsAndDiscount下标0表示预定3间
		if(vo.roomNum -3 < this.roomsAndDiscount.length) {
			discount = this.roomsAndDiscount[vo.roomNum - 3];
		} else {
			discount = this.roomsAndDiscount[this.roomsAndDiscount.length-1];
		}
		
		
		if(discount != 0) {
			double temp = vo.beforePrice * discount;
			
			if(temp < vo.afterPrice) {
				vo.afterPrice = DataFormat.getInstance().formatDouble(temp);
				vo.promotion = this.changeToVO();
			}
		}
		
		
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
