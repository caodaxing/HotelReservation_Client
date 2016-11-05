package logic.order;

import java.util.ArrayList;

import Message.OrderListCondition;
import vo.OrderVO;

public interface OrderListFilter {
	public abstract ArrayList<OrderVO> filterList(OrderListCondition condition);
}
