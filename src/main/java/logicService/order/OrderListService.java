package logicService.order;

import java.util.ArrayList;

import Message.OrderListCondition;
import vo.OrderVO;

/**
 * 有关订单列表筛选的接口
 * @author Mark.W
 *
 */
public interface OrderListService {
	
	/**
	 * 筛选用户订单
	 * @param userID
	 * @param condition 订单列表的条件
	 * @return 酒店列表
	 */
	public ArrayList<OrderVO> filterUserOrderList(String userID, OrderListCondition condition);
	
	/**
	 * 筛选酒店订单
	 * @param hotelID
	 * @param condition 订单列表的条件
	 * @return 酒店列表
	 */
	public ArrayList<OrderVO> filterHotelOrderList(String hotelID, OrderListCondition condition);
	
	/**
	 * 获取指定用户预订过的酒店的历史订单列表
	 * @param userID
	 * @param hotelId
	 * @return 酒店列表
	 */
	public ArrayList<OrderVO> filterSpecificUserHotelOrderList(String userID, String hotelId);
	
	
}
