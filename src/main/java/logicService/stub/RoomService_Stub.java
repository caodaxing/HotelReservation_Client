package logicService.stub;

import java.util.ArrayList;

import Message.ResultMessage;
import Message.RoomType;
import logicService.room.RoomService;
import vo.RoomVO;

public class RoomService_Stub implements RoomService {

	public ArrayList<RoomVO> getRoomList(String hotel_id) {
		ArrayList<RoomVO> List = new ArrayList<RoomVO>();
		RoomVO room1 = new RoomVO("kshei", "9239", RoomType.SINGLE_ROOM, 288, null);
		RoomVO room2 = new RoomVO("nsjkd", "7383", RoomType.STANDARD_ROOM, 255, null);
		List.add(room1);
		List.add(room2);
		
		return List;
	}

	public RoomVO getRoomInfo(String hotel_id, String room_id) {
//		return new RoomVO(0, 288, 0, "1109");
		return null;
	}

	public ResultMessage updateRoomInfo(RoomVO roomVO) {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage addRoomInfo(RoomVO roomVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public int getRemainingRoomNums(String hotelID, RoomType roomType) {
		return 1;
	}
	
}
