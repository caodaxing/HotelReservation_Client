package logic.order;

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
		
		OrderVO vo = this.caculatePromotionInfo.calculatePromotion(o);
		
		vo.orderState = OrderState.UNEXECUTED;
		
		OrderPO po = this.orderTrans.orderTransToPO(vo);
		
		if(this.orderDao.addOrder(po)) {
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
