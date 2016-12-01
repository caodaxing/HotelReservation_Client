package dataDao;

import java.util.ArrayList;

import po.EvaluationPO;
import po.OrderPO;

public interface OrderDao {
	
	public ArrayList<OrderPO> getOrderListByUserId(String userID);
	
	public ArrayList<OrderPO> getOrderListByHotelID(String hotelID);
	
	public ArrayList<OrderPO> getHotelDailyOrders(String hotelID);
	
	public ArrayList<OrderPO> getAllDailyOrders(String time);
	
	public boolean updateOrder(OrderPO orderPO);
	
	public boolean addOrder(OrderPO orderPO);
	
	public OrderPO getOrderByOrderID(String orderID);
	
	public boolean addEvalution(EvaluationPO po);
	
	public EvaluationPO getEvaluationByOrderID(String order_id);
	
	public ArrayList<EvaluationPO> getEvaluationByHotelID(String hotelID);
	
}
