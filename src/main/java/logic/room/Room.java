package logic.room;

import java.util.ArrayList;

import Message.ResultMessage;
import vo.RoomVO;

public class Room {

	RoomList roomList;
	public ArrayList<RoomVO> getRoomList(String hotel_id){
		return roomList.getRoomList(hotel_id);
	}
	
	public RoomVO getRoomInfo(String hotel_id,String room_id){
		return null;
	}
	
	public ResultMessage updateRoomInfo(RoomVO room){
		return ResultMessage.Modify_Success;
	}
	
	public ResultMessage addRoomInfo(RoomVO room){
		return ResultMessage.Add_Success;
	}
}
