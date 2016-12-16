package logic.room;

import Message.ResultMessage;
import Message.RoomType;
import vo.RoomVO;

/**
 * 给order调用的 生成/完成订单更改房间数量信息
 * @author Mark.W
 *
 */
public class UpdateRoom {

	private Room room;
	
	public UpdateRoom() {
		this.room = new Room();
	}
	
	//changenum包含正负号
	public ResultMessage updateRoom(String hotelID, RoomType roomType, int changeNum) {
		RoomVO vo = this.room.getRoomInfo(hotelID, roomType);
		vo.roomNum += changeNum;
		
		if(vo.roomNum < 0) {
			return ResultMessage.FAILURE;
		}
		
		return this.room.updateRoomInfo(vo);
	}
}
