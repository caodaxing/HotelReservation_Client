package logic.order;

import java.util.ArrayList;

import po.OrderPO;

/**
 * 筛选撤销的订单列表
 * @author Mark.W
 *
 */
public class UndoedFilter implements OrderListFilter{

	@Override
	public ArrayList<OrderPO> filterList(ArrayList<OrderPO> orders) {
		return null;
	}

}
