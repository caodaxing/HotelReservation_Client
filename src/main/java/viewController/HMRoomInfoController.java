package viewController;

import java.util.ArrayList;

import Message.RoomType;
import javafx.stage.Stage;
import logicService.hotel.CheckHotelService;
import logicService.order.OrderService;
import logicService.room.RoomService;
import logicService.stub.RoomService_Stub;
import view.right.hotelManager.roomInfo.ExistRooms;
import view.right.hotelManager.roomInfo.First;
import view.right.hotelManager.roomInfo.SetAvailableRooms;
import vo.RoomVO;

public class HMRoomInfoController extends HotelManagerLeftController{
	
	//逻辑层接口
	private RoomService roomService;
	private CheckHotelService checkHotelService;
	private OrderService orderService;
	
	//控制界面
	private First firstUI;
	private SetAvailableRooms setAvailableRoomsUI;
	private ExistRooms existRoomsUI;
	
	private ArrayList<RoomVO> roomList;
	private int remainedNum;
	
	public HMRoomInfoController(Stage stage, String userId){
		
		roomService = new RoomService_Stub();
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
	
	public void setRoomList(){
		roomList = roomService.getRoomList(userId);
	}
	
	public ArrayList<RoomVO> getRoomList(){
		return roomList;
	}
	
	public void setRemainedNum(RoomType roomType){
		remainedNum = roomService.getRemainingRoomNums(userId, roomType);
	}
	
	public int getRemainedNum(){
		return remainedNum;
	}
}
