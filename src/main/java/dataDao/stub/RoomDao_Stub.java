package dataDao.stub;

import java.util.ArrayList;
import java.util.HashMap;

import Message.RoomType;
import dataDao.room.RoomDao;
import po.RoomPO;

public class RoomDao_Stub implements RoomDao {

	ArrayList<RoomPO> pos1 = new ArrayList<RoomPO>();
	ArrayList<RoomPO> pos2 = new ArrayList<RoomPO>();
	ArrayList<RoomPO> pos3 = new ArrayList<RoomPO>();
	
	public RoomDao_Stub() {
		HashMap<String, String> n11 = new HashMap<String, String>();
		n11.put("2016-12-15 12:00:00", "2016-12-16 12:00:00");
		n11.put("2016-12-25 12:00:00", "2016-12-26 12:00:00");
		this.pos1.add(new RoomPO("00001", "1109", RoomType.STANDARD_ROOM.ordinal(), 400, n11, null));
		
		HashMap<String, String> n12 = new HashMap<String, String>();
		n12.put("2016-12-25 12:00:00", "2016-12-26 12:00:00");
		this.pos1.add(new RoomPO("00001", "1009", RoomType.STANDARD_ROOM.ordinal(), 250, n12, null));
		
		this.pos1.add(new RoomPO("00001", "1203", RoomType.STANDARD_ROOM.ordinal(), 1200, null, null));
		
		
		HashMap<String, String> n21 = new HashMap<String, String>();
		n21.put("2017-01-01 12:00:00", "2017-01-02 12:00:00");
		this.pos2.add(new RoomPO("00002", "1109", RoomType.STANDARD_ROOM.ordinal(), 400, n21, null));
		
		HashMap<String, String> n22 = new HashMap<String, String>();
		n22.put("2017-01-03 12:00:00", "2017-01-04 12:00:00");
		this.pos2.add(new RoomPO("00002", "1009", RoomType.SINGLE_ROOM.ordinal(), 200, n22, null));
		
		this.pos2.add(new RoomPO("00002", "1203", RoomType.STANDARD_ROOM.ordinal(), 1200, null, null));

		
		HashMap<String, String> n31 = new HashMap<String, String>();
		n31.put("2017-01-07 12:00:00", "2017-01-08 12:00:00");
		this.pos3.add(new RoomPO("00003", "1109", RoomType.STANDARD_ROOM.ordinal(), 400, n31, null));
		
		HashMap<String, String> n32 = new HashMap<String, String>();
		n32.put("2017-01-07 12:00:00", "2017-01-08 12:00:00");
		n32.put("2017-01-02 12:00:00", "2017-01-03 12:00:00");
		this.pos3.add(new RoomPO("00003", "1009", RoomType.SINGLE_ROOM.ordinal(), 400, n32, null));
		
		HashMap<String, String> n33 = new HashMap<String, String>();
		n33.put("2017-01-07 12:00:00", "2017-01-08 12:00:00");
		this.pos3.add(new RoomPO("00003", "1203", RoomType.STANDARD_ROOM.ordinal(), 1200, n33, null));
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
