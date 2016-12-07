package logic.hotel;

import Message.ResultMessage;
import logic.room.Room;
import vo.RoomVO;

/**
 * 订单执行时调用的接口，更新房间信息
 * @author Mark.W
 *
 */
public interface HotelUpdateRoom {

	public ResultMessage updateRoom(RoomVO roomVO);
}
