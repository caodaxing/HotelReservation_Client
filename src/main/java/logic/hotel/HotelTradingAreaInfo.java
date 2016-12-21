package logic.hotel;

/**
 * 给promotion用的接口
 * 网站不同商圈不同vip等级的优惠，需要获取酒店的所属商圈信息
 * @author Mark.W
 *
 */
public interface HotelTradingAreaInfo {
	
	public String getHotelTradingArea(String hotelID);
}
