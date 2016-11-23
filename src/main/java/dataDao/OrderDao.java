package dataDao;

import java.util.ArrayList;

import po.OrderPO;

public interface OrderDao {
	
	public ArrayList<OrderPO> getOrderListByUserId(String userID);
}
