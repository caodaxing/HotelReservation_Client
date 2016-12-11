package logic.hotel;

import Message.ResultMessage;
import vo.HotelVO;

/**
 * 给user用的接口
 * @author Mark.W
 *
 */
public interface AddHotelInfo {

	public ResultMessage addHotel(HotelVO vo);
}
