package Stub;

import java.util.ArrayList;

import Interface.RoomBLService;
import VO.ResultMessage;
import VO.RoomVO;

public class RoomBLService_Stub implements RoomBLService {
	public RoomVO getRoomInfo(int hotelId, int roomId){
		return new RoomVO(1, 299, 0, 1123);
	}
	
	public ResultMessage retupdateRoomInfo(ArrayList<RoomVO> rooms, int hotelId) {
		return ResultMessage.SUCCESS;
	}
	
	public ArrayList<RoomVO> returnHotelRooms(int hotelId) {
		ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
		rooms.add(new RoomVO(1, 299, 0, 1123));
		rooms.add(new RoomVO(2, 299, 0, 1124));
		return rooms;
	}
}
