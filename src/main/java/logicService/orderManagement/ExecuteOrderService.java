package logicService.orderManagement;


import Message.ResultMessage;

/**
 * 酒店工作人员执行订单
 * @author Mark.W
 *
 */
public interface ExecuteOrderService {

	/**
	 * 执行正常订单
	 * @param order_id 订单id
	 * @return ResultMessage
	 */
	public ResultMessage normalExecute(String order_id);
	
	/**
	 * 自动设置成异常订单
	 * @param order_id 订单id
	 * @return ResultMessage
	 */
	public ResultMessage autoSetUnnormal(String order_id);
	
	/**
	 * 客户在最晚执行订单时间后入住，补登记订单
	 * @param order_id 订单id
	 * @return ResultMessage
	 */
	public ResultMessage supplyOrder(String order_id);
	
}
