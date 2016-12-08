package logictest.order;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Message.OrderState;
import Message.ResultMessage;
import logic.order.ExecuteOrder;

public class ExecuteOrderTest {

	private ExecuteOrder executeOrder;
	
	@Before
	public void setUp() {
		this.executeOrder = new ExecuteOrder();
	}
	
	@Test
	public void testNormalExecute() {
		assertEquals(ResultMessage.SUCCESS, this.executeOrder.normalExecute("20161212000041212"));
		
		assertEquals(OrderState.EXECUTED.ordinal(), this.executeOrder.getPo().getState());
		
		assertEquals("2016-12-08", this.executeOrder.getPo().getExecutedTime().substring(0, 10));
		
	}	
	
	@Test
	public void testAutoSetAbnormal() {
		assertEquals(ResultMessage.SUCCESS, this.executeOrder.autoSetAbnormal("20161212000041212"));
		
		assertEquals(OrderState.ABNORMAL.ordinal(), this.executeOrder.getPo().getState());
		
		assertEquals("2016-12-08", this.executeOrder.getPo().getAbnormalTime().substring(0, 10));
	}	

	@Test
	public void testSupplyOrderl() {
		assertEquals(ResultMessage.FAILURE, this.executeOrder.supplyOrder("20161212000041212"));
		
	}
	
	//测试正常补登记
	@Test
	public void testSupplyOrder2() {
		assertEquals(ResultMessage.SUCCESS, this.executeOrder.supplyOrder("20160101000240001"));
		
		
		assertEquals(OrderState.EXECUTED.ordinal(), this.executeOrder.getPo().getState());
		
		assertEquals("2016-12-08", this.executeOrder.getPo().getExecutedTime().substring(0, 10));
	}	


	@Test
	public void testUndoAbnormalOrderl() {
		assertEquals(ResultMessage.FAILURE, this.executeOrder.undoAbnormalOrder("20161212000041212", true));
	}	
	
	@Test
	public void testUndoAbnormalOrder2() {
		assertEquals(ResultMessage.SUCCESS, this.executeOrder.undoAbnormalOrder("20160101000240001", true));
		
		assertEquals(OrderState.UNDOED.ordinal(), this.executeOrder.getPo().getState());
		
		assertEquals("2016-12-08", this.executeOrder.getPo().getUndoAbnormalTime().substring(0, 10));
		
	}	
	
}
