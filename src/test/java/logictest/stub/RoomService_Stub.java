package logictest.stub;

import java.util.ArrayList;

import Message.ResultMessage;
import logicService.RoomService;
import vo.RoomVO;

public class RoomService_Stub implements RoomService {

	public ArrayList<RoomVO> getRoomList(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public RoomVO getRoomInfo(String hotel_id, String room_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateRoomInfo(RoomVO roomVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addRoomInfo(RoomVO roomVO) {
		// TODO Auto-generated method stub
		return null;
	}
//	public RoomVO getRoomInfo(int hotelId, int roomId){
//		return new RoomVO(1, 299, 0, 1123);
//	}
//	
//	public ResultMessage retupdateRoomInfo(ArrayList<RoomVO> rooms, int hotelId) {
//		return ResultMessage.SUCCESS;
//	}
//	
//	public ArrayList<RoomVO> returnHotelRooms(int hotelId) {
//		ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
//		rooms.add(new RoomVO(1, 299, 0, 1123));
//		rooms.add(new RoomVO(2, 299, 0, 1124));
//		return rooms;
//	}
}
