package dataDao.stub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import dataDao.HotelDao;
import po.HotelPO;

public class HotelDao_Stub implements HotelDao {

	private ArrayList<HotelPO> hotelList = new ArrayList<>();
	private HashMap<String , String > locationMap;
	private OrderDao_Stub orderDao_Stub;
	
	public HotelDao_Stub() {
		orderDao_Stub = new OrderDao_Stub();
		locationMap = new HashMap<>();
		locationMap.put("栖霞区", "马群");
		locationMap.put("栖霞区", "仙林中心");
		locationMap.put("栖霞区", "尧化门");
		locationMap.put("秦淮区", "新街口");
		hotelList.add(new HotelPO("123", "汉庭", "123", "123", "123", "123", 1, "", null, null, null, null));
	}
	
	public boolean addHotel(HotelPO po) {
		hotelList.add(po);
		return true;
	}

	public boolean updateHotel(HotelPO po) {
		if (po==null) {
			return false;
		}
		for (HotelPO hotelPO : hotelList) {
			if (po.getHoteID()==hotelPO.getHoteID()) {
				hotelList.remove(hotelPO);
				hotelList.add(po);
				return true;
			}
		}
		return false;
	}

	public HotelPO getHotelInfoByHotelID(String hotelID) {
		for (HotelPO hotelPO : hotelList) {
			if (hotelID==hotelPO.getHoteID()) {
				return hotelPO;
			}
		}
		return null;
	}

	public ArrayList<String> getTradingAreas(String loaction) {
		ArrayList<String> tradingAreas = new ArrayList<>();
		Iterator iterator = locationMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry)iterator.next();
			String loc = (String) entry.getKey();
			if (loc==loaction) {
				String tradingArea = (String)entry.getValue();
				tradingAreas.add(tradingArea);
			}
		}
		return tradingAreas;
	}

	public ArrayList<HotelPO> SearchHotelList(String city,String distract, String tradingArea) {
		if (city==null) {
			System.out.println("dataDao.stub.HotelDar_Stub.SearchHotelList参数异常");
			return null;
		}
		return null;
	}

}
