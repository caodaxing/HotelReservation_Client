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
		assertEquals(ResultMessage.SUCCESS, account.login(new AccountVO("curry",
				"e80b5017098950fc58aad83c8c14978e", Identity.CLIENT)));
	}
	
//	@Test
//	public void testLogin3() {
//		assertEquals(ResultMessage.USERNAME_NOT_EXIST, 
//			account.login(new AccountVO("curr", "currycurry", Identity.ClIENT)));
//	}

	@Test
	public void testLogout1() {
		assertEquals(ResultMessage.FAILURE, account.login(new AccountVO(null, null, null)));
	}
	
	@Test
	public void testLogout2() {
		assertEquals(ResultMessage.SUCCESS, account.login(new AccountVO("curry", 
				"e80b5017098950fc58aad83c8c14978e", Identity.CLIENT)));
	}
	
	@Test
	public void testRegister1() {
		AccountVO vo1 = new AccountVO("curry", "ccccc", "cc", Identity.CLIENT);
		assertEquals(ResultMessage.UNMATCHED_PASSWORD, account.register(vo1));
	}
	
	@Test
	public void testRegister2() {
		AccountVO vo2 = new AccountVO("mark", "mmmmm", "mmmmm", Identity.CLIENT);
		assertEquals(ResultMessage.SUCCESS, account.register(vo2));
	}
	
	
	@Test
	public void testModifyPassword1() {
		assertEquals(ResultMessage.FAILURE, account.modifyPassword(new AccountVO(null, null, null, null)));
	}
	
	@Test
	public void testModifyPassword2() {
		AccountVO vo2 = new AccountVO("curry", "currycurry", "cuuu", Identity.CLIENT);
		assertEquals(ResultMessage.UNMATCHED_PASSWORD, account.modifyPassword(vo2));
	}
	
	@Test
	public void testModifyPassword3() {
		AccountVO vo1 = new AccountVO("curry", "ccccc", "ccccc", Identity.CLIENT);
		assertEquals(ResultMessage.SUCCESS, account.modifyPassword(vo1));
	}
}
