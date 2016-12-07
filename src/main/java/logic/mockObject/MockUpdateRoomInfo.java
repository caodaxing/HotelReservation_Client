package logic.mockObject;

import Message.ResultMessage;
import logic.room.UpdateRoomInfo;
import vo.RoomVO;

public class MockUpdateRoomInfo implements UpdateRoomInfo{

	@Override
	public ResultMessage updateRoomInfo(RoomVO roomVO) {
		return null;
	}


}
