package logic.room;

import java.util.ArrayList;
import vo.RoomVO;

public class MockRoom {
	
	public ArrayList<RoomVO> getRoomList(String hotel_id) {
		System.out.println("getRoomList调用成功");
		return null;
	}
	
	public RoomVO getRoomInfo(String hotel_id,String room_id){
		System.out.println("getRoomInfo调用成功");
		return null;
	}
	
	public boolean updateRoomInfo(RoomVO room){
		System.out.println("updateRoomInfo调用成功");
		return true;
	}
	
	public boolean addRoomInfo(RoomVO room){
		System.out.println("addRoomInfo调用成功");
		return true;
	}
}
