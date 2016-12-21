package logic.order;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Message.OrderListCondition;
import dataDao.order.OrderListDao;
import factories.OrderListFilterFactory;
import logic.utility.OrderTransform;
import logicService.order.OrderListService;
import main.rmi.RemoteHelper;
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
		this.orderTrans = new OrderTransform();
		
		this.orderListDao = RemoteHelper.getInstance().getOrderListDao();
//		this.orderListDao = new OrderListDao_Stub();
	}

	
	//用户订单筛选的方法
	@Override
	public ArrayList<OrderVO> filterUserOrderList(String userID, OrderListCondition condition) {
		
		assert (userID == null || condition == null) : "logic.order.OrderList.filterUserOrderList参数异常";
	
		try {
			this.orders = this.orderListDao.getOrderListByUserId(userID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		ArrayList<OrderVO> vos = this.filterList(condition);
		
		return vos;
	}

	
	//酒店订单筛选的方法
	@Override
	public ArrayList<OrderVO> filterHotelOrderList(String hotelID, OrderListCondition condition) {
		
		assert (hotelID == null || condition == null) : "logic.order.OrderList.filterHotelOrderList参数异常";
		
		try {
			this.orders = this.orderListDao.getOrderListByHotelID(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return this.filterList(condition);
	}

	//获取预订过的酒店的历史订单列表
	@Override
	public ArrayList<OrderVO> filterSpecificUserHotelOrderList(String userID, String hotelID) {
		
		assert (hotelID == null || userID == null) :"logic.order.OrderList.filterSpecificUserHotelOrderList参数异常";
		
		try {
			this.orders = this.orderListDao.getOrderListByUserId(userID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		ArrayList<OrderPO> res = new ArrayList<OrderPO>();
		OrderPO po = null;
		
		for(int i=0; i<orders.size(); ++i) {
			po = orders.get(i);
			
			if(po.getHotelId().equals(hotelID)) {
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
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time =format.format(date);
		
		try {
			this.orders = this.orderListDao.getAllDailyOrders(time);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<OrderPO> getOrders() {
		return orders;
	}


	public void setOrders(ArrayList<OrderPO> orders) {
		this.orders = orders;
	}
	
	
}
