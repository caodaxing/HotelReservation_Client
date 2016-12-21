package logicService.order;


import Message.ResultMessage;
import vo.EvaluationVO;
import vo.OrderVO;

/**
 * 有关订单信息获取的接口
 * @author Mark.W
 *
 */
public interface OrderService {
	
	/**
	 * 获取订单评价信息
	 * @param orderID
	 * @return
	 */
	public EvaluationVO getEvaluationInfo(String orderID);

	/**
	 * 获取订单信息
	 * @param orderID
	 * @return
	 */
	public OrderVO getOrderInfo(String orderID);
	
	/**
	 * 评价已经执行的订单
	 * @param evaluation
	 * @return
	 */
	public ResultMessage evaluate(EvaluationVO evaluation);
}
