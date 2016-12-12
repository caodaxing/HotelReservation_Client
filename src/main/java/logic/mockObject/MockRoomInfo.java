package logic.mockObject;

import java.util.ArrayList;
import java.util.HashMap;

import Message.RoomType;
import logic.room.RoomInfo;
import vo.RoomVO;

public class MockRoomInfo implements RoomInfo{

	@Override
	public RoomVO getRoomInfo(String hotel_id, String room_id) {
		
		HashMap<String, String> n11 = new HashMap<String, String>();
		n11.put("2016-12-15 12:00:00", "2016-12-16 12:00:00");
		n11.put("2016-12-25 12:00:00", "2016-12-26 12:00:00");
		return new RoomVO("green", "1109", RoomType.STANDARD_ROOM, 300, n11, null);
	}

	@Override
	public ArrayList<RoomVO> getRoomList(String hotelID) {
		return null;
	}

	@Override
	public int getSpcificTimeRemainingRoomNums(String hotelId, RoomType roomType, String t) {
		return 0;
	}

}
