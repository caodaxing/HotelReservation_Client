package logic.orderManagement;

import Message.ResultMessage;
import vo.OrderVO;

/**
 * 管理人员撤销异常订单
 * @author Mark.W
 *
 */
public class ManageOrder{
	
	public ManageOrder(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	OrderInfo orderInfo;
	
	/**
	 * 撤销异常订单
	 * @param orderVO
	 * @return ResultMessage
	 */
	public ResultMessage undoUnnormalOrder(OrderVO orderVO){
		return ResultMessage.SUCCESS;
	}
}
