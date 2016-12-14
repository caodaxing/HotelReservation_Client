package logic.room;


import Message.RoomType;

/**
 * 为hotel提供的获取房间信息的接口
 * @author Mark.W
 *
 */
public interface RoomInfo {
	
	public double getHotelLowestPrice(String hotelID);
	
	public int getSpcificTimeRemainingRoomNums(String hotelId, RoomType roomType, String t);
	
	public double getRoomPrice(String hotelID, RoomType roomType);
	
}
