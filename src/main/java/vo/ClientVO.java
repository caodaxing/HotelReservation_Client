package vo;

/**
 * @param userID 用户id
 * @param phoneNumber 电话
 * @param trueName 真实姓名
 * @param identityID 身份证号
 * @param credit 信用值 
 * @author bcy
 */
public class ClientVO {
	
	public String userID;
	public String phoneNumber;
	public String trueName;
	public String identityID;
	public int credit;

	/**
	 * @param userID
	 * @param phoneNumber
	 * @param trueName
	 * @param identityID
	 * @param credit
	 * @param headImagePath
	 */
	public ClientVO(String userID, String phoneNumber, String trueName, 
			String identityID, int credit) {
		this.userID = userID;
		
		if(phoneNumber == null) {
			this.phoneNumber = "";
		} else {
			this.phoneNumber = phoneNumber;
		}
		
		if(trueName == null) {
			this.trueName = "";
		} else {
			this.trueName = trueName;
		}
		
		if(identityID == null) {
			this.identityID = "";
		} else {
			this.identityID = identityID;
		}
		
		this.credit = credit;
	}
	
	
}