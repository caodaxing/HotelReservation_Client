package logicService.order;

import java.util.ArrayList;

import Message.OrderListCondition;
import Message.ResultMessage;
import vo.EvaluationVO;
import vo.OrderVO;

public interface OrderService {
	
	public EvaluationVO getEvaluationInfo(String orderId);
	
	public ResultMessage evaluate(String orderId);

	public ResultMessage undoOrder(String order_id);
	
	public OrderVO getOrderInfo(String order_id);
	
	public ArrayList<OrderVO> filterList(String userID, OrderListCondition conditon);
	
	//获取预订过的酒店的历史订单列表
	public ArrayList<OrderVO> filterList(String userID, String hotelId);
	
}

