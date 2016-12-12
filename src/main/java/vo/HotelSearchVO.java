package vo;

import Message.RoomType;

/**
 * 搜索酒店的VO类
 * @param city 酒店所在城市
 * @param tradingArea 酒店所属商圈
 * @param hotelName 酒店名称(不填写则为null)
 * @param roomType 房间类型(默认标间)
 * @param roomPriceLow 相应房间类型价格最低值 (默认值为-1)
 * @param roomPriceHigh 相应房间类型价格最高值(默认值为5000)
 * @param commentLow 酒店评分最低值(默认值为0)
 * @param commentHigh 酒店评分最高值(默认值为5)
 * @param starLow 酒店星期最低值(默认值为0)
 * @param starHigh 酒店星期最低值(默认值为5)
 * @author Mark.W
 */
public class HotelSearchVO {
	
	public String city;
	public String tradingArea;
	public String hotelName;
	public RoomType roomType = RoomType.STANDARD_ROOM;
	public double roomPriceLow = -1;
	public double roomPriceHigh = 5000;
	public double commentLow = 0;
	public double commentHigh = 5;
	public int starLow = 0;
	public int starHigh = 5;
	
	/**
	 * 搜索酒店的VO类
	 * @param city 酒店所在城市
	 * @param tradingArea 酒店所属商圈
	 * @param hotelName 酒店名称(不填写则为null)
	 * @param roomType 房间类型(默认标间)
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
	public HotelSearchVO(String city, String tradingArea, String hotelName, RoomType roomType,double roomPriceLow, double roomPriceHigh, double commentLow,
			double commentHigh, int starLow, int starHigh) {
		this.city = city;
		this.tradingArea = tradingArea;
		this.hotelName = hotelName;
		this.roomType = roomType;
		this.roomPriceLow = roomPriceLow;
		this.roomPriceHigh = roomPriceHigh;
		this.commentLow = commentLow;
		this.commentHigh = commentHigh;
		this.starLow = starLow;
		this.starHigh = starHigh;
	}
}

///**
// * 搜索酒店的VO类
// * @param city 酒店所在城市
// * @param tradingArea 酒店所属商圈
// * @param hotelName 酒店名称(不填写则为null)
// * @param roomType 房间类型(默认标间)
// * @param startTime 计划入住的时间(默认为次日12时)
// * @param endTime 计划退房的时间(默认为次次日12时)
// * @param emptyRoomNum 相应房间类型的数量(默认为1)
// * @param roomPriceLow 相应房间类型价格最低值 (默认值为-1)
// * @param roomPriceHigh 相应房间类型价格最高值(默认值为5000)
// * @param commentLow 酒店评分最低值(默认值为0)
// * @param commentHigh 酒店评分最高值(默认值为5)
// * @param starLow 酒店星期最低值(默认值为0)
// * @param starHigh 酒店星期最低值(默认值为5)
// * @author Mark.W
// */
//public class HotelSearchVO {
//	
//	public String city;
//	public String tradingArea;
//	public String hotelName;
//	public RoomType roomType = RoomType.STANDARD_ROOM;
//	public String startTime;
//	public String endTime;
//	public int emptyRoomNum;
//	public double roomPriceLow = -1;
//	public double roomPriceHigh = 5000;
//	public double commentLow = 0;
//	public double commentHigh = 5;
//	public int starLow = 0;
//	public int starHigh = 5;
//	
//	/**
//	 * 搜索酒店的VO类
//	 * @param city 酒店所在城市
//	 * @param tradingArea 酒店所属商圈
//	 * @param hotelName 酒店名称(不填写则为null)
//	 * @param roomType 房间类型(默认标间)
//	 * @param startTime 计划入住的时间(默认为次日12时)
//	 * @param endTime 计划退房的时间(默认为次次日12时)
//	 * @param emptyRoomNum 相应房间类型的数量(默认为1)
//	 * @param roomPriceLow 相应房间类型价格最低值 (默认值为-1)
//	 * @param roomPriceHigh 相应房间类型价格最高值(默认值为5000)
//	 * @param commentLow 酒店评分最低值(默认值为0)
//	 * @param commentHigh 酒店评分最高值(默认值为5)
//	 * @param starLow 酒店星期最低值(默认值为0)
//	 * @param starHigh 酒店星期最低值(默认值为5)
//	 */
//	public HotelSearchVO(String city, String tradingArea, String hotelName, RoomType roomType, String startTime,
//			String endTime, int emptyRoomNum, double roomPriceLow, double roomPriceHigh, double commentLow,
//			double commentHigh, int starLow, int starHigh) {
//		this.city = city;
//		this.tradingArea = tradingArea;
//		this.hotelName = hotelName;
//		this.roomType = roomType;
//		this.startTime = startTime;
//		this.endTime = endTime;
//		this.emptyRoomNum = emptyRoomNum;
//		this.roomPriceLow = roomPriceLow;
//		this.roomPriceHigh = roomPriceHigh;
//		this.commentLow = commentLow;
//		this.commentHigh = commentHigh;
//		this.starLow = starLow;
//		this.starHigh = starHigh;
//	}
//}