package vo;

/**
 * 搜索酒店的VO类
 * @param city 酒店地址
 * @param tradingArea 酒店所属商圈
 * @param hotelName 酒店名称
 * @param roomType 房间类型
 * @param priceLow 酒店价格最低值
 * @param priceHigh 酒店价格最高值
 * @param commentLow 酒店评分最低值
 * @param commentHigh 酒店评分最低值
 * @param starLow 酒店星期最低值
 * @param starHigh 酒店星期最低值
 * @author Mark.W
 */
public class HotelSearchVO {
	
	public String city;
	public String tradingArea;
	public String hotelName;
	public int roomType;
	public int priceLow;
	public int priceHigh;
	public double commentLow;
	public double commentHigh;
	public int starLow;
	public int starHigh;
	
	public HotelSearchVO(String city, String tradingArea, String hotelName, int roomType, int priceLow, int priceHigh,
			double commentLow, double commentHigh, int starLow, int starHigh) {
		this.city = city;
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