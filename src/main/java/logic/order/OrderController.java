package logic.order;

import java.util.ArrayList;

import Message.CreditChangeType;
import Message.OrderListCondition;
import Message.ResultMessage;
import factories.OrderListFilterFactory;
import logicService.order.OrderService;
import vo.OrderVO;

/**
 * order处理的controller
 * @author Mark.W
 *
 */
public class OrderController implements OrderService{

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
	
	public ResultMessage judgeCredit (String user_id){
		return order.judgeCredit(user_id);
	}
	
	public ResultMessage changeCredit(String user_id, CreditChangeType change, int number){
		return order.changeCredit(user_id, change, number);
	}
	
	public ArrayList<OrderVO> filterList(String userID, OrderListCondition condition){
		OrderListFilterFactory orderListFilterFactory = OrderListFilterFactory.getInstance();
		filter = orderListFilterFactory.createFilter(condition);
		return filter.filterList(userID);
	}

	@Override
	public String getEvaluationInfo(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage evaluate(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
