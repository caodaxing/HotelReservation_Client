package logic.order;

import java.util.ArrayList;

import vo.EvaluationVO;

public interface OrderEvaluationInfo {

	public ArrayList<EvaluationVO> getHotelEvaluations(String hotelID);
}
