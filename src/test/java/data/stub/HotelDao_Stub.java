package data.stub;

import java.util.ArrayList;

import dataDao.HotelDao;
import po.HotelPO;

public class HotelDao_Stub implements HotelDao {

	public boolean addHotel(HotelPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyHotelInfo(HotelPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public HotelPO getHotelInfoByHotelID(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getTradingAreas(String loaction) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<HotelPO> SearchHotelList(String tradingArea, int level, int priceFloor, int priceCeiling) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
