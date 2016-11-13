package logic.orderManagement;

import Message.ResultMessage;
import vo.OrderVO;

public class ManageOrder {
	public ResultMessage undoUnnormalOrder(OrderVO orderVO){
		return ResultMessage.SUCCESS;
	}
}
