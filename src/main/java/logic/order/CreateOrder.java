package logic.order;

import logic.credit.CreditInfo;
import logic.promotion.JudgePromotion;
import logicService.order.CreateOrderService;
import vo.OrderVO;

/**
 * 生成订单
 * @author Mark.W
 *
 */
public class CreateOrder implements CreateOrderService{
	private CreditInfo credit;
	private JudgePromotion promotion;
	
	public CreateOrder(JudgePromotion promotion, CreditInfo credit){
		this.promotion = promotion;
		this.credit = credit;
	}
	
	/**
	 * 生成订单
	 * @param order 传入的vo信息
	 * @return 返回生成的订单完成信息的vo
	 * @author Mark.W
	 */
	public OrderVO createOrder(OrderVO order){
		return null;
	}
	
	/**
	 * 生成订单时计算优惠
	 * @param order对象
	 * @return 计算完成后的订单价钱
	 * @author Mark.W
	 */
	public double calculate(OrderVO order){
		return promotion.calculate(order);
	}

	@Override
	public boolean judgeCreditCanCreateOrder(String user_id) {
		int cre = credit.getCredit(user_id);
		return false;
	}
}
