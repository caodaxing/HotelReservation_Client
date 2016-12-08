package vo;

import Message.RoomType;

/**
 * 搜索酒店的VO类
 * @param city 酒店所在城市
 * @param distract 酒店所在行政区
 * @param tradingArea 酒店所属商圈
 * @param hotelName 酒店名称
 * @param roomType 房间类型
 * @param priceLow 酒店价格最低值 (默认值为-1)
 * @param priceHigh 酒店价格最高值(默认值为5000)
 * @param commentLow 酒店评分最低值(默认值为0)
 * @param commentHigh 酒店评分最高值(默认值为5)
 * @param starLow 酒店星期最低值(默认值为0)
 * @param starHigh 酒店星期最低值(默认值为5)
 * @author Mark.W
 */
public class HotelSearchVO {
	
	public String city;
	public String distract;
	public String tradingArea;
	public String hotelName;
	public RoomType roomType;
	public double priceLow;
	public double priceHigh;
	public double commentLow;
	public double commentHigh;
	public int starLow;
	public int starHigh;
	
	public HotelSearchVO(String city, String distract,String tradingArea, String hotelName, RoomType roomType, double priceLow, double priceHigh,
			double commentLow, double commentHigh, int starLow, int starHigh) {
		this.city = city;
		this.distract = distract;
		this.tradingArea = tradingArea;
		this.hotelName = hotelName;
		this.roomType = roomType;
		this.priceLow = priceLow;
		this.priceHigh = priceHigh;
		this.commentLow = commentLow;
		this.commentHigh = commentHigh;
		this.starLow = starLow;
		this.starHigh = starHigh;
	}
	
}