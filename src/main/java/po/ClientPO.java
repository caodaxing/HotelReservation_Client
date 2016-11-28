package po;

/**
 * @param userID 用户名
 * @param phoneNumber 电话
 * @param trueName 真实姓名
 * @param credit 信用
 * @param vipType 会员类型 0:不是会员 1:普通会员 2:企业会员 
 * @param vipLevel 会员等级 0:不是会员 
 * @param vipInfo 若memberType为0则为空，否则为相应的生日或者企业信息
 * @author bcy
 *
 */
public class ClientPO {
	
	private String userID;
	private String phoneNumber;
	private String trueName;
	private int credit;
	private int vipType;
	private int vipLevel;
	private String vipInfo;
	
	public ClientPO(String userID, String phoneNumber, String trueName, int credit, int vipType, int vipLevel,
			String vipInfo) {
		this.userID = userID;
		this.phoneNumber = phoneNumber;
		this.trueName = trueName;
		this.credit = credit;
		this.vipType = vipType;
		this.vipLevel = vipLevel;
		this.vipInfo = vipInfo;
	}


	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getVipType() {
		return vipType;
	}

	public void setVipType(int vipType) {
		this.vipType = vipType;
	}

	public int getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

	public String getVipInfo() {
		return vipInfo;
	}

	public void setVipInfo(String vipInfo) {
		this.vipInfo = vipInfo;
	}

	
}
