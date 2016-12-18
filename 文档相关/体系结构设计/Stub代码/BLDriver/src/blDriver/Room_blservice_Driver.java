package blDriver;

import java.util.ArrayList;

import client.businesslogicservice.Room_blservice;
import client.vo.RoomInfoVO;

public class Room_blservice_Driver {
	public void drive(Room_blservice room_blservice , ArrayList<RoomInfoVO> roomInfoVOList){
		System.out.println("This is room_blservice_Driver");
		room_blservice.getRoomInfo(123 , 110);
		room_blservice.updateRoomInfo(roomInfoVOList , 123);
		room_blservice.getHotelRooms(123);
	}
}
