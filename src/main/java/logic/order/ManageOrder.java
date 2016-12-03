package logic.order;

import java.util.ArrayList;

import Message.ResultMessage;
import dataDao.order.OrderListDao;
import logicService.order.ManageOrderService;
import vo.OrderVO;

/**
 * 管理人员撤销异常订单
 * @author Mark.W
 *
 */
public class ManageOrder implements ManageOrderService{
	
	private OrderListDao orderListDao;
	
	// 撤销异常订单
	@Override
	public ResultMessage undoUnnormalOrder(String orderID, boolean recoverAllCredit) {
		return null;
	}

	@Override
	public ArrayList<OrderVO> getDailyUnexecutedOrderList() {
		return null;
	}

	@Override
	public ArrayList<OrderVO> getDailyAbnormalOrderList() {
		return null;
	}
}
