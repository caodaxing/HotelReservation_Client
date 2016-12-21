package logicService.order;

import vo.OrderVO;

/**
 * 生成订单的接口
 * @author Mark.W
 *
 */
public interface CreateOrderService {
	
	public OrderVO createOrder(OrderVO o);
	
	public boolean judgeCreditCanCreateOrder(String user_id);
}
