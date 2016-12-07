package dataDao.stub;

import java.util.ArrayList;

import dataDao.HotelDao;
import po.HotelPO;

public class HotelDao_Stub implements HotelDao {

	public boolean addHotel(HotelPO po) {
		return false;
	}

	public boolean updateHotel(HotelPO po) {
		return false;
	}

	public HotelPO getHotelInfoByHotelID(String hotelID) {
		return null;
	}

	public ArrayList<String> getBookedHotelID(String userID) {
		return null;
	}
	
	public ArrayList<String> getTradingAreas(String loaction) {
		return null;
	}

	public ArrayList<HotelPO> SearchHotelList(String tradingArea, int level, int priceFloor, int priceCeiling) {
		return null;
	}


	

}
