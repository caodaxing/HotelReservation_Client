package logic.orderManagement;

import Message.ResultMessage;
import logicService.room.Room;

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
