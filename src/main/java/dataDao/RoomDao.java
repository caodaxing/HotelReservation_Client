package dataDao;

import java.util.ArrayList;

import po.RoomPO;

public interface RoomDao {
	
	public RoomPO getRoomInfo(String hotelId, String roomId);
	
	public boolean addRoom(RoomPO roomPO);
	
	public boolean updateRoom(RoomPO po);
	
	public ArrayList<RoomPO> getHotelRooms(String hotelId);
}
