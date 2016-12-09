package logic.mockObject;

import java.util.ArrayList;

import logic.order.OrderHotelInfo;
import vo.EvaluationVO;

public class MockOrderHotelInfo implements OrderHotelInfo {

	public ArrayList<EvaluationVO> getHotelEvaluations(String hotelId){
		return null;
	}

	@Override
	public ArrayList<String> getBookedHotelList(String userID) {
		return null;
	}
	
}
