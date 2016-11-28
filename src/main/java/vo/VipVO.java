package vo;
/**
 * @param userID
 * @param type vip类型 0:不是会员 1:普通会员 2:企业会员 
 * @param level vip等级
 * @param info vip信息
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
