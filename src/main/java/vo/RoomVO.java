package vo;

import java.util.ArrayList;

import Message.RoomType;

/**
 * @param hotelId
 * @param roomId
 * @param orderId
 * @param price 小数点保留两位
 * @param isEmpty
 * @param pictures
 */
public class RoomVO {

	public String hotelId;
	public String roomId;
	public RoomType roomType; 
	public double price;
	public boolean isEmpty;
	public ArrayList<String> pictures;
	
	public RoomVO(String hotelId, String roomId, RoomType roomType, double price, boolean isEmpty,
			ArrayList<String> pictures) {
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.roomType = roomType;
		this.price = price;
		this.isEmpty = isEmpty;
		this.pictures = pictures;
	}
	
	
	
	
}
