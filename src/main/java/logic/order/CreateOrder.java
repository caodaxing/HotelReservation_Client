package logic.order;

import Message.ResultMessage;
import vo.OrderVO;

public class CreateOrder {
	/**
	 * 生成订单
	 * @param order 传入的vo信息
	 * @return 返回生成的订单完成信息的vo
	 * @author Mark.W
	 */
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
