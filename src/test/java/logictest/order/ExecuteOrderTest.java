package logictest.order;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Message.OrderState;
import Message.ResultMessage;
import logic.order.ExecuteOrder;

public class ExecuteOrderTest {

	private ExecuteOrder executeOrder;
	private String time;
	
	@Before
	public void setUp() {
		this.executeOrder = new ExecuteOrder();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		time =format.format(new Date());
	}
	
	@Test
	public void testNormalExecute() {
		assertEquals(ResultMessage.SUCCESS, this.executeOrder.normalExecute("20161212000041212"));
		
		assertEquals(OrderState.EXECUTED.ordinal(), this.executeOrder.getPo().getState());
		
		assertEquals(time, this.executeOrder.getPo().getExecutedTime().substring(0, 10));
		
	}	
	
	@Test
	public void testAutoSetAbnormal() {
		assertEquals(ResultMessage.SUCCESS, this.executeOrder.autoSetAbnormal("20161212000041212"));
		
		assertEquals(OrderState.ABNORMAL.ordinal(), this.executeOrder.getPo().getState());
		
		assertEquals(time, this.executeOrder.getPo().getAbnormalTime().substring(0, 10));
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
		
		assertEquals(time, this.executeOrder.getPo().getExecutedTime().substring(0, 10));
	}	


	@Test
	public void testUndoAbnormalOrderl() {
		assertEquals(ResultMessage.FAILURE, this.executeOrder.undoAbnormalOrder("20161212000041212", true));
	}	
	
	@Test
	public void testUndoAbnormalOrder2() {
		assertEquals(ResultMessage.SUCCESS, this.executeOrder.undoAbnormalOrder("20160101000240001", true));
		
		assertEquals(OrderState.UNDOED.ordinal(), this.executeOrder.getPo().getState());
		
		assertEquals(time, this.executeOrder.getPo().getUndoAbnormalTime().substring(0, 10));
		
	}	
	
}
