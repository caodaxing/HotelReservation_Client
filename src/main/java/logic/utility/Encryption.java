package logic.utility;

import java.security.MessageDigest;

import vo.AccountVO;

/**
 * 加密用户账号，姓名，身份证号，联系方式。
 * 可以解密 加密用户密码，不可解密 单例模式
 * @author Mark.W
 */
public class Encryption {

	private static Encryption encryption;

	public static Encryption getInstance() {
		if (encryption == null) {
			encryption = new Encryption();
		}
		return encryption;
	}

	public AccountVO encrypt(AccountVO accountVO) {
		accountVO.userId = this.encryptUserInfo(accountVO.userId);
		accountVO.password = this.encryptPassword(accountVO.password);
		accountVO.confirmedPassword = this.encryptPassword(accountVO.confirmedPassword);
		
		return accountVO;
	}
	
//	public ClientVO encrypy(ClientVO clientVO) {
//		clientVO.userID = this.encryptUserInfo(clientVO.userID);
//		clientVO.trueName = this.encryptUserInfo(clientVO.trueName);
//		clientVO.phoneNumber = this.encryptUserInfo(clientVO.phoneNumber);
//		clientVO.identityID = this.encryptUserInfo(clientVO.identityID);
//		
//		return clientVO;
//	}
	
	/**
	 * 给密码进行md5加密
	 * @param passwordToTrans 要转换的密码
	 * @return
	 */
	public String encryptPassword(String passwordToTrans) {
		
		if(passwordToTrans == null) {
			return null;
		}

		MessageDigest md = null;
		byte[] b = null;
		StringBuffer buf = null;

		try {
			// 生成实现指定摘要算法的 MessageDigest 对象。
			md = MessageDigest.getInstance("MD5");
			// 使用指定的字节数组更新摘要。
			md.update(passwordToTrans.getBytes());
			// 通过执行诸如填充之类的最终操作完成哈希计算。
			b = md.digest();
			// 生成具体的md5密码到buf数组

			int i = 0;
			buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
		} catch (Exception e) {
			System.out.println("md5加密出现异常");

		}

		return buf.toString();
	}
	
	
	public String decryptUserInfo(String passwordToDecrypt) {
		return passwordToDecrypt;
	}
	
	private String encryptUserInfo(String info) {
		return info;
	}
	
//	private byte[] desEncrypt(byte[] src, byte[] enKey) {
//		byte[] encryptedData = null;
//		try {
//			DESedeKeySpec dks = new DESedeKeySpec(enKey);
//			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
//			SecretKey key = keyFactory.generateSecret(dks);
//			Cipher cipher = Cipher.getInstance("DESede");
//			cipher.init(Cipher.ENCRYPT_MODE, key);
//			encryptedData = cipher.doFinal(src);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return encryptedData;
//	}
//	
//	private String deCrypt(byte[] debase64, String spKey) {
//		String strDe = null;
//		Cipher cipher = null;
//		try {
//			cipher = Cipher.getInstance("DESede");
//			byte[] key = getEnKey(spKey);
//			DESedeKeySpec dks = new DESedeKeySpec(key);
//			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
//			SecretKey sKey = keyFactory.generateSecret(dks);
//			cipher.init(Cipher.DECRYPT_MODE, sKey);
//			byte ciphertext[] = cipher.doFinal(debase64);
//			strDe = new String(ciphertext, "UTF-16LE");
//		} catch (Exception ex) {
//			strDe = "";
//			ex.printStackTrace();
//		}
//		return strDe;
//	}
	
	

}
