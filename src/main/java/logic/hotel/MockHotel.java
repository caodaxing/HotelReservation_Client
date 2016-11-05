package logic.hotel;

import vo.RoomVO;

public class MockHotel {
	boolean stateOfRoom;
	public MockHotel(boolean signal){
		stateOfRoom = signal;
	}
	public boolean updateRoom(String hotel_id,RoomVO room){
		return stateOfRoom;
	}
}
