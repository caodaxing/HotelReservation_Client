package po;

public class WebmanagementPO {
	String nameOfUser;
	String password;
	boolean canModify;
	String trueName;
	String phoneNumber;
	String numberOfIdentityCard;
	
	public WebmanagementPO(String nameOfUser,String password,boolean canModify,String trueName,String phoneNumber,String numberOfIdentityCard) {
		super();
		this.nameOfUser=nameOfUser;
		this.password=password;
		this.canModify=canModify;
		this.trueName=trueName;
		this.phoneNumber=phoneNumber;
		this.numberOfIdentityCard=numberOfIdentityCard;
	}
}
