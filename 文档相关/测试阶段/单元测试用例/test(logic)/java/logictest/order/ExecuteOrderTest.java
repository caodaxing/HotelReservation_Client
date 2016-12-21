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
		String[] roomIds = {"1109", "1108"};
		assertEquals(ResultMessage.SUCCESS, this.executeOrder.normalExecute("20161212000041212", roomIds));
		
		assertEquals(OrderState.EXECUTED.ordinal(), this.executeOrder.getPo().getState());
		
		assertEquals("1108", this.executeOrder.getPo().getRoomIDs()[1]);
		
		assertEquals(time, this.executeOrder.getPo().getCheckInTime().substring(0, 10));
		
	}	
	
//	@Test
//	public void testAutoSetAbnormal() {
//		assertEquals(ResultMessage.SUCCESS, this.executeOrder.autoSetAbnormal("20161212000041212"));
//		
//		assertEquals(OrderState.ABNORMAL.ordinal(), this.executeOrder.getPo().getState());
//		
//		assertEquals(time, this.executeOrder.getPo().getAbnormalTime().substring(0, 10));
//	}	

	@Test
	public void testSupplyOrderl() {
		String[] roomIds = {"109", "108"};
		assertEquals(ResultMessage.FAILURE, this.executeOrder.supplyOrder("20161212000041212",roomIds));
		
	}
	
	//测试正常补登记
	@Test
	public void testSupplyOrder2() {
		String[] roomIds = {"709", "708"};
		
		assertEquals(ResultMessage.SUCCESS, this.executeOrder.supplyOrder("20170101000240001", roomIds));
		
		assertEquals(2, this.executeOrder.getPo().getRoomIDs().length);
		
		assertEquals(OrderState.EXECUTED.ordinal(), this.executeOrder.getPo().getState());
		
		assertEquals(time, this.executeOrder.getPo().getCheckInTime().substring(0, 10));
	}	


	@Test
	public void testUndoAbnormalOrderl() {
		assertEquals(ResultMessage.FAILURE, this.executeOrder.undoAbnormalOrder("20161212000041212", true));
	}	
	
	@Test
	public void testUndoAbnormalOrder2() {
		assertEquals(ResultMessage.SUCCESS, this.executeOrder.undoAbnormalOrder("20170101000240001", true));
		
		assertEquals(OrderState.UNDOED_ABNORMAL.ordinal(), this.executeOrder.getPo().getState());
		
		assertEquals(time, this.executeOrder.getPo().getUndoAbnormalTime().substring(0, 10));
	}	
	
	
	
	
	//不会扣除信用
	@Test
	public void testUndoUnexecutedOrder() {
		assertEquals(ResultMessage.SUCCESS, this.executeOrder.undoUnexecutedOrder("20161212000041212"));
		
		assertEquals(OrderState.UNDOED_UNEXECUTED.ordinal(), this.executeOrder.getPo().getState());
		
		assertEquals(time, this.executeOrder.getPo().getUndoUnexecutedTime().substring(0, 10));
		
	}
	
}
