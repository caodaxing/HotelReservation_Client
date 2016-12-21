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
	
	/**
	 * 撤销异常订单
	 * @param orderID
	 * @param recoverAllCredit
	 * @return
	 */
	public ResultMessage undoAbnormalOrder(String orderID, boolean recoverAllCredit);
	
	/**
	 * 获取网站每天未执行订单
	 * @return 订单列表
	 */
	public ArrayList<OrderVO> getWebDailyUnexecutedOrderList();
	
	/**
	 * 获取网站每天异常订单
	 * @return 订单列表
	 */
	public ArrayList<OrderVO> getWebDailyAbnormalOrderList();
	
}
