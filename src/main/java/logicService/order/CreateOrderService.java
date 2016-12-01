package logicService.order;

import vo.OrderVO;

public interface CreateOrderService {
	
	public OrderVO createOrder(OrderVO o);
	
	public boolean judgeCreditCanCreateOrder(String user_id);
}
