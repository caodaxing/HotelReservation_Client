package po;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @param hoteID 酒店ID
 * @param tradingArea 所属商圈
 * @param locationOfHotel 酒店地址
 * @param levelOfHotel 酒店星级
 * @param introduction 酒店介绍
 * @param facilities 酒店设施
 * @param pictures 照片
 * @param emptyRoomNum 不同类型房间空余数量，类型 0单人间 1标准间 2三人间 3大床房 4套间
 * @param bussiness 合作企业
 * @author Mark.W
 *
 */
public class HotelPO {
	private String hoteID;
	private String tradingArea;
	private String locationOfHotel;
	private int levelOfHotel;
	private String introduction;
	private String facilities;
	private ArrayList<String> picturesPath;
	private HashMap<Integer, Integer> emptyRoomNum;
	private String bussiness;

	public HotelPO(String hoteID,String tradingArea,String locationOfHotel,int levelOfHotel,
			String introduction, String facilities, ArrayList<String> pictures,
			HashMap<Integer, Integer> emptyRoomNum, String bussiness) {
		this.hoteID=hoteID;
		this.tradingArea=tradingArea;
		this.locationOfHotel=locationOfHotel;
		this.levelOfHotel=levelOfHotel;
		this.introduction=introduction;
		this.facilities = facilities;
		this.picturesPath=pictures;
		this.emptyRoomNum=emptyRoomNum;
		this.bussiness = bussiness;
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

	public String getHoteID() {
		return hoteID;
	}

	public void setHoteID(String hoteID) {
		this.hoteID = hoteID;
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

	public ArrayList<String> getPictures() {
		return picturesPath;
	}

	public void setPictures(ArrayList<String> pictures) {
		this.picturesPath = pictures;
	}

	public HashMap<Integer, Integer> getEmptyRoomNum() {
		return emptyRoomNum;
	}

	public void setEmptyRoomNum(HashMap<Integer, Integer> emptyRoomNum) {
		this.emptyRoomNum = emptyRoomNum;
	}
	
	
}
