package vo;

import java.util.ArrayList;

/**
 * @param hoteID 酒店ID
 * @param hotelName 酒店名称
 * @param city 城市
 * @param tradingArea 所属商圈
 * 
 * @param locationOfHotel 酒店地址
 * @param levelOfHotel 酒店星级
 * @param introduction 酒店介绍
 * @param picturesPath 照片
 * @param emptyRoomNum 空余房间数量
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
	public int levelOfHotel;
	public String introduction;
	public ArrayList<String> picturesPath;
	public int emptyRoomNum;
	public String bussiness;

	public HotelVO(String hoteID,String hotelName, String city, String tradingArea,String locationOfHotel,int levelOfHotel,
			String introduction,ArrayList<String> pictures,int emptyRoomNum, String bussiness) {
		this.hoteID=hoteID;
		this.hotelName = hotelName;
		this.city = city;
		this.tradingArea=tradingArea;
		this.locationOfHotel=locationOfHotel;
		this.levelOfHotel=levelOfHotel;
		this.introduction=introduction;
		this.picturesPath=pictures;
		this.emptyRoomNum=emptyRoomNum;
		this.bussiness = bussiness;
	}
}
