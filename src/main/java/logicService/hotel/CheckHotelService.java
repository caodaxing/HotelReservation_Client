package logicService.hotel;

import java.util.ArrayList;

import Message.ResultMessage;
import vo.EvaluationVO;
import vo.HotelVO;
import vo.RoomVO;

/**
 * 查看酒店信息的接口
 * @author Mark.W
 *
 */
public interface CheckHotelService {

	public HotelVO getHotelnfo(String hotel_id);
	
	public ResultMessage updateRoom(RoomVO room);
	
	public ArrayList<EvaluationVO> getHotelEvaluations(String hotelid);
}
