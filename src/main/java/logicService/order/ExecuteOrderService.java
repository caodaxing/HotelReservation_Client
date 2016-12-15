package logicService.order;


import Message.ResultMessage;

/**
 * 酒店工作人员执行订单
 * @author Mark.W
 *
 */
public interface ExecuteOrderService {

	
	public ResultMessage checkOut(String orderID);
	/**
	 * //客户入住，正常执行订单
	 * @param order_id 订单id
	 * @return ResultMessage
	 */
	public ResultMessage normalExecute(String orderID, String roomID) ;
	
	/**
	 * 客户在最晚执行订单时间后入住，补登记订单
	 * @param order_id 订单id
	 * @return ResultMessage
	 */
	public ResultMessage supplyOrder(String orderID,  String roomID);
	
	/**
	 * 网站营销人员撤销异常订单
	 * @param orderID 
	 * @param recoverAllDeletedCredit 恢复全部信用与否
	 * @return
	 */
	
	//用户撤销未执行订单
	public ResultMessage undoUnexecutedOrder(String orderID);
	
}
