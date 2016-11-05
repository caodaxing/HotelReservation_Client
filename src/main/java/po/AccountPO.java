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
