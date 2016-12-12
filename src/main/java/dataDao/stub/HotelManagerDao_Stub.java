package dataDao.stub;

import java.util.ArrayList;

import dataDao.user.HotelManagerDao;
import po.HotelManagerPO;

public class HotelManagerDao_Stub implements HotelManagerDao {

	private ArrayList<HotelManagerPO> pos = new ArrayList<HotelManagerPO>();
	 
	public HotelManagerDao_Stub() {
		this.pos.add(new HotelManagerPO("00001", "1111111111", "abc", "3203222"));
		this.pos.add(new HotelManagerPO("00002", "2222222222", "def", "3203221"));
	}

	@Override
	public HotelManagerPO getHotelManagerInfo(String hotelManagerID) {
		if(hotelManagerID == "00001") {
			return pos.get(0);
		}
		
		return pos.get(1);
	}

	@Override
	public boolean updateHotelManagerInfo(HotelManagerPO po) {
		return true;
	}

	@Override
	public boolean addHotelManager(HotelManagerPO hotelManagerPO) {
		return true;
	}

}
