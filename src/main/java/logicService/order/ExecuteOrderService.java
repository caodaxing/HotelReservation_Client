package logicService.order;


import Message.ResultMessage;

/**
 * 酒店工作人员执行订单
 * @author Mark.W
 *
 */
public interface ExecuteOrderService {

	/**
	 * 某个订单是否一个已经退房
	 * @param orderID
	 * @return
	 */
	public ResultMessage hasCheckOut(String orderID);
	
	/**
	 * 酒店退房，为了解决双向依赖。将其作为执行单的一部分
	 * @param orderID
	 * @return
	 */
	public ResultMessage checkOut(String orderID);
	
	/**
	 * 客户入住，正常执行订单 需要传入分配的房间id
	 * @param orderID
	 * @param roomID
	 * @return ResultMessage
	 */
	public ResultMessage normalExecute(String orderID, String[] roomID) ;
	
	/**
	 * 客户在最晚执行订单时间后入住，补登记订单 需要传入分配的房间id
	 * @param orderID
	 * @param roomID
	 * @return ResultMessage
	 */
	public ResultMessage supplyOrder(String orderID,  String[] roomID);
	
	/**
	 * 网站营销人员撤销异常订单
	 * @param orderID 
	 * @param recoverAllDeletedCredit 恢复全部信用与否
	 * @return
	 */
	
	/**
	 * 用户撤销未执行订单
	 * @param orderID
	 * @return ResultMessage
	 */
	public ResultMessage undoUnexecutedOrder(String orderID);
	
}
