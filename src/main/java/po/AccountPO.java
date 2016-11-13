package po;

public class AccountPO {
	String kindOfUser;
	String accountID;
	String password;
	boolean isMenber;
	String birthdayOfMember;
	String bussinessOfMember;
	String trueName;
	String place;
	String bussinessCall;
	String phoneNumber;
	
	/**
	 * 
	 * @param kindOfUser 账户的身份
	 * @param accountID	帐号
	 * @param password	密码
	 * @param isMenber	是否是会员
	 * @param birthdayOfMember 会员生日
	 * @param bussinessOfMember 会员公司
	 * @param trueName 真实姓名
	 * @param place 账户地址
	 * @param bussinessCall 公司电话
	 * @param phoneNumber 电话
	 */
	public AccountPO(String kindOfUser,String accountID,String password,boolean isMenber,String birthdayOfMember,
						String bussinessOfMember,String trueName,String place,String bussinessCall,String phoneNumber){
		super();
		this.kindOfUser=kindOfUser;
		this.accountID=accountID;
		this.password=password;
		this.isMenber=isMenber;
		this.birthdayOfMember=birthdayOfMember;
		this.bussinessOfMember=this.bussinessOfMember;
		this.trueName=trueName;
		this.place=place;
		this.bussinessCall=bussinessCall;
		this.phoneNumber=phoneNumber;

	}
}
