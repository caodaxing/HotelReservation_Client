package logictest.accout;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Message.Identity;
import Message.ResultMessage;
import logic.account.Account;
import vo.AccountVO;

public class AcccoutTest {

	private AccountVO accountVO;
	private Account account;
	
	@Before
	public void setUp(){
		accountVO = new AccountVO("curry", "currycurry", Identity.ClIENT);
		account = new Account();
	}	
	
	@Test
	public void testLogin1() {
		assertEquals(ResultMessage.UNMATCHED_PASSWORD, 
				account.login(new AccountVO("curry", "curryc", Identity.ClIENT)));
		assertEquals(ResultMessage.USERNAME_NOT_EXIST, 
				account.login(new AccountVO("curr", "currycurry", Identity.ClIENT)));	
	}
	
	@Test
	public void testLogin2() {
		assertEquals(ResultMessage.SUCCESS, account.login(accountVO));
		assertEquals(accountVO.user_id, account.getUser_id());
		assertEquals(accountVO.password, account.getPassword());
		assertEquals(accountVO.identity, account.getIdentity(accountVO));	
	}
	

	@Test
	public void testLogout() {
	}
	
	@Test
	public void testRegister() {
		AccountVO vo1 = new AccountVO("curry", "ccccc", Identity.ClIENT);
		AccountVO vo2 = new AccountVO("mark", "mmmmm", Identity.ClIENT);
		assertEquals(ResultMessage.FAILURE, account.register(vo1));
		assertEquals(ResultMessage.SUCCESS, account.register(vo2));
	}
	
	@Test
	public void testModifyPassword() {
		AccountVO vo1 = new AccountVO("curry", "ccccc", Identity.ClIENT);
		AccountVO vo2 = new AccountVO("curry", "currycurry", "cuuu", Identity.ClIENT);
		assertEquals(ResultMessage.UNMATCHED_PASSWORD, account.modifyPassword(vo1));
		assertEquals(ResultMessage.SUCCESS, account.modifyPassword(vo2));
	}
}
