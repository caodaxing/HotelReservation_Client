package logic.room;

import java.rmi.RemoteException;

import Message.ResultMessage;
import Message.RoomType;
import logic.utility.Time;
import po.RoomPO;
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
	
	//改变指定时期的房间数量信息，changenum包含正负号
		public ResultMessage updateRoom(String hotelID, RoomType roomType, int changeNum, String time) {
			
			//如果是当天，调用重载的方法
			if(new Time(time).sameDay(new Time(Time.getCurrentTime()))) {
				return this.updateRoom(hotelID, roomType, changeNum);
			}
			
			int dayNum = new Time(time).calculateDay(Time.getCurrentTime());
			
			//更新指定日期的房间数量的数组
			try {
				RoomPO po = this.room.getRoomDao().getRoomInfo(hotelID, roomType.ordinal());

				int[] temp = po.getSpecificTimeRoomNum();
				temp[dayNum] += changeNum;
				po.setSpecificTimeRoomNum(temp);
				
				if(room.getRoomDao().updateRoom(po)) {
					return ResultMessage.SUCCESS;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			return ResultMessage.FAILURE;
		}
	
	//changenum包含正负号,改变当天的房间数量信息
	public ResultMessage updateRoom(String hotelID, RoomType roomType, int changeNum) {
		RoomVO vo = this.room.getRoomInfo(hotelID, roomType);
		vo.roomNum += changeNum;
		
		if(vo.roomNum < 0) {
			return ResultMessage.FAILURE;
		}
		
		return this.room.updateRoomInfo(vo);
	}
}
