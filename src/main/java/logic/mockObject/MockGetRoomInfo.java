package logic.mockObject;

import java.util.ArrayList;

import Message.RoomType;
import logic.room.GetRoomInfo;
import vo.RoomVO;

public class MockGetRoomInfo implements GetRoomInfo{

	@Override
	public RoomVO getRoomInfo(String hotel_id, String room_id) {
		return new RoomVO("green", "1109", RoomType.STANDARD_ROOM, 300, false, null);
	}

	@Override
	public ArrayList<RoomVO> getRoomList(String hotelID) {
		return null;
	}

}
