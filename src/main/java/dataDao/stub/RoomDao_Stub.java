package dataDao.stub;

import java.util.ArrayList;

import Message.RoomType;
import dataDao.room.RoomDao;
import po.RoomPO;

public class RoomDao_Stub implements RoomDao {

	ArrayList<RoomPO> pos1 = new ArrayList<RoomPO>();
	ArrayList<RoomPO> pos2 = new ArrayList<RoomPO>();
	ArrayList<RoomPO> pos3 = new ArrayList<RoomPO>();
	
	public RoomDao_Stub() {
		this.pos1.add(new RoomPO("00001", "1109", RoomType.STANDARD_ROOM.ordinal(), 400, true, null));
		this.pos1.add(new RoomPO("00001", "1009", RoomType.SINGLE_ROOM.ordinal(), 250, false, null));
		this.pos1.add(new RoomPO("00001", "1203", RoomType.STANDARD_ROOM.ordinal(), 1200, true, null));
		
		this.pos2.add(new RoomPO("00002", "1109", RoomType.STANDARD_ROOM.ordinal(), 400, true, null));
		this.pos2.add(new RoomPO("00002", "1009", RoomType.SINGLE_ROOM.ordinal(), 200, false, null));
		this.pos2.add(new RoomPO("00002", "1203", RoomType.STANDARD_ROOM.ordinal(), 1200, true, null));
		
		this.pos3.add(new RoomPO("00003", "1109", RoomType.STANDARD_ROOM.ordinal(), 400, true, null));
		this.pos3.add(new RoomPO("00003", "1009", RoomType.SINGLE_ROOM.ordinal(), 400, false, null));
		this.pos3.add(new RoomPO("00003", "1203", RoomType.STANDARD_ROOM.ordinal(), 1200, true, null));
	}

	public RoomPO getRoomInfo(String hotelId, String roomId) {
		if(hotelId == "00002" && roomId == "1109") {
			return pos1.get(0);
		} else if(hotelId == "00002" && roomId == "1009") {
			return pos1.get(1);
		}
		return pos1.get(2);
	}

	public boolean addRoom(RoomPO roomPO) {
		return true;
	}

	public boolean updateRoom(RoomPO roomPO) {
		return true;
	}

	public ArrayList<RoomPO> getHotelRooms(String hotelId) {
		if(hotelId == "00001") {
			return pos1;
		} else if(hotelId == "00002") {
			return pos2;
		}
	
		return pos3;
	}
	

}
