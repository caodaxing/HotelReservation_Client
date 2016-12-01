package logicService.hotel;

import java.util.ArrayList;

import vo.EvaluationVO;
import vo.HotelVO;

/**
 * 查看酒店信息的接口
 * @author Mark.W
 *
 */
public interface CheckHotelService {

	public HotelVO getHotelnfo(String hotel_id);
	
	public ArrayList<EvaluationVO> getHotelEvaluations(String hotelId);
	
}
