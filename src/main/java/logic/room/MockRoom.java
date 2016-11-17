package logic.room;

import java.util.ArrayList;

import Message.ResultMessage;
import vo.RoomVO;

public class MockRoom extends Room{
	
	public ArrayList<RoomVO> getRoomList(String hotel_id) {
		System.out.println("getRoomList调用成功");
		return null;
	}
	
	public RoomVO getRoomInfo(String hotel_id,String room_id){
		System.out.println("getRoomInfo调用成功");
		return null;
	}
	
	public ResultMessage updateRoomInfo(RoomVO room){
		System.out.println("updateRoomInfo调用成功");
		return ResultMessage.Modify_Success;
	}
	
	public ResultMessage addRoomInfo(RoomVO room){
		System.out.println("addRoomInfo调用成功");
		return ResultMessage.Add_Success;
	}
}
