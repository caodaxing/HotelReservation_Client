package Stub;

import java.util.ArrayList;

import Interface.OrderBLService;
import VO.OrderVO;
import VO.ResultMessage;
import VO.RoomVO;

public class OrderBLService_Stub implements OrderBLService {
	public ArrayList<OrderVO> getOrderList(int[] orderId) {
		ArrayList<OrderVO> orders = new ArrayList<OrderVO>();
		orders.add(new OrderVO("112379", "20160930", new RoomVO(2, 299, 0, 1124), "20161001", 
				1, 2, false));
		orders.add(new OrderVO("112380", "20160929", new RoomVO(2, 299, 0, 1124), "20160930", 
				0, 3, true));
		return orders;
	}
	
	public OrderVO getOrder(int orderId) {
		return new OrderVO("112379", "20160930", new RoomVO(2, 299, 0, 1124), "20161001", 
				1, 2, false);
	}
	
	public ResultMessage undoOrder(int orderId) {
		return ResultMessage.SUCCESS;
	}
	
	public OrderVO generateOrder(String orderId, String startTime, RoomVO room, String endTime, 
			int state, int numOfPeople,boolean hasChild) {
		return new OrderVO(orderId, startTime, room, endTime, 
			state, numOfPeople, hasChild);
	}
}
