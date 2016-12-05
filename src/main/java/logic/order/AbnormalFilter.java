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

		ArrayList<OrderPO> res = new ArrayList<OrderPO>();
		OrderPO po = null;
		
		for(int i=0; i<orders.size(); ++i) {
			po = orders.get(i); 		//有两种已经执行的方式
			if(po.getState() == OrderState.ABNORMAL.ordinal() || 
					po.getState() == OrderState.ABNORMAL_UNDO_EXECUTED.ordinal()) {
				res.add(po);
			}
		}
		
		return res;
	}

}
