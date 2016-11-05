package logic.order;

import java.util.ArrayList;

import Message.CreditChange;
import Message.OrderListCondition;
import Message.ResultMessage;
import vo.OrderVO;

public class OrderController {

	Order order;
	OrderListFilter filter;
	
	public OrderVO createOrder(OrderVO o){
		return order.createOrder(o);
	}
	
	public ResultMessage undoOrder(String order_id){
		return order.undoOrder(order_id);
	}
	
	public OrderVO getOrderInfo(String order_id){
		return order.getOrderInfo(order_id);
	}
	
	public String getEvaluation(String order_id){
		return order.getEvaluation(order_id);
	}
	
	public int getCredit (String user_id){
		return order.getCredit(user_id);
	}
	
	public ResultMessage changeCredit(String user_id, CreditChange change, int number){
		return order.changeCredit(user_id, change, number);
	}
	
	public ArrayList<OrderVO> filterList(OrderListCondition condition){
		return filter.filterList(condition);
	}
	
}
