package exception;

public class EncryptPasswordException extends Exception {

	public EncryptPasswordException() {
		super("md5加密出现异常");
	}
	
}
