package logic.room;

import java.util.ArrayList;

import Message.RoomType;
import vo.RoomVO;

/**
 * 为hotel提供的获取房间信息的接口
 * @author Mark.W
 *
 */
public interface RoomInfo {
	public RoomVO getRoomInfo(String hotel_id,String room_id);
	
	public ArrayList<RoomVO> getRoomList(String hotelID);
	
	public int getSpcificTimeRemainingRoomNums(String hotelId, RoomType roomType, String t);
	
}
