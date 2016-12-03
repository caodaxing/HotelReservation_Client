package logic.order;

import dataDao.order.OrderDao;
import dataDao.stub.OrderDao_Stub;
import logic.credit.CreditInfo;
import logic.mockObject.MockCalculatePromotion;
import logic.promotion.PromotionCalculation;
import logic.utility.OrderTransform;
import logicService.order.CreateOrderService;
import po.OrderPO;
import vo.OrderVO;

/**
 * 生成订单
 * @author Mark.W
 *
 */
public class CreateOrder implements CreateOrderService{
	
	private OrderDao orderDao;
	private OrderTransform orderTrans;
	private CreditInfo creditInfo; 
	private PromotionCalculation caculatePromotion;
	
	public CreateOrder() {
		this.orderTrans = new OrderTransform();
		this.orderDao = new OrderDao_Stub();
		this.caculatePromotion = new MockCalculatePromotion();
	}

	@Override
	public OrderVO createOrder(OrderVO o) {
		if(o == null) {
			System.out.println("logic.order.CreateOrder.createOrder参数异常");
			return null;
		} 
		
		OrderVO vo = this.caculatePromotion.calculate(o);
		
		OrderPO po = this.orderTrans.orderTransToPO(vo);
		
		if(!this.orderDao.addOrder(po)) {
			System.out.println("logic.order.CreateOrder.createOrder更新数据库异常");
			return null;
		} 
		
		return vo;
	}

	@Override
	public boolean judgeCreditCanCreateOrder(String userID) {
		if(creditInfo.getCredit(userID) >= 0) {
			return true;
		}
		return false;
	}
	
	
}
