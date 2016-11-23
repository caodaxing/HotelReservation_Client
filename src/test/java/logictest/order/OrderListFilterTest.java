package logictest.order;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import logic.order.AbnormaledFilter;
import logic.order.ExecutedFilter;
import logic.order.OrderListFilter;
import logic.order.UnExecutedFilter;
import logic.order.UndoedFilter;

/**
 * 这个测试需要用到orderdao的stub
 */
public class OrderListFilterTest {

	private OrderListFilter orderListFilter;
	
	@Test
	public void testAbnormaledFilter() {
		orderListFilter = new AbnormaledFilter();
		assertEquals(orderListFilter.filterList("hhhh").size(), 1);
	}
	
	@Test
	public void testExecutedFilter() {
		orderListFilter = new ExecutedFilter();
		assertEquals(orderListFilter.filterList("hhhh").size(), 4);
	}

	@Test
	public void testUnExecutedFilter() {
		orderListFilter = new UnExecutedFilter();
		assertEquals(orderListFilter.filterList("hhhh").size(), 1);
	}
	
	@Test
	public void testUndoedFilter() {
		orderListFilter = new UndoedFilter();
		assertEquals(orderListFilter.filterList("hhhh").size(), 2);
	}
}
