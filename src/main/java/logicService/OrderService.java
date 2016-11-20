package logicService;

import java.util.ArrayList;

import Message.CreditChange;
import Message.ResultMessage;
import vo.EvaluationVO;
import vo.OrderVO;

public interface OrderService {
	public OrderVO createOrder(OrderVO o);
	
	public ResultMessage undoOrder(String order_id);
	
	public OrderVO getOrderInfo(String order_id);
	
	public String getEvaluation(String order_id);
	
	public ResultMessage judgeCredit (String user_id);
	
	public ResultMessage changeCredit(String user_id, CreditChange change, int number);

	public ArrayList<OrderVO> filterList();
	
}
