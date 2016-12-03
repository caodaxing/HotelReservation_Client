package logic.order;

import java.util.ArrayList;

import Message.OrderState;
import po.OrderPO;

/**
 * 筛选已经执行的订单列表
 * @author Mark.W
 *
 */
public class ExecutedFilter implements OrderListFilter{

	@Override
	public ArrayList<OrderPO> filterList(ArrayList<OrderPO> orders) {
		ArrayList<OrderPO> res = new ArrayList<OrderPO>();
		OrderPO po = null;
		
		for(int i=0; i<orders.size(); ++i) {
			po = orders.get(i);
			if(po.getState() == OrderState.EXECUTED.ordinal()) {
				res.add(po);
			}
		}
		
		return res;
	}

}
