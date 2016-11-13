package po;

public class WebmarketstaffPO {
	String nameOfUser;
	String password;
	boolean canCheck;
	boolean canModify;
	String trueName;
	String phoneNumber;
	String numberOfIdentityCard;
	
	/**
	 * 
	 * @param nameOfUser  用户编号
	 * @param password  密码
	 * @param canCheck  
	 * @param canModify  
	 * @param trueName   真实姓名
	 * @param phoneNumber  联系方式
	 * @param numberOfIdentityCard   身份证号
  	 */
	public WebmarketstaffPO(String nameOfUser,String password,boolean canCheck,boolean canModify,String trueName,String phoneNumber,String numberOfIdentityCard) {
		super();
		this.nameOfUser=nameOfUser;
		this.password=password;
		this.canCheck=canCheck;
		this.canModify=canModify;
		this.trueName=trueName;
		this.phoneNumber=phoneNumber;
		this.numberOfIdentityCard=numberOfIdentityCard;
	}
}
