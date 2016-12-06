package logicService.order;


import Message.ResultMessage;
import vo.EvaluationVO;
import vo.OrderVO;

public interface OrderService {
	
	public EvaluationVO getEvaluationInfo(String orderID);

	public OrderVO getOrderInfo(String orderID);
	
	public ResultMessage evaluate(EvaluationVO evaluation);
	
	
}

