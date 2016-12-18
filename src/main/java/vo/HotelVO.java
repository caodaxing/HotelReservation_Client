package vo;


/**
 * @param hoteID 酒店ID
 * @param hotelName 酒店名称
 * @param city 城市
 * @param tradingArea 所属商圈
 * @param locationOfHotel 酒店地址
 * @param evaluationGrades 评价等级
 * @param levelOfHotel 酒店星级
 * @param introduction 酒店介绍
 * @param facilities 酒店设施
 * @param picturesPaths 照片的路径！！！
 * @param bussiness 合作企业
 * @author bcy
 *
 */
public class HotelVO {
	public String hoteID;
	public String hotelName;
	public String city;
	public String tradingArea;
	public String locationOfHotel;
	public double evaluationGrades;
	public int levelOfHotel;
	public String introduction;
	public String facilities;
	public String bussiness;
	
	
	/**
	 * @param hoteID
	 * @param hotelName
	 * @param city
	 * @param tradingArea
	 * @param locationOfHotel
	 * @param evaluationGrades
	 * @param levelOfHotel
	 * @param introduction
	 * @param facilities
	 * @param picturesPaths
	 * @param pictures
	 * @param bussiness
	 */
	public HotelVO(String hoteID, String hotelName, String city, String tradingArea, String locationOfHotel,
			double evaluationGrades, int levelOfHotel, String introduction, String facilities, String bussiness) {
		this.hoteID = hoteID;
		this.hotelName = hotelName;
		this.city = city;
		this.tradingArea = tradingArea;
		
		
		if(locationOfHotel == null) {
			this.locationOfHotel = "";
		} else {
			this.locationOfHotel = locationOfHotel;
		}
		
		this.evaluationGrades = evaluationGrades;
		this.levelOfHotel = levelOfHotel;
		
		if(bussiness == null) {
			this.bussiness = "";
		} else {
			this.bussiness = bussiness;
		}
		
		if(facilities == null) {
			this.facilities = "";
		} else {
			this.facilities = facilities;
		}
		
		if(introduction == null) {
			this.introduction = "";
		} else {
			this.introduction = introduction;
		}
		
	}



	/**
	 * 提供给WebManager的构造方法
	 * @param hoteID
	 * @param hotelName
	 * @param city
	 * @param tradingArea
	 * @param locationOfHotel
	 * @param levelOfHotel
	 * @param introduction
	 * @param facilities
	 * @param pictures
	 * @param emptyRoomNum
	 * @param bussiness
	 */
	public HotelVO(String hoteID,String hotelName, String city,String tradingArea,
			String locationOfHotel,int levelOfHotel,String introduction, String facilities,String bussiness) {
		this.hoteID=hoteID;
		this.hotelName = hotelName;
		this.city = city;
		this.tradingArea=tradingArea;
		this.levelOfHotel=levelOfHotel;

		if(locationOfHotel == null) {
			this.locationOfHotel = "";
		} else {
			this.locationOfHotel = locationOfHotel;
		}
		
		if(bussiness == null) {
			this.bussiness = "";
		} else {
			this.bussiness = bussiness;
		}
		
		if(facilities == null) {
			this.facilities = "";
		} else {
			this.facilities = facilities;
		}
		
		if(introduction == null) {
			this.introduction = "";
		} else {
			this.introduction = introduction;
		}
	}
}
