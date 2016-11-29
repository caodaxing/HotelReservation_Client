package vo;
/**
 * @param userID 用户ID
 * @param trueName 真实姓名
 * @param phoneNumber 电话
 * @param numberOfIdentityCard 身份证号码
 * @author bcy
 *
 */
public class WebBusinessVO {
	
	public String userID;
	public String trueName;
	public String phoneNumber;
	public String numberOfIdentityCard;
	
	public WebBusinessVO(String userID,String trueName,String phoneNumber,String numberOfIdentityCard) {
		this.userID=userID;
		this.trueName=trueName;
		this.phoneNumber=phoneNumber;
		this.numberOfIdentityCard=numberOfIdentityCard;
	}

}
