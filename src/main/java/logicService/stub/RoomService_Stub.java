package logicService.stub;

import java.util.ArrayList;

import Message.ResultMessage;
import Message.RoomType;
import logicService.room.RoomService;
import vo.RoomVO;

public class RoomService_Stub implements RoomService {

	public ArrayList<RoomVO> getRoomList(String hotel_id) {
		ArrayList<RoomVO> List = new ArrayList<RoomVO>();
		RoomVO room1 = new RoomVO("kshei", RoomType.SINGLE_ROOM, 1, 288);
		RoomVO room2 = new RoomVO("nsjkd", RoomType.STANDARD_ROOM, 1, 255);
		List.add(room1);
		List.add(room2);
		
		return List;
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

	@Override
	public RoomVO getRoomInfo(String hotelID, RoomType roomType) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
