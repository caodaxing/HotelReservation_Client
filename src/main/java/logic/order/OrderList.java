package logic.order;

import java.util.ArrayList;

import Message.OrderListCondition;
import dataDao.order.OrderListDao;
import dataDao.stub.OrderListDao_Stub;
import factories.OrderListFilterFactory;
import logicService.order.OrderListService;
import vo.OrderVO;

/**
 * 策略模式
 * @author Mark.W
 *
 */
public class OrderList implements OrderListService{
	
	private OrderListFilter orderListFilter;
	private OrderListFilterFactory factory = OrderListFilterFactory.getInstance();
	private OrderListDao orderListDao;
	
	public OrderList() {
		this.orderListDao = new OrderListDao_Stub();
	}

	@Override
	public ArrayList<OrderVO> filterUserOrderList(String userID, OrderListCondition condition) {
		this.orderListFilter = this.factory.createFilter(condition);
		
		return null;
	}

	@Override
	public ArrayList<OrderVO> filterHotelOrderList(String hotelID, OrderListCondition condition) {
		return null;
	}

	//获取预订过的酒店的历史订单列表
	@Override
	public ArrayList<OrderVO> filterOrderList(String userID, String hotelId) {
		return null;
	}

}
