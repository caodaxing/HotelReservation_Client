package dataDao;

import po.HotelManagerPO;

public interface HotelManagerDao {
	
	public HotelManagerPO getHotelManagerInfo(String hotel_ID);
	
	public boolean updateHotelManagerInfo(HotelManagerPO po);
	
}
