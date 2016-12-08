package dataDao.order;

import java.util.ArrayList;

import po.OrderPO;

public interface OrderListDao {
	
	public ArrayList<OrderPO> getOrderListByUserId(String userID);
	
	public ArrayList<OrderPO> getOrderListByHotelID(String hotelID);
	
	public ArrayList<OrderPO> getAllDailyOrders(String time);
}
