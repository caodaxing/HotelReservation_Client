package logic.mockObject;

import java.util.ArrayList;

import Message.OrderState;
import Message.RoomType;
import logic.order.OrderHotelInfo;
import vo.EvaluationVO;
import vo.OrderVO;

public class MockOrderHotelInfo implements OrderHotelInfo {

	ArrayList<OrderVO> orders = new ArrayList<>();
	ArrayList<EvaluationVO> evaluationVOs = new ArrayList<>();
	
	public MockOrderHotelInfo() {
		orders.add(new OrderVO("bcy", "1234", RoomType.STANDARD_ROOM, 1, "123", null, null , OrderState.UNEXECUTED, 2, false, 200, 150, null, null, null, null, null, null));
		evaluationVOs.add(new EvaluationVO("1234", 5, "棒极了"));
	}
	public ArrayList<EvaluationVO> getHotelEvaluations(String hotelId){
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
		ArrayList<String> bookedHotels  = new ArrayList<>();
		for (OrderVO orderVO : orders) {
			if (orderVO.userID==userID) {
				bookedHotels.add(orderVO.hotelID);
			}
		}
		return bookedHotels;
	}
	
}
