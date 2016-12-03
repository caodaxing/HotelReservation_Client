package dataDao.user;

import po.HotelManagerPO;
import po.HotelPO;
import po.WebBusinessPO;

public interface WebManagerDao {
	
	public boolean addHotel(HotelPO hotelPO);
	
	public boolean addHotelManager(HotelManagerPO hotelManagerPO);
	
	public boolean addWebBusiness(WebBusinessPO  webBusinessPO);
	
}
