package logic.hotel;

import Message.ResultMessage;
import logic.room.Room;

/**
 * 订单执行时调用的接口，更新房间信息
 * @author Mark.W
 *
 */
public interface HotelUpdateRoom {

	public ResultMessage updateRoom(Room room);
}
