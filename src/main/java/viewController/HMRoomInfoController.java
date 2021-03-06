package viewController;

import java.util.ArrayList;

import Message.ResultMessage;
import Message.RoomType;
import javafx.stage.Stage;
import logic.order.ExecuteOrder;
import logic.room.Room;
import logicService.order.ExecuteOrderService;
import logicService.room.RoomService;
import view.right.hotelManager.roomInfo.ExistRooms;
import view.right.hotelManager.roomInfo.First;
import view.right.hotelManager.roomInfo.SetAvailableRooms;
import vo.RoomVO;

public class HMRoomInfoController extends HotelManagerLeftController{
	
	//逻辑层接口
	private RoomService roomService;
	
	//控制界面
	private First firstUI;
	private SetAvailableRooms setAvailableRoomsUI;
	private SetAvailableRooms setModifyRoomsUI;
	private ExistRooms existRoomsUI;
	
	
	private ArrayList<RoomVO> roomList;
	private int remainedNum;
	private RoomType roomType;
	
	public HMRoomInfoController(Stage stage, String userId){
		
		super(stage,userId);
		roomService = new Room();
		setAvailableRoomsUI = new SetAvailableRooms(this);
		setModifyRoomsUI = new SetAvailableRooms(this);
		firstUI = new First(this);
		existRoomsUI = new ExistRooms(this);
		
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void setFirstView(){
		stage.setScene(firstUI.getScene());
	}
	
	public void setExistRoomsView(){
		setRoomList();
		existRoomsUI = new ExistRooms(this);
		existRoomsUI.initialData();
		stage.setScene(existRoomsUI.getScene());
	}
	
	public void setSetAvailableRoomsView(){
		stage.setScene(setAvailableRoomsUI.getScene());
	}
	
	public void setModifyRoomsView(){
		setModifyRoomsUI = new SetAvailableRooms(this);
		setModifyRoomsUI.setText();
		stage.setScene(setModifyRoomsUI.getScene());
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
	
	public ResultMessage getUpdateRoomResult(RoomVO roomVO){
		return roomService.updateRoomInfo(roomVO);
	}
	
	public ResultMessage getAddRoomResult(RoomVO roomVO){
		return roomService.addRoomInfo(roomVO);
	}
	
	public void setRoomType(int row){
		roomType = roomList.get(row).roomType;
	}
	
	public RoomType getRoomType(){
		return roomType;
	}
	
	public ResultMessage getModifyRoomResult(RoomVO roomVO){
		return roomService.updateRoomInfo(roomVO);
	}
	
}
