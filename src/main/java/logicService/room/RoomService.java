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
	
	/**
	 * 获取酒店房间列表信息
	 * @param hotelID
	 * @return
	 */
	public ArrayList<RoomVO> getRoomList(String hotelID);
	
	/**
	 * 获取酒店房间信息接口
	 * @param hotelID
	 * @param roomType
	 * @return
	 */
	public RoomVO getRoomInfo(String hotelID, RoomType roomType);
	
	/**
	 * 添加酒店信息
	 * @param roomVO
	 * @return
	 */
	public ResultMessage addRoomInfo(RoomVO roomVO);
	
	/**
	 * 更新房间价格等信息
	 * @param roomVO
	 * @return
	 */
	public ResultMessage updateRoomInfo(RoomVO roomVO);
	
	/**
	 * 获取剩余房间数里
	 * @param hotelID
	 * @param roomType
	 * @return
	 */
	public int getRemainingRoomNums(String hotelID, RoomType roomType);
	
}
