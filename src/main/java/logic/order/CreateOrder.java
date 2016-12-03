package logic.order;

import logicService.order.CreateOrderService;
import vo.OrderVO;

/**
 * 生成订单
 * @author Mark.W
 *
 */
public class CreateOrder implements CreateOrderService{

	@Override
	public OrderVO createOrder(OrderVO o) {
		return null;
	}

	@Override
	public boolean judgeCreditCanCreateOrder(String user_id) {
		return false;
	}
	
	
}
