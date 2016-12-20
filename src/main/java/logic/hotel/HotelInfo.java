package logic.hotel;

import Message.RoomType;

/**
 * 给order提供的获取酒店信息的接口
 * @author all
 *
 */
public interface HotelInfo {
	
	public double getRoomPrice(String hotelID, RoomType roomType);
	
	public boolean updateHotelGrade(String hotelID, double grade);
}
