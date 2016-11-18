package vo;

/**
 * 搜索酒店的VO类
 * @author Rukawa
 *
 */
public class HotelSearchVO {
	
	String Location;
	String tradingArea;
	String hotelName;
	RoomVO room;
	String starLevel;
	String gradeInterval;
	
	/**
	 * 搜索酒店的VO类
	 * @param Location 酒店地址
	 * @param tradingArea 酒店所属商圈
	 * @param hotelName 酒店名称
	 * @param room RoomVO类
	 * @param starLevel 酒店星级
	 * @param gradeInterval 酒店价格区间
	 * @author Rukawa
	 */
	public HotelSearchVO(String Location,String tradingArea,String hotelName,RoomVO room,String starLevel,String gradeInterval){
		super();
		this.Location = Location;
		this.tradingArea = tradingArea;
		this.hotelName = hotelName;
		this.room = room;
		this.starLevel = starLevel;
		this.gradeInterval = gradeInterval;
	}
}
