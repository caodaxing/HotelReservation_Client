package logic.order;

import java.util.ArrayList;

import po.OrderPO;

/**
* 筛选未执行的订单列表
* @author Mark.W
*
*/
public class UnExecutedFilter implements OrderListFilter{

	@Override
	public ArrayList<OrderPO> filterList(ArrayList<OrderPO> orders) {
		return null;
	}

}
