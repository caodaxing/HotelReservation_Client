package logic.order;

import java.util.ArrayList;

import vo.OrderVO;

/**
* 筛选未执行的订单列表
* @author Mark.W
*
*/
public class UnExecutedFilter implements OrderListFilter{

	/**
	 * 筛选未执行的订单列表
	 * @return 未执行的订单列表
	 * @author Mark.W
	 *
	 */
	public ArrayList<OrderVO> filterList(String userID) {
		return null;
	}

}
