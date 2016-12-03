package dataDao.stub;

import java.util.ArrayList;

import dataDao.order.OrderDao;
import po.EvaluationPO;
import po.OrderPO;

public class OrderDao_Stub implements OrderDao {

	public ArrayList<OrderPO> getOrderListByUserId(String userID) {
//		OrderPO o1 = new OrderPO("161023000021109", "20161023", "00002", "20161024", 1, false, 2, 0);
//		OrderPO o2 = new OrderPO("160923000230809", "20160923", "00023", "20160924", 1, false, 1, 1);
//		OrderPO o3 = new OrderPO("161018000200203", "20161018", "00002", "20161019", 1, false, 2, 2);
//		OrderPO o4 = new OrderPO("160802000080509", "20160802", "00008", "20160803", 1, false, 2, 3);
//		OrderPO o5 = new OrderPO("160903002020809", "20160903", "00202", "20160904", 1, false, 1, 1);
//		OrderPO o6 = new OrderPO("160726000010303", "20160726", "00001", "20160728", 1, false, 2, 3);
//		OrderPO o7 = new OrderPO("150214000050110", "20150214", "00005", "20150214", 1, false, 2, 1);
//		OrderPO o8 = new OrderPO("150101000070210", "20150101", "00007", "20150102", 1, false, 2, 1);
//		ArrayList<OrderPO> orders = new ArrayList<OrderPO>();
//		orders.add(o1);
//		orders.add(o2);
//		orders.add(o3);
//		orders.add(o4);
//		orders.add(o5);
//		orders.add(o6);
//		orders.add(o7);
//		orders.add(o8);
//		return orders;
		return null;
	}

	public ArrayList<OrderPO> getOrderListByHotelID(String hotelID) {
		return null;
	}

	public ArrayList<OrderPO> getHotelDailyOrders(String hotelID) {
		return null;
	}

	public ArrayList<OrderPO> getAllDailyOrders(String time) {
		return null;
	}

	public boolean updateOrder(OrderPO orderPO) {
		return false;
	}

	public boolean addOrder(OrderPO orderPO) {
		return false;
	}

	public OrderPO getOrderByOrderID(String orderID) {
		return null;
	}
	
	public boolean addEvalution(EvaluationPO po) {
		return false;
	}

	public EvaluationPO getEvaluationByOrderID(String order_id) {
		return null;
	}

	public ArrayList<EvaluationPO> getEvaluationByHotelID(String hotelID) {
		return null;
	}


}
