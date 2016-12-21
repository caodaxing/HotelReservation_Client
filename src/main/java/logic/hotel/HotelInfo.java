package logic.hotel;

import Message.RoomType;

/**
 * 给order提供的获取酒店信息的接口
 * @author all
 */
public interface HotelInfo {
	
	/**
	 * 生成订单时拿到指定酒店和房间的价格
	 * @param hotelID 酒店id
	 * @param roomType 房间类型
	 * @return 价格
	 */
	public double getRoomPrice(String hotelID, RoomType roomType);
	
	/**
	 * 订单评价完成后，更新酒店的评分信息
	 * @param hotelID 酒店id
	 * @param grade 更新后的酒店评分
	 * @return 成功与否
	 */
	public boolean updateHotelGrade(String hotelID, double grade);
}
