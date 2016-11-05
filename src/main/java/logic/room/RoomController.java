package logic.room;

import java.util.ArrayList;

import Message.ResultMessage;
import vo.RoomVO;

public class RoomController {

	Room room;
	
	public ArrayList<RoomVO> getRoomList(String hotel_id){
		return room.getRoomList(hotel_id);
	}
	
	public RoomVO getRoomInfo(String hotel_id,String room_id){
		return room.getRoomInfo(hotel_id, room_id);
	}
	
	public ResultMessage updateRoomInfo(RoomVO roomVO){
		return room.updateRoomInfo(roomVO);
	}
	
	public ResultMessage addRoomInfo(RoomVO roomVO){
		return room.addRoomInfo(roomVO);
	}
}
