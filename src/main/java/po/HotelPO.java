package po;

import java.io.Serializable;

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
 * @param bussiness 合作企业
 * @author Mark.W
 *
 */
public class HotelPO implements Serializable{

	private String hoteID;
	private String hotelName;
	private String city;
	private String tradingArea;
	private String locationOfHotel;
	private double evaluationGrades;
	private int levelOfHotel;
	private String introduction;
	private String facilities;
	private String bussiness;
	
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
	 * @param bussiness
	 */
	public HotelPO(String hoteID, String hotelName, String city, String tradingArea, String locationOfHotel,
			double evaluationGrades, int levelOfHotel, String introduction, String facilities, String bussiness) {
		this.hoteID = hoteID;
		this.hotelName = hotelName;
		this.city = city;
		this.tradingArea = tradingArea;
		this.locationOfHotel = locationOfHotel;
		this.evaluationGrades = evaluationGrades;
		this.levelOfHotel = levelOfHotel;
		this.introduction = introduction;
		this.facilities = facilities;
		this.bussiness = bussiness;
	}

	public String getHoteID() {
		return hoteID;
	}

	public void setHoteID(String hoteID) {
		this.hoteID = hoteID;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTradingArea() {
		return tradingArea;
	}

	public void setTradingArea(String tradingArea) {
		this.tradingArea = tradingArea;
	}

	public String getLocationOfHotel() {
		return locationOfHotel;
	}

	public void setLocationOfHotel(String locationOfHotel) {
		this.locationOfHotel = locationOfHotel;
	}

	public double getEvaluationGrades() {
		return evaluationGrades;
	}

	public void setEvaluationGrades(double evaluationGrades) {
		this.evaluationGrades = evaluationGrades;
	}

	public int getLevelOfHotel() {
		return levelOfHotel;
	}

	public void setLevelOfHotel(int levelOfHotel) {
		this.levelOfHotel = levelOfHotel;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getBussiness() {
		return bussiness;
	}

	public void setBussiness(String bussiness) {
		this.bussiness = bussiness;
	}

	
}
