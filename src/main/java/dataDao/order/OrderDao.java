package dataDao.order;

import java.util.ArrayList;

import po.EvaluationPO;
import po.OrderPO;

public interface OrderDao {
	
	public boolean addOrder(OrderPO orderPO);
	
	public boolean updateOrder(OrderPO orderPO);
	
	public OrderPO getOrderByOrderID(String orderID);
	
	public boolean addEvaluation(EvaluationPO po);
	
	public EvaluationPO getEvaluationByOrderID(String orderID);
	
	public ArrayList<EvaluationPO> getEvaluationByHotelID(String hotelID);
	
	public ArrayList<String> getBookedHotelList (String userID);
}
