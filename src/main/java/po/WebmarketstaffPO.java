package po;

public class WebmarketstaffPO {
	String nameOfUser;
	String password;
	boolean canCheck;
	boolean canModify;
	String trueName;
	String phoneNumber;
	String numberOfIdentityCard;
	
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
