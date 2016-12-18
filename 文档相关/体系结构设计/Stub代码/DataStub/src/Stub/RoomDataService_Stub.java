package Stub;

import java.util.ArrayList;

import Interface.RoomDataService;
import PO.ResultMessage;
import PO.RoomPO;

public class RoomDataService_Stub implements RoomDataService {
	
	public RoomPO returnRoomInfo(int hotelId,int roomId) {
		return new RoomPO("A", 123, true, 20, null);
	}
	
	public ResultMessage retupdateRoomInfo(ArrayList<RoomPO>rooms,int hotelId) {
		return ResultMessage.SUCCESS;
	}
	
	public ArrayList<RoomPO> returnHotelRooms(int hotelId) {
		ArrayList<RoomPO> roomPOs=new ArrayList<>();
		roomPOs.add(new RoomPO("A", 123, true, 20, null));
		roomPOs.add(new RoomPO("B", 250, true, 10, null));
		return roomPOs;
	}
}
