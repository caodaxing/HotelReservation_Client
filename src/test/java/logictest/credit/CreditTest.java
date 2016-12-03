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
		assertEquals(1, credit.getCredit("123"));
	}
	
	@Test
	public void testGetCredit2() {
		assertEquals(100, credit.getCredit("1234"));
	}

}
