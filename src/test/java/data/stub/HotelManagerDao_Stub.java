package data.stub;

import dataDao.HotelManagerDao;
import po.HotelManagerPO;

public class HotelManagerDao_Stub implements HotelManagerDao {

	@Override
	public HotelManagerPO getHotelManagerInfo(String hotel_ID) {
		return null;
	}

	@Override
	public boolean updateHotelManagerInfo(HotelManagerPO po) {
		return false;
	}

}
