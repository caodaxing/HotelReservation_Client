package vo;

/**
 * 
 * @param hotelManagerID 酒店管理人员号
 * @param hotel     	所属酒店
 * @param phoneNumber   联系方式
 * @param trueName    	真实姓名
 * @param numberOfIdentityCard    身份证号
 */
public class HotelManagerVO {
	public String userID;
	public String hotelID;
	public String phoneNumber;
	public String trueName;
	public String numberOfIdentityCard;
	
	public HotelManagerVO(String userID, String hotelID, String phoneNumber, String trueName,
			String numberOfIdentityCard) {
		this.userID = userID;
		this.hotelID = hotelID;
		this.phoneNumber = phoneNumber;
		this.trueName = trueName;
		this.numberOfIdentityCard = numberOfIdentityCard;
	}
	
	
	
}
