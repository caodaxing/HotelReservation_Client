package vo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @param hoteID 酒店ID
 * @param hotelName 酒店名称
 * @param city 城市
 * @param tradingArea 所属商圈
 * @param locationOfHotel 酒店地址
 * 
 * @param evaluationGrades 评价等级
 * @param levelOfHotel 酒店星级
 * @param introduction 酒店介绍
 * @param facilities 酒店设施
 * @param picturesPath 照片
 * @param emptyRoomNum 不同类型房间空余数量，类型 0单人间 1标准间 2三人间 3大床房 4套间
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
	public ArrayList<String> picturesPath;
	public HashMap<Integer, Integer> emptyRoomNum;
	public String bussiness;

	public HotelVO(String hoteID,String hotelName, String city, String tradingArea,
			String locationOfHotel,double evaluationGrades,int levelOfHotel,String introduction, String facilities,
			ArrayList<String> pictures,HashMap<Integer, Integer> emptyRoomNum, String bussiness) {
		this.hoteID=hoteID;
		this.hotelName = hotelName;
		this.city = city;
		this.tradingArea=tradingArea;
		this.locationOfHotel=locationOfHotel;
		this.evaluationGrades=evaluationGrades;
		this.levelOfHotel=levelOfHotel;
		this.introduction=introduction;
		this.facilities = facilities;
		this.picturesPath=pictures;
		this.emptyRoomNum=emptyRoomNum;
		this.bussiness = bussiness;
	}
}
