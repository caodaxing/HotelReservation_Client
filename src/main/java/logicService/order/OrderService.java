package logicService.order;

import java.util.ArrayList;

import Message.CreditChangeType;
import Message.OrderListCondition;
import Message.ResultMessage;
import vo.EvaluationVO;
import vo.OrderVO;

public interface OrderService {
	public EvaluationVO getEvaluationInfo(String orderId);
	
	public ResultMessage evaluate(String orderId);
	
	public OrderVO createOrder(OrderVO o);
	
	public ResultMessage undoOrder(String order_id);
	
	public OrderVO getOrderInfo(String order_id);
	
	public String getEvaluation(String order_id);
	
	public ResultMessage judgeCredit (String user_id);
	
	public ResultMessage changeCredit(String user_id, CreditChangeType change, int number);

	public ArrayList<OrderVO> filterList(String userID, OrderListCondition conditon);
	
}

