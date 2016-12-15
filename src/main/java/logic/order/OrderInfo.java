package logic.order;

import Message.ResultMessage;
import vo.OrderVO;

/**
 * 
 * @author Mark.W
 */
public interface OrderInfo {
	public OrderVO getOrderInfo(String orderID);
	
	public ResultMessage updateOrder(OrderVO vo);
}
