package logic.user;

import Message.ResultMessage;

/**
 * 给hotel提供的接口
 * @author Mark.W
 *
 */
public interface HotelManagerInfo {

	/**
	 * 在添加酒店工作人员的时候，
	 * @param hotelID
	 * @return
	 */
	public ResultMessage hotelHasManager(String hotelID);
}
