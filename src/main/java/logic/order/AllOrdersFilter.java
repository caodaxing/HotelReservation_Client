package logic.order;

import java.util.ArrayList;

import po.OrderPO;

public class AllOrdersFilter implements OrderListFilter {

	@Override
	public ArrayList<OrderPO> filterList(ArrayList<OrderPO> orders) {
		return orders;
	}

}
