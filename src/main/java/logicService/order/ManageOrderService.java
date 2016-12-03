package logicService.order;

import java.util.ArrayList;

import Message.ResultMessage;
import vo.OrderVO;
/**
 * 网站营销人员管理订单
 * @author Mark.W
 *
 */
public interface ManageOrderService {
	
	public ResultMessage undoUnnormalOrder(String orderID, boolean recoverAllCredit);
	
	public ArrayList<OrderVO> getDailyUnexecutedOrderList();
	
	public ArrayList<OrderVO> getDailyAbnormalOrderList();
	
}
