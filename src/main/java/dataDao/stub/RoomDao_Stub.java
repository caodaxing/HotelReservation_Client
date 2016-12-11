package dataDao.stub;

import java.util.ArrayList;

import Message.RoomType;
import dataDao.room.RoomDao;
import po.RoomPO;

public class RoomDao_Stub implements RoomDao {

	ArrayList<RoomPO> roomList = new ArrayList<RoomPO>();
	
	public RoomDao_Stub() {
		this.roomList.add(new RoomPO("00002", "1109", RoomType.STANDARD_ROOM.ordinal(), 400, true, null));
		this.roomList.add(new RoomPO("00002", "1009", RoomType.SINGLE_ROOM.ordinal(), 250, false, null));
		this.roomList.add(new RoomPO("00002", "1203", RoomType.STANDARD_ROOM.ordinal(), 1200, true, null));
	}

	public RoomPO getRoomInfo(String hotelId, String roomId) {
		if(hotelId == "00002" && roomId == "1109") {
			return roomList.get(0);
		} else if(hotelId == "00002" && roomId == "1009") {
			return roomList.get(1);
		}
		
		return roomList.get(2);
	}

	public boolean addRoom(RoomPO roomPO) {
		return true;
	}

	public boolean updateRoom(RoomPO roomPO) {
		return true;
	}

	public ArrayList<RoomPO> getHotelRooms(String hotelId) {
		return roomList;
	}
	

}
