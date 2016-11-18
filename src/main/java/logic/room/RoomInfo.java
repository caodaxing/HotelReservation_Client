package logic.room;

import vo.RoomVO;

/**
 * 为hotel提供的获取房间信息的接口
 * @author Mark.W
 *
 */
public interface RoomInfo {
	public RoomVO getRoomInfo(String hotel_id,String room_id);
}
