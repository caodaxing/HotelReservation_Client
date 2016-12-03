package viewController;

import logicService.hotel.CheckHotelService;
import logicService.order.OrderService;
import logicService.room.RoomService;
import view.right.hotelManager.roomInfo.First;
import view.right.hotelManager.roomInfo.SetAvailableRooms;

public class HMRoomInfoController {
	
	//逻辑层接口
	private RoomService roomService;
	private CheckHotelService checkHotelService;
	private OrderService orderService;
	
	//控制界面
	private First firstUI;
	private SetAvailableRooms setAvailableRoomsUI;
	
	public HMRoomInfoController(){
		
//		roomService = new Room();
//		checkHotelService = new CheckHotel();
//		orderService = new Order();
		
	}
	
	public void setView(SetAvailableRooms view){
		this.setAvailableRoomsUI = view;
	}
}
