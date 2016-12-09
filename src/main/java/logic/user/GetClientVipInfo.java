package logic.user;

import vo.VipVO;

/**
 * 给promotion包提供的获得用户vip信息的接口
 * @author Mark.W
 *
 */
public interface GetClientVipInfo {

	/**
	 * 获得VIP信息
	 * @param userID
	 * @return
	 */
	public VipVO getVipInfo(String userID);
	
	/**
	 * 判断用户是否是vip
	 * @param userID
	 * @return
	 */
	public boolean isVIP(String userID);
}
