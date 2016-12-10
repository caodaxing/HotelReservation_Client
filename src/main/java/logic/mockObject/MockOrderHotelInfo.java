package logic.mockObject;

import java.util.ArrayList;

import logic.order.OrderHotelInfo;
import po.OrderPO;
import vo.EvaluationVO;
import vo.OrderVO;

public class MockOrderHotelInfo implements OrderHotelInfo {

	ArrayList<OrderVO> orders = new ArrayList<>();
	
	public MockOrderHotelInfo() {
		orders.add(new OrderVO("bcy", "1234", null, null, "123", null, null, 2, false, 200, 150, null, null, null, null));
	}
	public ArrayList<EvaluationVO> getHotelEvaluations(String hotelId){
		ArrayList<EvaluationVO> evaluationVOs = new ArrayList<>();
		evaluationVOs.add(new EvaluationVO("123", 5, "棒极了"));
		ArrayList<EvaluationVO> returnEvaluations = new ArrayList<>();
		for (OrderVO orderVO : orders) {
			if (orderVO.hotelID==hotelId) {
				for (EvaluationVO evaluationVO : evaluationVOs) {
					if(evaluationVO.orderID==orderVO.orderId){
						returnEvaluations.add(evaluationVO);
					}
				}
			}
		}
		
		return returnEvaluations;
	}

	@Override
	public ArrayList<String> getBookedHotelList(String userID) {
		return null;
	}
	
}
