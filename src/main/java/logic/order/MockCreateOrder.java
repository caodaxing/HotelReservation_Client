package logic.order;

import Message.ResultMessage;
import vo.OrderVO;

public class MockCreateOrder extends CreateOrder {
	
	public OrderVO createOrder(OrderVO order){
		return null;
	}
	
	public double calculate(Order order){
		return 0;
	}
	
	public ResultMessage judgeCredit(String user_id){
		return ResultMessage.SUCCESS;
	}
}