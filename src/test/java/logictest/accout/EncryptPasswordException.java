package logictest.accout;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import logic.utility.Encryption;

public class EncryptPasswordException {

	private Encryption encryption;
	
	@Before
	public void setUp() {
		encryption = Encryption.getInstance();
	}
	
	
	@Test
	public void test() {
		String pass1 = "abcdef";
		String pass2 = "abcdef";
		assertEquals(encryption.encryptPassword(pass1), encryption.encryptPassword(pass2));
		
		pass1 = "123QWEASDZXC";
		pass2 = "123QWEASDZXC";
		assertEquals(encryption.encryptPassword(pass1), encryption.encryptPassword(pass2));
	}

}
