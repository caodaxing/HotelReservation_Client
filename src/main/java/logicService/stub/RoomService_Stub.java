package logicService.stub;

import java.util.ArrayList;

import Message.ResultMessage;
import logicService.RoomService;
import vo.RoomVO;

public class RoomService_Stub implements RoomService {

	public ArrayList<RoomVO> getRoomList(String hotel_id) {
		// TODO Auto-generated method stub
		
		ArrayList<RoomVO> List = new ArrayList<RoomVO>();
		RoomVO room1 = new RoomVO(0, 288, 0, "1109");
		RoomVO room2 = new RoomVO(0, 388, 0, "0304");
		List.add(room1);
		List.add(room2);
		
		return List;
	}

	public RoomVO getRoomInfo(String hotel_id, String room_id) {
		// TODO Auto-generated method stub
		
		return new RoomVO(0, 288, 0, "1109");
	}

	public ResultMessage updateRoomInfo(RoomVO roomVO) {
		// TODO Auto-generated method stub
		
		return ResultMessage.SUCCESS;
	}

	public ResultMessage addRoomInfo(RoomVO roomVO) {
		// TODO Auto-generated method stub
		
		return ResultMessage.FAILURE;
	}
	
}
