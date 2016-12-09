package vo;

import Message.VipType;

/**
 * @param userID
 * @param vipType 会员类型 
 * @param vipLevel 会员等级 0:不是会员 
 * @param vipInfo 若memberType为0则为空，否则为相应的生日或者企业信息
 * @author Mark.W
 *
 */
public class VipVO {
	
	public String userID;
	public VipType vipType; 
	public int level;
	public String info;
	
	public VipVO(String userID, VipType vipType, int level, String info) {
		this.userID = userID;
		this.vipType = vipType;
		this.level = level;
		this.info = info;
	}
}
