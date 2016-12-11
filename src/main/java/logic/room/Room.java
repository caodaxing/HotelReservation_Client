package logic.room;

import java.util.ArrayList;

import Message.ResultMessage;
import Message.RoomType;
import dataDao.room.RoomDao;
import dataDao.stub.RoomDao_Stub;
import logic.utility.RoomTransform;
import logicService.room.RoomService;
import po.RoomPO;
import vo.RoomVO;

/**
 * 房间信息管理，提供查看酒店的房间列表、具体房间信息、增加和修改房间信息功能
 * @author d
 *
 */
public class Room implements RoomService , RoomInfo{

	private RoomDao roomDao;
	
	public Room() {
		roomDao = new RoomDao_Stub();
	}
	
	/**
	 * 获取酒店房间列表
	 * @param hotel_id 传入的酒店id
	 * @return ArrayList<RoomVO> 酒店的房间信息列表
	 * @author bcy
	 */
	public ArrayList<RoomVO> getRoomList(String hotelId){
		ArrayList<RoomPO> roomPOList = roomDao.getHotelRooms(hotelId);
		ArrayList<RoomVO> roomList = new ArrayList<>();
		
		for (RoomPO roomPO : roomPOList) {
			roomList.add(RoomTransform.roomTransToVO(roomPO));
		}
		return roomList;
	}
	
	/**
	 * 获取酒店具体房间信息
	 * @param hotel_id 传入的酒店id和房间id
	 * @return RoomVO 酒店指定房间的信息
	 * @author bcy
	 */
	public RoomVO getRoomInfo(String hotelId, String roomId){
		return RoomTransform.roomTransToVO(roomDao.getRoomInfo(hotelId, roomId));
	}
	
	/**
	 * 更新酒店房间信息
	 * @param RoomVO 传入的VO信息
	 * @return ResultMessage 返回修改的结果（成功/失败）
	 * @author bcy
	 */
	public ResultMessage updateRoomInfo(RoomVO roomVO){
		if (roomVO==null) {
			System.out.println("logic.room.Room.updateRoomInfo参数异常");
			return null;
		}
		
		if (roomDao.updateRoom(RoomTransform.roomTransToPO(roomVO))) {
			return ResultMessage.SUCCESS;
		}
		
		return ResultMessage.FAILURE;
	}
	
	/**
	 * 增加酒店房间信息
	 * @param RoomVO 传入的VO信息
	 * @return ResultMessage 返回增加的结果（成功/失败）
	 * @author bcy
	 */
	public ResultMessage addRoomInfo(RoomVO roomVO){
		if (roomVO == null) {
			System.out.println("logic.room.Room.addRoomInfo参数异常");
			return null;
		}
		
		if (roomDao.addRoom(RoomTransform.roomTransToPO(roomVO))) {
			return ResultMessage.SUCCESS;
		}
	
		return ResultMessage.FAILURE;
	}

	@Override
	public int getRemainingRoomNums(String hotelId, RoomType roomType) {
		ArrayList<RoomPO> roomList = roomDao.getHotelRooms(hotelId);
		int remainingRoomNums = 0;
		
		for (RoomPO roomPO : roomList) {
			if (roomPO.getRoomType() == roomType.ordinal() && roomPO.isEmpty()) {
				remainingRoomNums ++;
			}
		}
		
		return remainingRoomNums;
	}
}
