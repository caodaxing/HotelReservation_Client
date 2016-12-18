package dataDao.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import dataDao.hotel.HotelDao;
import po.HotelPO;

public class HotelDao_Stub implements HotelDao {

	private ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
	private HashMap<String, ArrayList<String>> locationMap = new HashMap<String, ArrayList<String>>();

	public HotelDao_Stub() {
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("仙林中心");
		a1.add("尧化门");
		a1.add("马群");
		a1.add("新街口");
		a1.add("大行宫");
		 locationMap.put("南京",a1);
		 
		 ArrayList<String> a2 = new ArrayList<String>();
		 a2.add("杨舍");
		a2.add("锦丰");
		a2.add("港区");
		 locationMap.put("张家港",a2);
		
	 
		 hotelList.add(new HotelPO("00001", "如家","南京", "仙林中心", "仙林大道123号", 4.7, 2, "酒店介绍1", "酒店设施1","南京大学"));
		 hotelList.add(new HotelPO("00002", "green","张家港", "杨舍", "凉风路", 4.8, 4, "酒店介绍2", "酒店设施2", "新华书店"));
		 hotelList.add(new HotelPO("00003", "七天","南京", "马群", "仙林大道3号", 4.5, 3, "酒店介绍3", "酒店设施3", "杜蕾斯"));
	}

	public boolean addHotel(HotelPO po) {
		return true;
	}

	public boolean updateHotel(HotelPO po) {
		return true;
	}

	public HotelPO getHotelInfoByHotelID(String hotelID) {
		if(hotelID == "00001") {
			return new HotelPO("00001", "如家","南京", "仙林中心", "仙林大道123号", 4.7, 3, "酒店介绍1", "酒店设施1", "南京大学");
		} else if(hotelID == "00002") {
			return new HotelPO("00002", "如家","张家港", "杨舍", "凉风路", 4.8, 4, "酒店介绍2", "酒店设施2","新华书店");
		}
		
		return new HotelPO("00003", "七天","南京", "马群", "仙林大道3号", 4.5, 3, "酒店介绍3", "酒店设施3", "杜蕾斯");
		
	}

	public ArrayList<String> getTradingAreas(String loaction) {
		if(this.locationMap.containsKey(loaction)) {
			return this.locationMap.get(loaction);
		}
		return null;
	}

	public ArrayList<HotelPO> SearchHotelList(String city, String tradingArea) {
		return this.hotelList;
	}

	@Override
	public boolean hotelIDExist(String hotelID) {
		return false;
	}

	@Override
	public ArrayList<String> getCitys() throws RemoteException {
		return null;
	}

}
