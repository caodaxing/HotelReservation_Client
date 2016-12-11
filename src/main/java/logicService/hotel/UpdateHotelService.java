package logicService.hotel;

import Message.ResultMessage;
import vo.HotelVO;
import vo.RoomVO;

/**
 * 更新酒店信息和酒店房间信息的接口, 
 * 酒店管理人员会更新酒店信息，所以单独分出来这个接口
 * @author Mark.W
 *
 */
public interface UpdateHotelService {
	
	public ResultMessage hotelHasManager(String hotelID);
	
	public ResultMessage hotelIDExist(String hotelID);
	
	public ResultMessage addHotel(HotelVO hotelVO);
	
	public ResultMessage updateHotelInfo(HotelVO hotelVO);
	
}

