package vo;

/**
 * 搜索酒店的VO类
 * @author Rukawa
 *
 */
public class HotelSearchVO {
	
	public String city;
	public String tradingArea;
	public String hotelName;
	public int roomType;
	public String starLevel;
	public String gradeInterval;
	
	/**
	 * 搜索酒店的VO类
	 * @param city 酒店地址
	 * @param tradingArea 酒店所属商圈
	 * @param hotelName 酒店名称
	 * @param room RoomVO类
	 * @param starLevel 酒店星级
	 * @param gradeInterval 酒店价格区间
	 * @author Rukawa
	 */
	public HotelSearchVO(String city,String tradingArea,String hotelName, int roomType,
			String starLevel,String gradeInterval){
		this.city = city;
		this.tradingArea = tradingArea;
		this.hotelName = hotelName;
		this.roomType = roomType;
		this.starLevel = starLevel;
		this.gradeInterval = gradeInterval;
	}
}
