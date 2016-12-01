package vo;

import Message.RoomType;

/**
 * @param hotelId
 * @param roomId
 * @param roomType
 * @param price 小数点保留两位
 * @param state 
 */
public class RoomVO {

	public String hotelId;
	public String roomId;
	public RoomType roomType; 
	public double price;
	public int state;
	
	public RoomVO(String hotelId, String roomId, RoomType roomType, double price, int state) {
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.roomType = roomType;
		this.price = price;
		this.state = state;
	}
	
	
}
