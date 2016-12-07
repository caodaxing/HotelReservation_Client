package logic.mockObject;

import java.util.ArrayList;

import logic.order.OrderEvaluationInfo;
import vo.EvaluationVO;

public class MockOrderEvaluationInfo implements OrderEvaluationInfo {

	public ArrayList<EvaluationVO> getHotelEvaluations(String hotelId){
		return null;
	}
	
}
