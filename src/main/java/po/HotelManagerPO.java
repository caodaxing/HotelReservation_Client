package po;

public class HotelManagerPO {
	String numberOfUser;
	String password;
	String hotel;
	String phoneNumber;
	String trueName;
	String numberOfIdentityCard;
	
	/**
	 * 
	 * @param numberOfUser 酒店管理人员号
	 * @param password   密码
	 * @param hotel     所属酒店
	 * @param phoneNumber   联系方式
	 * @param trueName    真实姓名
	 * @param numberOfIdentityCard    身份证号
	 */
	public HotelManagerPO(String numberOfUser,String password,String hotel,String phoneNumber,String trueName,String numberOfIdentityCard) {
		super();
		this.numberOfUser=numberOfUser;
		this.password=password;
		this.hotel=hotel;
		this.phoneNumber=phoneNumber;
		this.trueName=trueName;
		this.numberOfIdentityCard=numberOfIdentityCard;
	}
}
