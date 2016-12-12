package logictest.order;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Message.OrderListCondition;
import Message.OrderState;
import logic.order.OrderList;
import vo.OrderVO;

public class OrderListTest {

	private OrderList orderList;
	
	@Before
	public void setUp(){
		this.orderList = new OrderList();
	}
	
	@Test
	public void testFilterUserOrderList1() {
		ArrayList<OrderVO> vos = this.orderList.filterUserOrderList("wyy", OrderListCondition.UNEXECUTED);
		
		assertEquals(vos.size(), 1);
		assertEquals(vos.get(0).orderState, OrderState.UNEXECUTED);
		assertEquals(vos.get(0).orderId, "20161212000041212");
	}
	
	
	@Test
	public void testFilterUserOrderList2() {
		ArrayList<OrderVO> vos = this.orderList.filterUserOrderList("wyy", OrderListCondition.EXECUTED);
		
		assertEquals(vos.size(), 1);
		assertEquals(vos.get(0).orderState, OrderState.EXECUTED);
		assertEquals(vos.get(0).orderId, "20161231000060876");
	}
	
	@Test
	public void testFilterUserOrderList3() {
		ArrayList<OrderVO> vos = this.orderList.filterUserOrderList("wyy", OrderListCondition.ABNORMALED);
		
		assertEquals(vos.size(), 1);
		assertEquals(vos.get(0).orderState, OrderState.ABNORMAL);
		assertEquals(vos.get(0).orderId, "20150214000070886");
	}
	

	@Test
	public void testFilterUserOrderList4() {
		ArrayList<OrderVO> vos = this.orderList.filterUserOrderList("wyy", OrderListCondition.UNDOED);
		
		assertEquals(vos.size(), 1);
		assertEquals(vos.get(0).orderState, OrderState.UNDOED_ABNORMAL);
		assertEquals(vos.get(0).orderId, "20160808000060634");
	}
	
	@Test
	public void testFilterUserOrderList5() {
		ArrayList<OrderVO> vos = this.orderList.filterUserOrderList("wyy", OrderListCondition.ALL_ORDERS);
		
		assertEquals(vos.size(), 4);
		assertEquals(vos.get(0).orderId, "20161231000060876");
		assertEquals(vos.get(1).orderId, "20161212000041212");
		assertEquals(vos.get(2).orderId, "20160808000060634");
		assertEquals(vos.get(3).orderId, "20150214000070886");
	}

	@Test
	public void testFilterHotelOrderList1() {
		ArrayList<OrderVO> vos = this.orderList.filterHotelOrderList("wyy", OrderListCondition.UNEXECUTED);
		
		assertEquals(vos.size(), 1);
		assertEquals(vos.get(0).orderState, OrderState.UNEXECUTED);
		assertEquals("20161212000061212",vos.get(0).orderId);
	}
	
	@Test
	public void testFilterHotelOrderList2() {
		ArrayList<OrderVO> vos = this.orderList.filterHotelOrderList("wyy", OrderListCondition.EXECUTED);
		
		assertEquals(vos.size(), 1);
		assertEquals(vos.get(0).orderState, OrderState.EXECUTED);
		assertEquals(vos.get(0).orderId, "20161231000060876");
	}
	
	
	@Test
	public void testFilterHotelOrderList3() {
		ArrayList<OrderVO> vos = this.orderList.filterHotelOrderList("wyy", OrderListCondition.ABNORMALED);
		
		assertEquals(vos.size(), 1);
		assertEquals(vos.get(0).orderState, OrderState.ABNORMAL);
		assertEquals("20150214000060886", vos.get(0).orderId);
	}

	@Test
	public void testFilterHotelOrderList4() {
		ArrayList<OrderVO> vos = this.orderList.filterHotelOrderList("wyy", OrderListCondition.UNDOED);
		
		assertEquals(vos.size(), 1);
		assertEquals(vos.get(0).orderState, OrderState.UNDOED_ABNORMAL);
		assertEquals(vos.get(0).orderId, "20160808000060634");
	}
	
	@Test
	public void tesFilterSpecificUserHotelOrderList() {
		ArrayList<OrderVO> vos = this.orderList.filterSpecificUserHotelOrderList("wyy", "00006");
		
		assertEquals(vos.size(), 2);
		assertEquals(vos.get(0).orderId, "20161231000060876");
		assertEquals(vos.get(1).orderId, "20160808000060634");
	}
	
	@Test
	public void testFilterWebDailyOrderList() {
		ArrayList<OrderVO> vos = this.orderList.filterWebDailyOrderList(OrderListCondition.ABNORMALED);
		
		assertEquals(vos.size(), 1);
		assertEquals(vos.get(0).orderId, "20150214000190886");
	}


}
