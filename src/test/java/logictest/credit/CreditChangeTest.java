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
		change = new CreditChange();
	}
	
	@Test
	public void testChangeCredit1() {
		assertEquals(ResultMessage.SUCCESS, change.changeCredit
				(new CreditChangeVO("wyy", "2016-12-03 12:34:00", "20161203000213", CreditChangeType.NORMAL_EXECUTE_ORDER_INCRESE, 100)));
		
//		assertEquals(1, this.change.judgeVipLevelChange("wyy", 2100));
//		
//		assertEquals(0, this.change.judgeVipLevelChange("wyy", 900));
//		
//		assertEquals(3, this.change.judgeVipLevelChange("wyy", 90000));
	}
	
	@Test
	public void testChangeCredit2(){
		assertEquals(ResultMessage.FAILURE, change.changeCredit(new CreditChangeVO(null, "2016-12-03 12:34:00", "20161203000213", 
						CreditChangeType.NORMAL_EXECUTE_ORDER_INCRESE, 100)));
	}
	
	@Test
	public void testChangeCredit3(){
		assertEquals(ResultMessage.SUCCESS, change.changeCredit(new CreditChangeVO("bcy", "2016-12-03 12:34:00", "20161203000213", 
						CreditChangeType.UNDO_ABNORAML_ORDER_RECOVER, -100)));
	}
	
}
