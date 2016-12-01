package logic.hotel;

import logic.promotion.HotelPromotion;
import vo.HotelVO;
import vo.RoomVO;

public class MockHotel extends Hotel{
	
	public MockHotel(HotelPromotion hotelPromotion) {
		super(hotelPromotion);
	}

	boolean stateOfRoom;
	
	public boolean updateRoom(String hotel_id,RoomVO room){
		return stateOfRoom;
	}
	
	public HotelVO getHotelItemInfo (String hotel_id) {
		return null;
	}
}
