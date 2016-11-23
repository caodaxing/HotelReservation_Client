package logic.stub;

import java.util.ArrayList;

import Message.CreditChange;
import Message.OrderListCondition;
import Message.ResultMessage;
import logicService.OrderService;
import vo.OrderVO;

public class OrderService_Stub implements OrderService {

	public OrderVO createOrder(OrderVO o) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage undoOrder(String order_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVO getOrderInfo(String order_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEvaluation(String order_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage judgeCredit(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage changeCredit(String user_id, CreditChange change, int number) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderVO> filterList(String userID, OrderListCondition condition) {
		// TODO Auto-generated method stub
		return null;
	}
//	public ArrayList<OrderVO> getOrderList(int[] orderId) {
//		ArrayList<OrderVO> orders = new ArrayList<OrderVO>();
//		orders.add(new OrderVO("112379", "20160930", new RoomVO(2, 299, 0, 1124), "20161001", 
//				1, 2, false));
//		orders.add(new OrderVO("112380", "20160929", new RoomVO(2, 299, 0, 1124), "20160930", 
//				0, 3, true));
//		return orders;
//	}
//	
//	public OrderVO getOrder(int orderId) {
//		return new OrderVO("112379", "20160930", new RoomVO(2, 299, 0, 1124), "20161001", 
//				1, 2, false);
//	}
//	
//	public ResultMessage undoOrder(int orderId) {
//		return ResultMessage.SUCCESS;
//	}
//	
//	public OrderVO generateOrder(String orderId, String startTime, RoomVO room, String endTime, 
//			int state, int numOfPeople,boolean hasChild) {
//		return new OrderVO(orderId, startTime, room, endTime, 
//			state, numOfPeople, hasChild);
//	}
}
