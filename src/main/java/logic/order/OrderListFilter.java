package logic.order;

import java.util.ArrayList;

import po.OrderPO;

/**
 * 筛选订单的接口
 * @author Mark.W
 *
 */
public interface OrderListFilter {
	
	public ArrayList<OrderPO> filterList(ArrayList<OrderPO> orders);
}
