package logic.order;

import java.util.ArrayList;

import Message.CreditChangeType;
import Message.ResultMessage;
import logic.credit.CreditInfo;
import logicService.order.OrderService;
import vo.EvaluationVO;
import vo.OrderVO;

/**
 * 订单处理类
 * @author Mark.W
 *
 */
public class Order implements OrderService{
	
	CreateOrder createOrder;
	CreditInfo credit;
	
	public Order(){}
	
	public EvaluationVO getEvaluationInfo(String orderId){
		return null;
	}
	
	public ResultMessage evaluate(String orderId){
		return null;
	}
	
	/**
	 * 撤销订单 
	 * @param order_id 订单id
	 * @return ResultMessage
	 */
	public ResultMessage undoOrder(String order_id){
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 获取订单信息 
	 * @param order_id 订单id
	 * @return ordervo
	 */
	public OrderVO getOrderInfo(String order_id){
		return null;
	}
	
	/**
	 * 得到评价
	 * @param order_id 订单id
	 * @return 评价String类
	 */
	public String getEvaluation(String order_id){
		return null;
	}
	
	/**
	 * 判断是否可以下订单
	 * @param user_id 用户id
	 * @return ResultMessage
	 */
	public ResultMessage judgeCredit(String user_id){
		credit.getCredit(user_id);
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 改变信用值
	 * @param order_id 订单id
	 * @return ResultMessage
	 */
	public ResultMessage changeCredit(String user_id, CreditChangeType change, int number){
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 获得指定用户的所有订单
	 * @param user_id 用户id
	 * @return ResultMessage
	 */
	public ArrayList<Order> getOrderList(String user_id){
		return null;
	}
	
	/**
	 * 生成订单
	 * @param ordervo
	 * @return ordervo
	 */
	public OrderVO createOrder(OrderVO order){
		return createOrder.createOrder(order);
	}
	
}


