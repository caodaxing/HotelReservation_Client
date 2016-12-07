package logic.room;

import Message.ResultMessage;
import vo.RoomVO;

/**
 * 为hotel提供的获取和修改房间信息的接口
 * @author Mark.W
 *
 */
public interface GetRoomInfo {
	public RoomVO getRoomInfo(String hotel_id,String room_id);
	
}
