package logicService.room;

import java.util.ArrayList;

import Message.ResultMessage;
import Message.RoomType;
import vo.RoomVO;

/**
 * Room的logicservice
 * @author XueWang
 *
 */
public interface RoomService {
	
	public ArrayList<RoomVO> getRoomList(String hotelID);
	
	//更新房间价格等信息
	public ResultMessage updateRoomInfo(RoomVO roomVO);
	
	public ResultMessage addRoomInfo(RoomVO roomVO);
	
	public int getRemainingRoomNums(String hotelID, RoomType roomType);
	
}
