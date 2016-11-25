package logictest.accout;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.account.EncryptPassword;

public class EncryptPasswordException {

	@Test
	public void test() {
		String pass1 = "abcdef";
		String pass2 = "abcdef";
		System.out.println(EncryptPassword.toMD5(pass1));
		assertEquals(EncryptPassword.toMD5(pass1), EncryptPassword.toMD5(pass2));
		
		pass1 = "123QWEASDZXC";
		pass2 = "123QWEASDZXC";
		System.out.println(EncryptPassword.toMD5(pass1));
		assertEquals(EncryptPassword.toMD5(pass1), EncryptPassword.toMD5(pass2));
	}

}
