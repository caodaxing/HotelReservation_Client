package po;

public class WebmanagementPO {
	
	String nameOfUser;
	String password;
	boolean canModify;
	String trueName;
	String phoneNumber;
	String numberOfIdentityCard;
	
	/**
	 * 网站管理人员的PO类
	 * @param nameOfUser 用户账户
	 * @param password 密码
	 * @param canModify 修改客户信息的权限
	 * @param trueName 用户真实姓名
	 * @param phoneNumber 用户联系方式
	 * @param numberOfIdentityCard 身份证号
	 * @author Rukawa
	 */
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
