package dataDao.stub;

import dataDao.user.HotelManagerDao;
import po.HotelManagerPO;

public class HotelManagerDao_Stub implements HotelManagerDao {

	@Override
	public HotelManagerPO getHotelManagerInfo(String hotelManagerID) {
		if(hotelManagerID == "rujia")
			return new HotelManagerPO("rujia", "如家酒店", "12345678910", "卞纯源", "3203222");
		else if(hotelManagerID == "qitian")
			return new HotelManagerPO("qitian", "七天酒店", "10987654321", "赵德宇", "3203221");
		
		return null;
	}

	@Override
	public boolean updateHotelManagerInfo(HotelManagerPO po) {
		return true;
	}

}
