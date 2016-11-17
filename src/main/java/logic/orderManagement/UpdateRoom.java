package logic.orderManagement;

import logic.room.Room;
import message.ResultMessage;

/**
 * 更新房间信息
 * @author Mark.W
 *
 */
public class UpdateRoom {
	
	/**
	 * 更新房间信息
	 * @param hotel_id
	 * @param room
	 * @return ResultMessage
	 */
	public ResultMessage updateRoom(String hotel_id, Room room){
		return ResultMessage.SUCCESS;
	}
}
