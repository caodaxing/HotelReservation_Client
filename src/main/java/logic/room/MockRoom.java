package logic.room;

import java.util.ArrayList;
import vo.RoomVO;

public class MockRoom {
	
	public ArrayList<RoomVO> getRoomList(String hotel_id) {
		return null;
	}
	
	public RoomVO getRoomInfo(String hotel_id,String room_id){
		return null;
	}
	
	public boolean updateRoomInfo(RoomVO room){
		return true;
	}
	
	public boolean addRoomInfo(RoomVO room){
		return true;
	}
}
