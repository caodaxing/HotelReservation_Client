package logic.order;

import java.util.ArrayList;

import Message.OrderListCondition;
import Message.ResultMessage;
import logicService.order.ManageOrderService;
import vo.OrderVO;

/**
 * 管理人员撤销异常订单
 * 采用委托 ，委托给其他类来实现方法，为了不重复在不同的类中出现相同接口的调用
 * @author Mark.W
 *
 */
public class ManageOrder implements ManageOrderService{
	
	private ExecuteOrder executeOrder;
	private OrderList orderList;
	
	public ManageOrder() {
		this.executeOrder = new ExecuteOrder();
		this.orderList = new OrderList();
	}


	// 撤销异常订单 
	@Override
	public ResultMessage undoAbnormalOrder(String orderID, boolean recoverAllDeletedCredit) {
		return this.executeOrder.undoAbnormalOrder(orderID, recoverAllDeletedCredit);
	}
	

	@Override
	public ArrayList<OrderVO> getWebDailyUnexecutedOrderList() {
		return this.orderList.filterWebDailyOrderList(OrderListCondition.UNEXECUTED);
	}

	@Override
	public ArrayList<OrderVO> getWebDailyAbnormalOrderList() {
		return this.orderList.filterWebDailyOrderList(OrderListCondition.ABNORMALED);
	}
}
