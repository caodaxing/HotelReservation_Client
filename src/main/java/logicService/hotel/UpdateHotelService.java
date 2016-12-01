package logicService.hotel;

import Message.ResultMessage;
import vo.HotelVO;

/**
 * 更新酒店信息的接口, 
 * 酒店管理人员会更新酒店信息，所以单独分出来这个接口
 * @author Mark.W
 *
 */
public interface UpdateHotelService {
	
	public ResultMessage updateHotelInfo(HotelVO hotelVO);
	
}

