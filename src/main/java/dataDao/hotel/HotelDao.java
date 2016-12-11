package dataDao.hotel;

import java.util.ArrayList;

import Message.RoomType;
import po.HotelPO;

public interface HotelDao {
	
	public boolean addHotel(HotelPO po);
	
	public boolean updateHotel(HotelPO po);
	
	public HotelPO getHotelInfoByHotelID(String hotelID);
	
	public ArrayList<String> getTradingAreas(String loaction);
	
	public ArrayList<HotelPO> SearchHotelList(String city,String distract,String tradingArea);
	
}
