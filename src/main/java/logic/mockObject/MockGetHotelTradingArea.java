package logic.mockObject;

import logic.hotel.GetHotelTradingAreaInfo;

public class MockGetHotelTradingArea implements GetHotelTradingAreaInfo {

	public String getHotelTradingArea(String hotelID) {
		return "鼓楼区";
	}
	
}
