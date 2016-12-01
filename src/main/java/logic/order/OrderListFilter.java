package logic.order;

import java.util.ArrayList;

import vo.OrderVO;

/**
 * 筛选订单的接口
 * @author Mark.W
 *
 */
public interface OrderListFilter {
	public ArrayList<OrderVO> filterList(String userID);
}
