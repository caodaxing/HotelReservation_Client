package logic.order;

import Message.ResultMessage;
import logic.credit.CreditInfo;
import logic.promotion.JudgePromotion;
import vo.OrderVO;

/**
 * 生成订单
 * @author Mark.W
 *
 */
public class CreateOrder {
	private JudgePromotion promotion;
	private CreditInfo credit;
	
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
	
	/**
	 * 判断用户是否能够下单
	 * @param 用户id
	 * @return ResultMessage类
	 * @author Mark.W
	 */
	public ResultMessage judgeCredit(String user_id){
		int cre = credit.getCredit(user_id);
		
		return ResultMessage.SUCCESS;
	}
}
