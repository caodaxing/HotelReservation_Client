package logictest.credit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import logic.credit.Credit;

public class CreditTest {

	private Credit credit;
	
	@Before
	public void setUp(){
		credit = new Credit();
	}	
	@Test
	public void testGetCredit1() {
		assertEquals(1700, credit.getCredit("wyy"));
	}
	
	@Test
	public void testGetCredit2() {
		assertEquals(800, credit.getCredit("bcy"));
	}

	@Test
	public void testGetVipCredit() {
		assertEquals(0, credit.getVIPCredit(0));
		assertEquals(1000, credit.getVIPCredit(1));
		assertEquals(4000, credit.getVIPCredit(2));
		assertEquals(80000, credit.getVIPCredit(3));
	}
}
