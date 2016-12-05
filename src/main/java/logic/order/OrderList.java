package logic.order;

import java.util.ArrayList;

import Message.OrderListCondition;
import dataDao.order.OrderListDao;
import dataDao.stub.OrderListDao_Stub;
import factories.OrderListFilterFactory;
import logic.utility.OrderTransform;
import logicService.order.OrderListService;
import po.OrderPO;
import vo.OrderVO;

/**
 * 订单列表的筛选类和订单列表接口的实现类
 * @author Mark.W
 *
 */
public class OrderList implements OrderListService{
	
	private OrderListFilter orderListFilter;
	private ArrayList<OrderPO> orders;
	private OrderListFilterFactory factory = OrderListFilterFactory.getInstance();
	private OrderListDao orderListDao;
	private OrderTransform orderTrans;
	
	public OrderList() {
		this.orderListDao = new OrderListDao_Stub();
		this.orderTrans = new OrderTransform();
	}

	
	//用户订单筛选的方法
	@Override
	public ArrayList<OrderVO> filterUserOrderList(String userID, OrderListCondition condition) {
		
		if(userID == null || condition == null) {
			System.out.println("logic.order.OrderList.filterUserOrderList参数异常");
			return null;
		}
		
		this.orders = this.orderListDao.getOrderListByUserId(userID);
		this.orderListFilter = this.factory.createFilter(condition);
		
		return this.orderTrans.orderListTransToVO(this.orderListFilter.filterList(orders));
	}

	
	//酒店订单筛选的方法
	@Override
	public ArrayList<OrderVO> filterHotelOrderList(String hotelID, OrderListCondition condition) {
		
		if(hotelID == null || condition == null) {
			System.out.println("logic.order.OrderList.filterHotelOrderList参数异常");
			return null;
		}
		
		this.orders = this.orderListDao.getOrderListByHotelID(hotelID);
		this.orderListFilter = this.factory.createFilter(condition);
		
		return  this.orderTrans.orderListTransToVO(this.orderListFilter.filterList(orders));
	}

	//获取预订过的酒店的历史订单列表
	@Override
	public ArrayList<OrderVO> filterSpecificUserHotelOrderList(String userID, String hotelID) {
		
		if(hotelID == null || userID == null) {
			System.out.println("logic.order.OrderList.filterSpecificUserHotelOrderList参数异常");
			return null;
		}
		
		
		this.orders = this.orderListDao.getOrderListByUserId(userID);
		
		ArrayList<OrderPO> res = new ArrayList<OrderPO>();
		OrderPO po = null;
		
		for(int i=0; i<orders.size(); ++i) {
			po = orders.get(i);
			
			if(po.getHotelId() == hotelID) {
				res.add(po);
			}
		}
		
		return this.orderTrans.orderListTransToVO(res);
	}
	
	
	
}
