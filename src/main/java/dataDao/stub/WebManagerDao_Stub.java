package dataDao.stub;

import dataDao.user.WebManagerDao;
import po.HotelManagerPO;
import po.HotelPO;
import po.WebBusinessPO;

public class WebManagerDao_Stub implements WebManagerDao {

	@Override
	public boolean addHotel(HotelPO hotelPO) {
		return true;
	}

	@Override
	public boolean addHotelManager(HotelManagerPO hotelManagerPO) {
		return true;
	}

	@Override
	public boolean addWebBusiness(WebBusinessPO webBusinessPO) {
		return true;
	}

}
