package logic.room;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Message.ResultMessage;
import Message.RoomType;
import dataDao.room.RoomDao;
import logic.utility.Time;
import logicService.room.RoomService;
import main.rmi.RemoteHelper;
import po.RoomPO;
import vo.RoomVO;

/**
 * 房间信息管理，提供查看酒店的房间列表、具体房间信息、增加和修改房间信息功能
 * @author d
 *
 */
public class Room implements RoomService , RoomInfo{

	public static int BOOK_ADVANCE_DAY = 30;
	private RoomDao roomDao;

	public RoomDao getRoomDao() {
		return roomDao;
	}

	public Room() {
		roomDao = RemoteHelper.getInstance().getRoomDao();
//		roomDao = new RoomDao_Stub();
	}
	
	@Override
	public RoomVO getRoomInfo(String hotelID, RoomType roomType) {
		RoomPO po = null;
		try {
			po = this.roomDao.getRoomInfo(hotelID, roomType.ordinal());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(po == null) {
			return null;
		}
		RoomVO vo = new RoomVO(po.getHotelId(), RoomType.values()[po.getRoomType()], po.getRoomNum(), po.getPrice());
		
		return vo;
	}
	

	public ArrayList<RoomVO> getRoomList(String hotelId){
		
		ArrayList<RoomPO> roomPOList = null;
		try {
			roomPOList = roomDao.getHotelRooms(hotelId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<RoomVO> roomList = new ArrayList<>();
		
		for (RoomPO po : roomPOList) {
			roomList.add(new RoomVO(po.getHotelId(),  RoomType.values()[po.getRoomType()],
					po.getRoomNum(), po.getPrice()));
		}
		
		return roomList;
	}
	
	
	//更新酒店房间信息
	public ResultMessage updateRoomInfo(RoomVO roomVO){
		if (roomVO==null) {
			System.out.println("logic.room.Room.updateRoomInfo参数异常");
			return null;
		}
		
		try {
			RoomPO po = this.roomDao.getRoomInfo(roomVO.hotelId,  roomVO.roomType.ordinal());
			po.setRoomNum(roomVO.roomNum);
			po.setPrice(roomVO.price);
			
			int[] temp = po.getSpecificTimeRoomNum();
			temp[0] = roomVO.roomNum;
			po.setSpecificTimeRoomNum(temp);
			
			if (roomDao.updateRoom(po)) {
				return ResultMessage.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return ResultMessage.FAILURE;
	}
	
	// 增加酒店房间信息
	public ResultMessage addRoomInfo(RoomVO roomVO){
		if (roomVO == null) {
			System.out.println("logic.room.Room.addRoomInfo参数异常");
			return null;
		}
		
		int[] timeAfterRoomNum = new int[this.BOOK_ADVANCE_DAY];
		for(int i=0; i<this.BOOK_ADVANCE_DAY; ++i) {
			timeAfterRoomNum[i]  = roomVO.roomNum;
		}
		
		RoomPO po = new RoomPO(roomVO.hotelId, roomVO.roomType.ordinal(), roomVO.roomNum, roomVO.price, timeAfterRoomNum);
		
		try {
			if (roomDao.addRoom(po)) {
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
	
	
	public int getSpcificTimeRemainingRoomNums(String hotelId, RoomType roomType, String time) {
		
		int dayNum = new Time(time).calculateDay(Time.getCurrentTime());
		
		if(dayNum > 30  || dayNum < 0) {
			return 0;
		}
		
		RoomPO po = null;
		try {
			po = this.roomDao.getRoomInfo(hotelId, roomType.ordinal());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		if(po != null && po.getSpecificTimeRoomNum() != null) {
			
			System.out.println("hhh");
			
			int remainingRoomNums = po.getSpecificTimeRoomNum()[dayNum];
			return remainingRoomNums;
		}

		return 0;
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
		
		RoomPO po = null;
		try {
			po = this.roomDao.getRoomInfo(hotelID, roomType.ordinal());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(po == null) {
			return 0;
		}
		
		return po.getPrice();
	}


	

}
