package logic.order;

import java.rmi.RemoteException;

import Message.OrderState;
import Message.ResultMessage;
import dataDao.order.OrderDao;
import logic.credit.Credit;
import logic.credit.CreditInfo;
import logic.hotel.CheckHotel;
import logic.hotel.HotelInfo;
import logic.promotion.CalculatePromotion;
import logic.promotion.CalculationPromotionInfo;
import logic.room.UpdateRoom;
import logic.utility.OrderTransform;
import logic.utility.Time;
import logicService.order.CreateOrderService;
import main.rmi.RemoteHelper;
import po.OrderPO;
import vo.OrderVO;

/**
 * 生成订单接口的实现类
 * @author Mark.W
 *
 */
public class CreateOrder implements CreateOrderService{
	
	private OrderDao orderDao;
	private OrderTransform orderTrans;
	private CreditInfo creditInfo; 
	private CalculationPromotionInfo caculatePromotionInfo;
	private HotelInfo info;
	private UpdateRoom updateRoom;

	
	public CreateOrder() {
		this.orderTrans = new OrderTransform();
		this.creditInfo = new Credit();
		this.caculatePromotionInfo = new CalculatePromotion();
		this.info = new CheckHotel();
		this.updateRoom = new UpdateRoom();
		
		this.orderDao = RemoteHelper.getInstance().getOrderDao();
//		this.orderDao = new OrderDao_Stub();
	}

	
	@Override
	public OrderVO createOrder(OrderVO o) {
		
		assert(o == null) :"logic.order.CreateOrder.createOrder参数异常";

		//不接受超过一个月的预订
		if(o.startTime != null && o.startTime != "") {
			if(new Time(o.startTime).calculateDay(Time.getCurrentTime()) > 30) {
				return null;
			}
		}
		
		//生成订单的id
		int num = 0;
		try {
			num = this.orderDao.getOrderNum();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		String orderID = o.startTime.substring(2, 4) + o.startTime.substring(5, 7) + o.startTime.substring(8,10) + String.format("%05d", num);
		o.orderId = orderID;
		
		//获取价格
		o.beforePrice = info.getRoomPrice(o.hotelID, o.roomType) * o.roomNum;
		o.afterPrice = o.beforePrice;
		
	
		o = this.caculatePromotionInfo.calculatePromotion(o);
		
		o.orderState = OrderState.UNEXECUTED;
		
		OrderPO po = this.orderTrans.orderTransToPO(o);
		
		boolean success = false;
		try {
			success = this.orderDao.addOrder(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(success) {
	
			//生成订单成功 更新房间数量信息,changeNum传入负数，表示房间数减少
			if(ResultMessage.SUCCESS == this.updateRoom.updateRoom(o.hotelID, o.roomType, -o.roomNum)) {
				return o;
			}
	
System.out.println("logic.order.createOrder更新房间数量有问题");
			return null;
		} else {
System.out.println("logic.order.CreateOrder.createOrder更新数据库异常");
			return null;
		}
	}

	

	@Override
	public boolean judgeCreditCanCreateOrder(String userID) {
		if(creditInfo.getCredit(userID) >= 0) {
			return true;
		}
		return false;
	}
	
	
}
