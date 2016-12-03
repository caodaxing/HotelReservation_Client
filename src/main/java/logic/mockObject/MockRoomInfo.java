package logic.mockObject;

import logic.room.RoomInfo;
import vo.RoomVO;

public class MockRoomInfo implements RoomInfo{

	@Override
	public RoomVO getRoomInfo(String hotel_id, String room_id) {
		return null;
	}

}
