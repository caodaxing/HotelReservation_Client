package vo;

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
public class ClientVO {
	
	public String userID;
	public String phoneNumber;
	public String trueName;
	public int credit;
	public int vipType;
	public int vipLevel;
	public String vipInfo;
	
	public ClientVO(String userID, String phoneNumber, String trueName, int credit, int vipType, int vipLevel,
			String vipInfo) {
		this.userID = userID;
		this.phoneNumber = phoneNumber;
		this.trueName = trueName;
		this.credit = credit;
		this.vipType = vipType;
		this.vipLevel = vipLevel;
		this.vipInfo = vipInfo;
	}
}
