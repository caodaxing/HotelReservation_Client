package logicService.order;


import Message.ResultMessage;
import vo.EvaluationVO;
import vo.OrderVO;

public interface OrderService {
	
	public EvaluationVO getEvaluationInfo(String orderId);
	
	public ResultMessage evaluate(String orderId);

	public ResultMessage undoOrder(String order_id);
	
	public OrderVO getOrderInfo(String order_id);
	
}

