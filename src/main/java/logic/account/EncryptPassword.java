package logic.account;

import java.security.MessageDigest;

public class EncryptPassword {
	
	/**
	 * 给密码进行md5加密
	 * @param passwordToTrans 要转换的密码
	 * @return
	 */
	public static String toMD5(String passwordToTrans) {
		
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
				if (i < 0)	 i += 256;
				if (i < 16)	 buf.append("0");
				buf.append(Integer.toHexString(i));
			}
		} catch (Exception e) {
			System.out.println("md5加密出现异常");
			
		}
		
		return buf.toString();
	}
	
	
//	private String baseSalt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
//			+ "abcdefghijklmnopqrstuvwxyz1234567890";
//	private int baseSaltLength = baseSalt.length();
//	private int saltLength = 4;
//	
	
	
//	public String getSalt() {
//		StringBuffer salt = new StringBuffer("");
//		
//		for(int i=0; i<this.saltLength; ++i) {
//			Random r = new Random();
//			int ranNum = r.nextInt(this.baseSaltLength);
//			salt.append(this.baseSalt.charAt(ranNum));
//		}
//		
//		return salt.toString();
//	}

}
