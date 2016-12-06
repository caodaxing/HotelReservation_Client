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
	
	public ResultMessage undoAbnormalOrder(String orderID, boolean recoverAllCredit);
	
	public ArrayList<OrderVO> getWebDailyUnexecutedOrderList();
	
	public ArrayList<OrderVO> getWebDailyAbnormalOrderList();
	
}
