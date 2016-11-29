package vo;

import java.util.ArrayList;

/**
 * @param hoteID 酒店ID
 * @param tradingArea 所属商圈
 * @param locationOfHotel 酒店地址
 * @param levelOfHotel 酒店星级
 * @param introduction 酒店接受
 * @param pictures 照片
 * @param emptyRoomNum 空余房间数量
 * @param bussiness 合作企业
 * @author bcy
 *
 */
public class HotelVO {
	public String hoteID;
	public String tradingArea;
	public String locationOfHotel;
	public int levelOfHotel;
	public String introduction;
	public ArrayList<String> picturesPath;
	public int emptyRoomNum;
	public String bussiness;

	public HotelVO(String hoteID,String tradingArea,String locationOfHotel,int levelOfHotel,
			String introduction,ArrayList<String> pictures,int emptyRoomNum, String bussiness) {
		this.hoteID=hoteID;
		this.tradingArea=tradingArea;
		this.locationOfHotel=locationOfHotel;
		this.levelOfHotel=levelOfHotel;
		this.introduction=introduction;
		this.picturesPath=pictures;
		this.emptyRoomNum=emptyRoomNum;
		this.bussiness = bussiness;
	}
}
