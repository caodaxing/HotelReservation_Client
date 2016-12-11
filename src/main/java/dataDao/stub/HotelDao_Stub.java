package dataDao.stub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import dataDao.hotel.HotelDao;
import po.HotelPO;

public class HotelDao_Stub implements HotelDao {

	private ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
	private HashMap<String, String> locationMap = new HashMap<String, String>();

	public HotelDao_Stub() {
		// locationMap = new HashMap<>();
		// locationMap.put("栖霞区", "马群");
		// locationMap.put("栖霞区", "仙林中心");
		// locationMap.put("栖霞区", "尧化门");
		// locationMap.put("秦淮区", "新街口");
		// hotelList.add(new HotelPO("123", "汉庭", "123", "123", "123", "123", 1,
		// "", null, null, null, null));

		// hotelList.add(new HotelPO("00001", "green", "鼓楼区", "南京",
		// "仙林中心","仙林大道163", 3,
		// "好酒店", "好设施",null, null, "南京大学"));
	}

	public boolean addHotel(HotelPO po) {
		hotelList.add(po);
		return true;
	}

	public boolean updateHotel(HotelPO po) {
		if (po == null) {
			return false;
		}

		for (HotelPO hotelPO : hotelList) {
			if (po.getHoteID() == hotelPO.getHoteID()) {
				hotelList.remove(hotelPO);
				hotelList.add(po);
				return true;
			}
		}
		return false;
	}

	public HotelPO getHotelInfoByHotelID(String hotelID) {
		for (HotelPO hotelPO : hotelList) {
			if (hotelID == hotelPO.getHoteID()) {
				return hotelPO;
			}
		}
		return null;
	}

	public ArrayList<String> getTradingAreas(String loaction) {
		ArrayList<String> tradingAreas = new ArrayList<>();

		Iterator iterator = locationMap.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			String loc = (String) entry.getKey();
			if (loc == loaction) {
				String tradingArea = (String) entry.getValue();
				tradingAreas.add(tradingArea);
			}
		}
		return tradingAreas;
	}

	public ArrayList<HotelPO> SearchHotelList(String city, String tradingArea) {
		ArrayList<HotelPO> hotels = new ArrayList<>();
		
		for (HotelPO hotelPO : hotelList) {
			if (hotelPO.getCity() == city && hotelPO.getTradingArea() == tradingArea) {
				hotels.add(hotelPO);
			}
		}
		return hotelList;
	}

	@Override
	public boolean hotelIDExist(String hotelID) {
		
		
		return false;
	}

}
