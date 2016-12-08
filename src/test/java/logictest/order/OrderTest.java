package logictest.order;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import logic.order.Order;

public class OrderTest {

	private Order order;
	
	@Before
	public void setUp() {
		this.order = new Order("20161212000041212");
	}
	
	@Test
	public void testGetOrderInfo() {
		assertEquals("2016-12-12 12:00:00", this.order.getOrderInfo("20161212000041212").startTime);
	}
	
	@Test
	public void testGetEvaluationInfo() {
		assertEquals("爽", this.order.getEvaluationInfo("20161212000041212").evaluationContent);
	}
	
	@Test
	public void testGetHotelEvaluations() {
		assertEquals(2, this.order.getHotelEvaluations("00004").size());
		
		assertEquals("不错", this.order.getHotelEvaluations("00004").get(1).evaluationContent);
	}

	
	
}
