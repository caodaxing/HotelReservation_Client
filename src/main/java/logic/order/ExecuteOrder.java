package logic.order;

import Message.ResultMessage;
import dataDao.order.OrderDao;
import dataDao.stub.OrderDao_Stub;
import logicService.order.ExecuteOrderService;
import vo.EvaluationVO;

/**
 * 执行订单
 * @author Mark.W
 *
 */
public class ExecuteOrder implements ExecuteOrderService{
	
	private OrderDao orderDao;
	
	public ExecuteOrder() {
		this.orderDao = new OrderDao_Stub();
	}

	@Override
	public ResultMessage normalExecute(String order_id) {
		
		
		return null;
	}

	@Override
	public ResultMessage autoSetUnnormal(String order_id) {
		return null;
	}

	@Override
	public ResultMessage supplyOrder(String order_id) {
		return null;
	}

	@Override
	public ResultMessage evaluate(EvaluationVO evaluation) {
		return null;
	}
	
	
}
