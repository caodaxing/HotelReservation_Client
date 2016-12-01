package logicService.hotel;

import Message.ResultMessage;
import vo.HotelVO;

/**
 * 更新酒店信息的接口
 * @author Mark.W
 *
 */
public interface UpdateHotelService {
	
	public ResultMessage updateHotelInfo(HotelVO hotelVO);
	
}

