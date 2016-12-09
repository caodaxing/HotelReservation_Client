package logic.order;

import java.util.ArrayList;

import vo.EvaluationVO;

/**
 * order提供给hotel的接口
 * @author Mark.W
 *
 */
public interface OrderHotelInfo {

	public ArrayList<EvaluationVO> getHotelEvaluations(String hotelID);
	
	public ArrayList<String> getBookedHotelList (String userID);
}
