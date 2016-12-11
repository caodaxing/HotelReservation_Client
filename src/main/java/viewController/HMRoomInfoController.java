package viewController;

import javafx.stage.Stage;
import logicService.hotel.CheckHotelService;
import logicService.order.OrderService;
import logicService.room.RoomService;
import view.right.hotelManager.roomInfo.ExistRooms;
import view.right.hotelManager.roomInfo.First;
import view.right.hotelManager.roomInfo.SetAvailableRooms;

public class HMRoomInfoController extends HotelManagerLeftController{
	
	private Stage stage;
	
	//逻辑层接口
	private RoomService roomService;
	private CheckHotelService checkHotelService;
	private OrderService orderService;
	
	//控制界面
	private First firstUI;
	private SetAvailableRooms setAvailableRoomsUI;
	private ExistRooms existRoomsUI;
	
	public HMRoomInfoController(Stage stage, String userId){
		
//		roomService = new Room();
//		checkHotelService = new CheckHotel();
//		orderService = new Order();
		this.stage = stage;
		this.userId = userId;
		
		firstUI = new First(this);
		setAvailableRoomsUI = new SetAvailableRooms(this);
		existRoomsUI = new ExistRooms(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setFirstView(){
		stage.setScene(firstUI.getScene());
	}
	
	public void setSetAvailableRoomsView(){
		stage.setScene(setAvailableRoomsUI.getScene());
	}
	
	public void setExistRoomsView(){
		stage.setScene(existRoomsUI.getScene());
	}
}
