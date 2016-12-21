package logic.room;


import Message.RoomType;

/**
 * 为hotel提供的接口
 * @author Mark.W
 *
 */
public interface RoomInfo {
	
	/**
	 * 搜索酒店时获取每个酒店的最低价
	 * @param hotelID
	 * @return
	 */
	public double getHotelLowestPrice(String hotelID);
	
	/**
	 * 搜索酒店，获取指定时间指定房间类型剩余的数量
	 * @param hotelId
	 * @param roomType
	 * @param t 时间
	 * @return 数量
	 */
	public int getSpcificTimeRemainingRoomNums(String hotelId, RoomType roomType, String t);
	
	/**
	 * 获取指定房间类型的价格
	 * @param hotelID
	 * @param roomType
	 * @return
	 */
	public double getRoomPrice(String hotelID, RoomType roomType);
	
}
