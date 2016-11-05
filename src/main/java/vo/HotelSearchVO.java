package vo;

public class HotelSearchVO {
	String Location;
	String tradingArea;
	String hotelName;
	RoomVO room;
	String starLevel;
	String gradeInterval;
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
