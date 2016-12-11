package dataDao.stub;

import java.util.ArrayList;

import dataDao.user.HotelManagerDao;
import po.HotelManagerPO;

public class HotelManagerDao_Stub implements HotelManagerDao {

	private ArrayList<HotelManagerPO> pos = new ArrayList<HotelManagerPO>();
	 
	public HotelManagerDao_Stub() {
		this.pos.add(new HotelManagerPO("rujia", "如家酒店", "12345678910", "3203222"));
		this.pos.add(new HotelManagerPO("qitian", "七天酒店", "10987654321", "3203221"));
	}

	@Override
	public HotelManagerPO getHotelManagerInfo(String hotelManagerID) {
		if(hotelManagerID == "rujia") {
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
