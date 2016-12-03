package dataDao.stub;

import java.util.ArrayList;

import dataDao.order.OrderListDao;
import po.OrderPO;

public class OrderListDao_Stub implements OrderListDao{

	@Override
	public ArrayList<OrderPO> getOrderListByUserId(String userID) {
		return null;
	}

	@Override
	public ArrayList<OrderPO> getOrderListByHotelID(String hotelID) {
		return null;
	}

	@Override
	public ArrayList<OrderPO> getHotelDailyOrders(String hotelID) {
		return null;
	}

	@Override
	public ArrayList<OrderPO> getAllDailyOrders(String time) {
		return null;
	}

}
