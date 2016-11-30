//package driver;
//
//import java.util.ArrayList;
//
//import Message.ResultMessage;
//import logicService.RoomService;
//import vo.RoomVO;
//
///**
// * RoomBLService 的 Driver
// * @author XueWang
// */
//public class RoomDriver {
//	
//	public void drive(RoomService roomService){
//		
//		System.out.println("This is roomServiceDriver");
//	
//		ArrayList<RoomVO> list = roomService.getRoomList("119");
//		for(RoomVO r : list){
//			System.out.println(r);
//		}
//		
//		RoomVO room = roomService.getRoomInfo("119", "110");
//		System.out.println(room);
//		
//		RoomVO roomVO = new RoomVO(1,2,3,"222");
//		ResultMessage result0 = roomService.addRoomInfo(roomVO);
//		if(result0 == ResultMessage.SUCCESS){
//			System.out.println("Add success");
//		}else if(result0 == ResultMessage.FAILURE){
//			System.out.println("Add fail");
//		}else{
//			System.out.println("Error");
//		}
//		
//		ResultMessage result1 = roomService.updateRoomInfo(roomVO);
//		if(result1 == ResultMessage.SUCCESS){
//			System.out.println("Update success");
//		}else if(result1 == ResultMessage.FAILURE){
//			System.out.println("Update fail");
//		}else{
//			System.out.println("Error");
//		}
//		
//	}
//
//}
