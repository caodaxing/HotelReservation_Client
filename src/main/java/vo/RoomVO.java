package vo;


import Message.RoomType;

/**
 * @param hotelId
 * @param roomId
 * @param roomNum
 * @param price
 */
public class RoomVO {

	public String hotelId;
	public RoomType roomType; 
	public int roomNum;
	public double price;
	
	/**
	 * @param hotelId
	 * @param roomType
	 * @param roomNum
	 * @param price
	 * @param specificTimeRoomNum
	 */
	public RoomVO(String hotelId, RoomType roomType, int roomNum, double price) {
		this.hotelId = hotelId;
		this.roomType = roomType;
		this.roomNum = roomNum;
		this.price = price;
	}
	

	
}
