package vo;

import Message.RoomType;

/**
 * 搜索酒店的VO类
 * @param city 酒店所在城市
 * @param tradingArea1 酒店所属商圈
 * @param hotelName 酒店名称(不填写则为null)
 * @param roomId 房间类型(默认标间)
 * @param startTime 计划入住的时间(默认为次日12时)
 * @param endTime 计划退房的时间(默认为次次日12时)
 * @param roomPriceLow 相应房间类型价格最低值 (默认值为-1)
 * @param roomPriceHigh 相应房间类型价格最高值(默认值为5000)
 * @param commentLow 酒店评分最低值(默认值为0)
 * @param commentHigh 酒店评分最高值(默认值为5)
 * @param starLow 酒店星期最低值(默认值为0)
 * @param starHigh 酒店星期最低值(默认值为5)
 * @param booked 预订过
 * @author Mark.W
 */
public class HotelSearchVO {
	
	public String city;
	public String tradingArea;
	public String hotelName;
	public RoomType roomType = RoomType.STANDARD_ROOM;
	public int roomNum;
	public String startTime;
	public String endTime;
	public double roomPriceLow = -1;
	public double roomPriceHigh = 5000;
	public double commentLow = 0;
	public double commentHigh = 5;
	public int starLow = 0;
	public int starHigh = 5;
	public boolean booked = false;
	public String userID;
	
	/**
	 * 游客搜索酒店的VO类构造方法
	 * @param city 酒店所在城市
	 * @param tradingArea 酒店所属商圈
	 * @param hotelName 酒店名称(不填写则为null)
	 * @param roomTy 房间类型(默认标间)
	 * @param startTime 计划入住的时间(默认为次日12时)
	 * @param endTime 计划退房的时间(默认为次次日12时)
	 * @param emptyRoomNum 相应房间类型的数量(默认为1)
	 * @param roomPriceLow 相应房间类型价格最低值 (默认值为-1)
	 * @param roomPriceHigh 相应房间类型价格最高值(默认值为5000)
	 * @param commentLow 酒店评分最低值(默认值为0)
	 * @param commentHigh 酒店评分最高值(默认值为5)
	 * @param starLow 酒店星期最低值(默认值为0)
	 * @param starHigh 酒店星期最低值(默认值为5)
	 */
	public HotelSearchVO(String city, String tradingArea, String hotelName, RoomType roomTy, int roomNu, String startTime,
			String endTime,double roomPriceLow, double roomPriceHigh, double commentLow,
			double commentHigh, int starLow, int starHigh) {
		this.city = city;
		this.tradingArea = tradingArea;
		this.hotelName = hotelName;
		
		if(roomTy == null) {
			this.roomType = RoomType.STANDARD_ROOM;
		} else {
			this.roomType = roomTy;
		}
		
		if(roomNu == 0) {
			this.roomNum = 1;
		} else {
			this.roomNum = roomNu;
		}
		
		this.startTime = startTime;
		this.endTime = endTime;
		this.roomPriceLow = roomPriceLow;
		this.roomPriceHigh = roomPriceHigh;
		this.commentLow = commentLow;
		this.commentHigh = commentHigh;
		this.starLow = starLow;
		this.starHigh = starHigh;
	}
	
	/**
	 * 客户搜索酒店的VO类构造方法
	 * @param city 酒店所在城市
	 * @param tradingArea 酒店所属商圈
	 * @param hotelName 酒店名称(不填写则为null)
	 * @param roomTy 房间类型(默认标间)
	 * @param startTime 计划入住的时间(默认为次日12时)
	 * @param endTime 计划退房的时间(默认为次次日12时)
	 * @param emptyRoomNum 相应房间类型的数量(默认为1)
	 * @param roomPriceLow 相应房间类型价格最低值 (默认值为-1)
	 * @param roomPriceHigh 相应房间类型价格最高值(默认值为5000)
	 * @param commentLow 酒店评分最低值(默认值为0)
	 * @param commentHigh 酒店评分最高值(默认值为5)
	 * @param starLow 酒店星期最低值(默认值为0)
	 * @param starHigh 酒店星期最低值(默认值为5)
	 * @param booked 是否预订过
	 * @param userID
	 */
	public HotelSearchVO(String city, String tradingArea, String hotelName, RoomType roomTy, int roomNu, String startTime,
			String endTime,double roomPriceLow, double roomPriceHigh, double commentLow,
			double commentHigh, int starLow, int starHigh, boolean booked, String userID) {
		this.city = city;
		this.tradingArea = tradingArea;
		this.hotelName = hotelName;
		
		if(roomTy == null) {
			this.roomType = RoomType.STANDARD_ROOM;
		} else {
			this.roomType = roomTy;
		}
		
		if(roomNu == 0) {
			this.roomNum = 1;
		} else {
			this.roomNum = roomNu;
		}
		
		this.startTime = startTime;
		this.endTime = endTime;
		this.roomPriceLow = roomPriceLow;
		this.roomPriceHigh = roomPriceHigh;
		this.commentLow = commentLow;
		this.commentHigh = commentHigh;
		this.starLow = starLow;
		this.starHigh = starHigh;
		this.booked = booked;
		
		this.booked = booked;
		this.userID = userID;
	}

	

}
