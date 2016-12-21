package logic.order;

import java.util.ArrayList;

import vo.EvaluationVO;

/**
 * 提供给hotel包的接口
 * @author Mark.W
 */
public interface OrderHotelInfo {

	/**
	 * 查看酒店评价信息需要从order拿评价详情
	 * @param hotelID
	 * @return 属于该酒店的所有评价
	 */
	public ArrayList<EvaluationVO> getHotelEvaluations(String hotelID);
	
	/**
	 * 查看预订过的酒店时，需要查看某个用户所有预订过的酒店id
	 * @param userID 用户id
	 * @return 预订过的酒店id
	 */
	public ArrayList<String> getBookedHotelList(String userID);
}
