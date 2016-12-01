package dataDao;

import java.util.ArrayList;

import po.HotelPO;

public interface HotelDao {
	
	public boolean addHotel(HotelPO po);
	
	public boolean modifyHotelInfo(HotelPO po);
	
	public HotelPO getHotelInfoByHotelID(String hotelID);
	
	public ArrayList<String> getBookedHotelID(String userID);

	public ArrayList<String> getTradingAreas(String loaction);
	
	public ArrayList<HotelPO> SearchHotelList(String tradingArea , int level , int priceFloor , int priceCeiling);
	
}
