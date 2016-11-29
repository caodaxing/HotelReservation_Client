package vo;
/**
 * @param userID
 * @param vipType 会员类型 0:不是会员 1:普通会员 2:企业会员 
 * @param vipLevel 会员等级 0:不是会员 
 * @param vipInfo 若memberType为0则为空，否则为相应的生日或者企业信息
 * @author Mark.W
 *
 */
public class VipVO {
	
	public String userID;
	public int type; 
	public int level;
	public String info;
	
	public VipVO(String userID, int type, int level, String info) {
		this.userID = userID;
		this.type = type;
		this.level = level;
		this.info = info;
	}
}
