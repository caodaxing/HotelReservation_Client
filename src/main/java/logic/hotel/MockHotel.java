package logic.hotel;

import vo.HotelVO;
import vo.RoomVO;

public class MockHotel extends Hotel{
	boolean stateOfRoom;
	
	public MockHotel(){};
	
	public MockHotel(boolean signal){
		stateOfRoom = signal;
	}
	public boolean updateRoom(String hotel_id,RoomVO room){
		return stateOfRoom;
	}
	
	public HotelVO getHotelItemInfo (String hotel_id) {
		return null;
	}
}
