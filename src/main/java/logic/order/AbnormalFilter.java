package logic.order;

import java.util.ArrayList;

import Message.OrderState;
import po.OrderPO;

/**
 * 筛选异常订单
 * @author Mark.W
 *
 */
public class AbnormalFilter implements OrderListFilter{

	@Override
	public ArrayList<OrderPO> filterList(ArrayList<OrderPO> orders) {

		if(orders == null) {
			return null;
		}
		
		ArrayList<OrderPO> res = new ArrayList<OrderPO>();
		OrderPO po = null;
		
		for(int i=0; i<orders.size(); ++i) {
			po = orders.get(i); 		//有两种已经执行的方式
			if(po.getState() == OrderState.ABNORMAL.ordinal()) {
				res.add(po);
			}
		}
		
		return res;
	}

}
