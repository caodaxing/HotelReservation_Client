package logic.room;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import Message.ResultMessage;
import Message.RoomType;
import dataDao.room.RoomDao;
import dataDao.stub.RoomDao_Stub;
import logic.utility.RoomTransform;
import logic.utility.TimeSection;
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
		
		ArrayList<RoomPO> roomPOList = null;
		try {
			roomPOList = roomDao.getHotelRooms(hotelId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
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
		RoomPO po = null;
		try {
			po = roomDao.getRoomInfo(hotelId, roomId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return RoomTransform.roomTransToVO(po);
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
		
		try {
			if (roomDao.updateRoom(RoomTransform.roomTransToPO(roomVO))) {
				return ResultMessage.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
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
		
		try {
			if (roomDao.addRoom(RoomTransform.roomTransToPO(roomVO))) {
				return ResultMessage.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	
		return ResultMessage.FAILURE;
	}

	@Override
	public int getRemainingRoomNums(String hotelId, RoomType roomType) {
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String t =format.format(new Date()) + " 12:00:00";
		
		return this.getSpcificTimeRemainingRoomNums(hotelId, roomType, t);
	}
	
	
	public int getSpcificTimeRemainingRoomNums(String hotelId, RoomType roomType, String t) {
		ArrayList<RoomPO> roomList = null;
		try {
			roomList = roomDao.getHotelRooms(hotelId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		int remainingRoomNums = 0;
		
		if(roomType == null) {
			roomType = RoomType.STANDARD_ROOM;
		}
		
		for (RoomPO roomPO : roomList) {
			if (roomPO.getRoomType() == roomType.ordinal()) {
				
				ArrayList<TimeSection> sections = new ArrayList<TimeSection>();
				
				if(roomPO.getNotEmptyTime() != null) {
					Iterator it = roomPO.getNotEmptyTime().entrySet().iterator();
					while(it.hasNext()) {
						Map.Entry<String, String> entry = (Map.Entry<String, String>)(it.next());
						sections.add(new TimeSection((String)entry.getKey(), (String)entry.getValue()));
					}
					
					boolean isEmpty = true;
					for(TimeSection sec : sections) {
						if(sec.includeTime(t)) {
							isEmpty = false;
							break;
						}
					}
					
					if(isEmpty) {
						remainingRoomNums ++;
					}
					
				} else {
					remainingRoomNums ++;
				}
			}
		}
		
		return remainingRoomNums;
	}

	@Override
	public double getHotelLowestPrice(String hotelID) {
		ArrayList<RoomVO> roomList = this.getRoomList(hotelID);
		
		double LowestPrice = 0;
		
		if(roomList == null || roomList.size() == 0) {
			System.out.println("logic.room.getHotelLowestPrice参数报错");
			return 0;
		} 
		
		LowestPrice = roomList.get(0).price;
		
		for (RoomVO roomVO : roomList) {
			if (roomVO.price < LowestPrice) {
				LowestPrice = roomVO.price;
			}
		}
		
		return LowestPrice;
	}

	@Override
	public double getRoomPrice(String hotelID, RoomType roomType) {
		ArrayList<RoomVO> roomList = this.getRoomList(hotelID);
		double price = 0;
		
		if(roomList == null || roomList.size() == 0) {
			System.out.println("logic.room.getRoomPrice参数报错");
			return 0;
		} 
		
		boolean roomExist = false;
		for (RoomVO roomVO : roomList) {
			if (roomVO.roomType == roomType) {
				price = roomVO.price;
				roomExist = true;
				break;
			}
		}
		
		if(!roomExist) {
			System.out.println("logic.room.getRoomPrice生成订单房间信息不一致，酒店不存在该房间");
		}
		
		return price;
	}
}
