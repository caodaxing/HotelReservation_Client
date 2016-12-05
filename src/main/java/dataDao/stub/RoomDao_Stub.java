package dataDao.stub;

import java.util.ArrayList;

import dataDao.RoomDao;
import po.RoomPO;

public class RoomDao_Stub implements RoomDao {

	ArrayList<RoomPO> roomList = new ArrayList<>();
	
	public RoomPO getRoomInfo(String hotelId, String roomId) {
		for (RoomPO roomPO : roomList) {
			if (roomPO.getHotelId()==hotelId&&roomPO.getRoomId()==roomId) {
				return roomPO;
			}
		}
		return null;
	}

	public boolean addRoom(RoomPO roomPO) {
		if (roomPO!=null) {
			roomList.add(roomPO);
			return true;
		}
		return false;
	}

	public boolean updateRoom(RoomPO roomPO) {
		if (roomPO!=null) {
			for (RoomPO room : roomList) {
				if (room.getHotelId().equals(roomPO.getHotelId())&&room.getRoomId().equals(room.getRoomId())) {
					roomList.remove(room);
					roomList.add(roomPO);
					return true;
				}
			}
		}
		return false;
	}

	public ArrayList<RoomPO> getHotelRooms(String hotelId) {
		ArrayList<RoomPO> roomPOList = new ArrayList<>();
		for (RoomPO roomPO : roomList) {
			if (roomPO.getHotelId()==hotelId) {
				roomPOList.add(roomPO);
			}
		}
		return roomPOList;
	}
	

}
