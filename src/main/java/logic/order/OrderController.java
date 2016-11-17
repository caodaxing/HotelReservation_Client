package logic.order;

import java.util.ArrayList;

import Message.CreditChange;
import Message.ResultMessage;
import logicService.OrderService;
import vo.EvaluationVO;
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
	
	public EvaluationVO getEvaluation(String order_id){
		return order.getEvaluation(order_id);
	}
	
	public ResultMessage judgeCredit (String user_id){
		return order.judgeCredit(user_id);
	}
	
	public ResultMessage changeCredit(String user_id, CreditChange change, int number){
		return order.changeCredit(user_id, change, number);
	}
	
	public ArrayList<OrderVO> filterList(){
		return filter.filterList();
	}
	
}
