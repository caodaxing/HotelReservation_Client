package Stub;

import java.util.ArrayList;

import Interface.OrderDataService;
import PO.OrderPO;
import PO.ResultMessage;

public class OrderDataService_Stub implements OrderDataService {
	
	public ArrayList<OrderPO> getOrderList(int[] orderId) {
		ArrayList<OrderPO> orders=new ArrayList<>();
		orders.add(new OrderPO("2135", "2016.10.16", "234", "2016.10.17", 1, false, 2));
		return orders;
	}
	
	public OrderPO getOrder(int orderId) {
		return new OrderPO("2135", "2016.10.16", "234", "2016.10.17", 1, false, 2);
	}
	
	public ResultMessage undoOrder(int orderId) {
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage generateOrder(OrderPO order){
		return ResultMessage.Add_Success;
	}

}
