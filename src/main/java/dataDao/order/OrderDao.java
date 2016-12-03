package dataDao.order;

import java.util.ArrayList;

import po.EvaluationPO;
import po.OrderPO;

public interface OrderDao {
	public boolean updateOrder(OrderPO orderPO);
	
	public boolean addOrder(OrderPO orderPO);
	
	public OrderPO getOrderByOrderID(String orderID);
	
	public boolean addEvalution(EvaluationPO po);
	
	public EvaluationPO getEvaluationByOrderID(String order_id);
	
	public ArrayList<EvaluationPO> getEvaluationByHotelID(String hotelID);
	
}
