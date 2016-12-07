package logic.mockObject;

import Message.ResultMessage;
import logic.room.RoomInfo;
import vo.RoomVO;

public class MockRoomInfo implements RoomInfo{

	@Override
	public RoomVO getRoomInfo(String hotel_id, String room_id) {
		return null;
	}

	@Override
	public ResultMessage updateRoomInfo(RoomVO roomVO) {
		return null;
	}

}
