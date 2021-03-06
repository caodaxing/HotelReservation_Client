package logictest.accout;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Message.Identity;
import Message.ResultMessage;
import logic.account.Account;
import vo.AccountVO;

public class AcccoutTest {

	private Account account;
	
	@Before
	public void setUp(){
		account = new Account();
	}	

	
	
	@Test
	public void testLogin1() {
		assertEquals(ResultMessage.UNMATCHED_PASSWORD, 
				account.login(new AccountVO("curry", "currycurry", Identity.CLIENT)));
	}
	
	@Test
	public void testLogin2() {
		assertEquals(ResultMessage.UNMATCHED_PASSWORD, account.login(new AccountVO("wyy",
				"e80b5017098950fc58aad83c8c14978e", Identity.CLIENT)));
	}

	@Test
	public void testLogin3() {
		assertEquals(ResultMessage.FAILURE, account.login(new AccountVO(null, null, null)));
	}
	
	@Test
	public void testLogin4() {
		assertEquals(ResultMessage.SUCCESS, account.login(new AccountVO("wyy", 
				"6f6e37133b6207ef6a02aa64224a97ac", Identity.CLIENT)));
	}
	
	@Test
	public void testRegister1() {
		AccountVO vo1 = new AccountVO("curry", "ccccc", Identity.CLIENT);
		assertEquals(ResultMessage.SUCCESS, account.register(vo1));
	}
	
	@Test
	public void testRegister2() {
		AccountVO vo2 = new AccountVO("mark", "mmmmm", Identity.CLIENT);
		assertEquals(ResultMessage.SUCCESS, account.register(vo2));
	}
	
	
	@Test
	public void testModifyPassword1() {
		assertEquals(ResultMessage.FAILURE, account.modifyPassword(new AccountVO(null,  null, null)));
	}
	
	@Test
	public void testModifyPassword2() {
		AccountVO vo2 = new AccountVO("curry", "currycurry", Identity.CLIENT);
		assertEquals(ResultMessage.SUCCESS, account.modifyPassword(vo2));
	}
	
	@Test
	public void testModifyPassword3() {
		AccountVO vo1 = new AccountVO("curry", "ccccc", Identity.CLIENT);
		assertEquals(ResultMessage.SUCCESS, account.modifyPassword(vo1));
	}
}
