package vo;

/**
 * @param hotelID     	所属酒店
 * @param phoneNumber   联系方式
 * @param trueName    	真实姓名
 * @param numberOfIdentityCard    身份证号
 */
public class HotelManagerVO {
	public String hotelID;
	public String phoneNumber;
	public String trueName;
	public String numberOfIdentityCard;
	
	public HotelManagerVO(String hotelID, String phoneNumber, 
			String trueName, String numberOfIdentityCard) {
		this.hotelID = hotelID;
		
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
		
		if(numberOfIdentityCard == null) {
			this.numberOfIdentityCard = "";
		} else {
			this.numberOfIdentityCard = numberOfIdentityCard;
		}
	}
	
}
