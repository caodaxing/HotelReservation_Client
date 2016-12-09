package dataDao.stub;

import java.util.ArrayList;

import dataDao.order.OrderDao;
import po.EvaluationPO;
import po.OrderPO;

public class OrderDao_Stub implements OrderDao {

	@Override
	public boolean addOrder(OrderPO orderPO) {
		return true;
	}

	@Override
	public boolean updateOrder(OrderPO orderPO) {
		return true;
	}

	@Override
	public OrderPO getOrderByOrderID(String orderID) {
	
		if(orderID == "20161212000041212") {
			ArrayList<String> rooms = new ArrayList<String>();
			rooms.add("1109");
			
			ArrayList<String> promotions = new ArrayList<String>();
			promotions.add("ppp");
			
			return new OrderPO("wyy", "20161212000041212", "green", "2016-12-12 12:00:00",
					"2016-12-13 12:00:00", 1, rooms, false, 1, 0, 300, 240, 1, promotions, null, null, null);
		} else {
			ArrayList<String> rooms = new ArrayList<String>();
			rooms.add("1109");
			
			ArrayList<String> promotions = new ArrayList<String>();
			promotions.add("ppp");
			
			return new OrderPO("wyy", "20160101000240001", "green", "2016-01-01 12:00:00",
					"2016-01-02 12:00:00", 1, rooms, false, 1, 2, 300, 240, 1, promotions, null, null, null);
		}
	
	}

	@Override
	public boolean addEvalution(EvaluationPO po) {
		return true;
	}

	@Override
	public EvaluationPO getEvaluationByOrderID(String orderID) {
		return new EvaluationPO("20161212000041212", 4.6, "爽");
	}

	@Override
	public ArrayList<EvaluationPO> getEvaluationByHotelID(String hotelID) {
		ArrayList<EvaluationPO> pos = new ArrayList<EvaluationPO>();
		pos.add(new EvaluationPO("20161212000041212", 4.6, "爽"));
		pos.add(new EvaluationPO("20161010000041001", 4.1, "不错"));
		return pos;
	}

	@Override
	public ArrayList<String> getBookedHotelList(String userID) {
		return null;
	}
}