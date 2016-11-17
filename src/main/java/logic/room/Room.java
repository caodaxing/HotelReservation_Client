package logic.room;

import java.util.ArrayList;

import Message.ResultMessage;
import vo.RoomVO;

/**
 * 房间信息管理，提供查看酒店的房间列表、具体房间信息、增加和修改房间信息功能
 * @author d
 *
 */
public class Room {

	RoomList roomList;
	
	/**
	 * 获取酒店房间列表
	 * @param hotel_id 传入的酒店id
	 * @return ArrayList<RoomVO> 酒店的房间信息列表
	 * @author bcy
	 */
	public ArrayList<RoomVO> getRoomList(String hotel_id){
		return roomList.getRoomList(hotel_id);
	}
	
	/**
	 * 获取酒店具体房间信息
	 * @param hotel_id 传入的酒店id和房间id
	 * @return RoomVO 酒店指定房间的信息
	 * @author bcy
	 */
	public RoomVO getRoomInfo(String hotel_id,String room_id){
		return null;
	}
	
	/**
	 * 更新酒店房间信息
	 * @param RoomVO 传入的VO信息
	 * @return ResultMessage 返回修改的结果（成功/失败）
	 * @author bcy
	 */
	public ResultMessage updateRoomInfo(RoomVO room){
		return ResultMessage.Modify_Success;
	}
	
	/**
	 * 增加酒店房间信息
	 * @param RoomVO 传入的VO信息
	 * @return ResultMessage 返回增加的结果（成功/失败）
	 * @author bcy
	 */
	public ResultMessage addRoomInfo(RoomVO room){
		return ResultMessage.Add_Success;
	}
}
