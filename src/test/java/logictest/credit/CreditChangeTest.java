package logictest.credit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Message.CreditChangeType;
import Message.ResultMessage;
import logic.credit.CreditChange;
import vo.CreditChangeVO;

public class CreditChangeTest {

	private CreditChange change;
	
	@Before
	public void setUp() {
		change = new CreditChange("123");
	}
	
	@Test
	public void testChangeCredit1() {
		assertEquals(ResultMessage.SUCCESS, change.changeCredit
				(new CreditChangeVO("123", "2016-12-03 12:34:00", "20161203000213", 
						CreditChangeType.NORMAL_EXECUTE_ORDER_INCRESE, 100)));
	}
	
	@Test
	public void testChangeCredit2(){
		assertEquals(ResultMessage.FAILURE, change.changeCredit
				(new CreditChangeVO(null, "2016-12-03 12:34:00", "20161203000213", 
						CreditChangeType.NORMAL_EXECUTE_ORDER_INCRESE, 100)));
	}
	
	@Test
	public void testChangeCredit3(){
		assertEquals(ResultMessage.SUCCESS, change.changeCredit
				(new CreditChangeVO("123", "2016-12-03 12:34:00", "20161203000213", 
						CreditChangeType.UNDO_ORDER_DECREASE, -100)));
	}
	
}
