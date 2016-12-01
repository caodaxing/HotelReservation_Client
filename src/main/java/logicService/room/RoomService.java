package logicService.room;

import java.util.ArrayList;
import Message.ResultMessage;
import vo.RoomVO;

/**
 * Room的logicservice
 * @author XueWang
 *
 */
public interface RoomService {
	
	public ArrayList<RoomVO> getRoomList(String hotel_id);
	
	public RoomVO getRoomInfo(String hotel_id,String room_id);
	
	public ResultMessage updateRoomInfo(RoomVO roomVO);
	
	public ResultMessage addRoomInfo(RoomVO roomVO);
	
}
