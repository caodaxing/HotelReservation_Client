package logic.order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		
		return this.filterList(condition);
	}

	
	//酒店订单筛选的方法
	@Override
	public ArrayList<OrderVO> filterHotelOrderList(String hotelID, OrderListCondition condition) {
		
		if(hotelID == null || condition == null) {
			System.out.println("logic.order.OrderList.filterHotelOrderList参数异常");
			return null;
		}
		
		this.orders = this.orderListDao.getOrderListByHotelID(hotelID);
		
		return this.filterList(condition);
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
	
	
	/**
	 * ManagerOrder.getDailyUnexecutedOrderList和getDailyAbnormalOrderList
	 * 方法的实现在这里方法的实现在这里
	 * @return
	 */
	public ArrayList<OrderVO> filterWebDailyOrderList(OrderListCondition condition) {
		
		this.getAllWebDailyOrders(); //拿到web当天的所有订单
		
		return this.filterList(condition);
	}
	
	
	//确定ArrayList<OrderPO>后，筛选订单的方法，为了避免代码重复，所以建立一个私有方法被调用
	private ArrayList<OrderVO> filterList(OrderListCondition condition) {
		
		this.orderListFilter = this.factory.createFilter(condition);
		
		ArrayList<OrderPO> pos = this.orderListFilter.filterList(orders);
		
		return this.orderTrans.orderListTransToVO(pos);
	}
	
	//获取网站当天所有订单
	private void getAllWebDailyOrders() {
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyyMMdd");
		String time =format.format(date);
		
		this.orders = this.orderListDao.getAllDailyOrders(time);
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}


	public void setOrders(ArrayList<OrderPO> orders) {
		this.orders = orders;
	}
	
	
}
