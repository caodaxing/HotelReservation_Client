package logic.hotel;

import Message.RoomType;
import vo.HotelVO;

/**
 * 给order提供的获取酒店信息的接口
 * @author all
 *
 */
public interface HotelInfo {
	
	public HotelVO getHotelnfo(String hotelId);
	
	public int getRoomPrice(String hotelID, RoomType roomType);
}
