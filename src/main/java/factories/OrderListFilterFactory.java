package factories;

import Message.OrderListCondition;
import logic.order.AbnormalFilter;
import logic.order.AllOrdersFilter;
import logic.order.ExecutedFilter;
import logic.order.OrderListFilter;
import logic.order.UnExecutedFilter;
import logic.order.UndoedFilter;

public class OrderListFilterFactory {
	private static OrderListFilterFactory orderListFilterFactory;
	
	public static OrderListFilterFactory getInstance() {
		if(orderListFilterFactory == null) {
			orderListFilterFactory = new OrderListFilterFactory();
		}
		return orderListFilterFactory;
	}
	
	public OrderListFilter createFilter(OrderListCondition condition) {
		OrderListFilter filter = null;
		
		switch(condition) {
		case UNDO_UNEXECUTED :
			filter = new UndoedFilter();
			break;
		case UNEXECUTED :
			filter = new UnExecutedFilter();
			break;
		case EXECUTED :
			filter = new ExecutedFilter();
			break;
		case ABNORMALED :
			filter = new AbnormalFilter();
			break;
		case ALL_ORDERS :
			filter = new AllOrdersFilter();
			break;
		default:
			System.out.println("factories.OrderListFactory.createFilter参数异常");
			break;
		}
		
		return filter;
	}
	
}
