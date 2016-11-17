package logic.order;

import java.util.ArrayList;

import message.OrderListCondition;
import vo.OrderVO;

/**
 * 筛选已经执行的订单列表
 * @author Mark.W
 *
 */
public class ExecutedFilter implements OrderListFilter{

	/**
	 * 筛选已经执行的订单列表
	 * @return 指定条件的订单列表
	 * @author Mark.W
	 */
	public ArrayList<OrderVO> filterList() {
		return null;
	}

}
