package logic.mockObject;

import logic.hotel.HotelTradingAreaInfo;

public class MockGetHotelTradingArea implements HotelTradingAreaInfo {

	public String getHotelTradingArea(String hotelID) {
		return "鼓楼区";
	}
	
}
