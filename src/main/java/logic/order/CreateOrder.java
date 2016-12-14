package logic.order;

import java.rmi.RemoteException;

import Message.OrderState;
import dataDao.order.OrderDao;
import dataDao.stub.OrderDao_Stub;
import logic.credit.Credit;
import logic.credit.CreditInfo;
import logic.promotion.CalculatePromotion;
import logic.promotion.CalculationPromotionInfo;
import logic.utility.OrderTransform;
import logicService.order.CreateOrderService;
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
	
	
	public CreateOrder() {
		this.orderTrans = new OrderTransform();
		this.creditInfo = new Credit();
		this.caculatePromotionInfo = new CalculatePromotion();
		
		this.orderDao = new OrderDao_Stub();
	}

	
	@Override
	public OrderVO createOrder(OrderVO o) {
		if(o == null) {
			System.out.println("logic.order.CreateOrder.createOrder参数异常");
			return null;
		} 
		

		//生成订单的id
		int num = this.orderDao.getOrderNum();
		String orderID = o.startTime.substring(0, 10) + String.format("%06d", num);
		o.orderId = orderID;
		
		
		OrderVO vo = this.caculatePromotionInfo.calculatePromotion(o);
		
		vo.orderState = OrderState.UNEXECUTED;
		
		OrderPO po = this.orderTrans.orderTransToPO(vo);
		
		boolean success = false;
		try {
			success = this.orderDao.addOrder(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(success) {
			return vo;
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
