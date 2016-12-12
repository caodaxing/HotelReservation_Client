package vo;

import java.util.ArrayList;
import java.util.HashMap;

import Message.RoomType;

/**
 * @param hotelId
 * @param roomId
 * @param roomType
 * @param price 小数点保留两位
 * @param notEmptyTime 保存房间不空闲的时间 key-value分别对应开始时间和结束时间，形式如“YYYY-MM-DD 12:00:00”
 * @param pictures
 */
public class RoomVO {

	public String hotelId;
	public String roomId;
	public RoomType roomType; 
	public double price;
	public HashMap<String, String> notEmptyTime;
	public ArrayList<String> pictures;
	
	/**
	 * 生成订单时构造房间的方法
	 * @param hotelId
	 * @param roomId
	 * @param roomType
	 * @param price 小数点保留两位
	 */
	public RoomVO(String hotelId, String roomId, RoomType roomType, double price) {
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.roomType = roomType;
		this.price = price;
	}
	
	
	/**
	 * 酒店管理人员管理房间的构造方法
	 * @param hotelId
	 * @param roomId
	 * @param roomType
	 * @param price 小数点保留两位
	 * @param notEmptyTime 保存房间不空闲的时间 key-value分别对应开始时间和结束时间，形式如“YYYY-MM-DD 12:00:00”
	 * @param pictures
	 */
	public RoomVO(String hotelId, String roomId, RoomType roomType, double price, HashMap<String, String> notEmptyTime,
			ArrayList<String> pictures) {
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.roomType = roomType;
		this.price = price;
		this.notEmptyTime = notEmptyTime;
		this.pictures = pictures;
	}
	
	
	
	
}
