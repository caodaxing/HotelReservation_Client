package logicService.order;

import java.util.ArrayList;

import Message.OrderListCondition;
import vo.OrderVO;

public interface OrderListService {
	
	public ArrayList<OrderVO> filterUserOrderList(String userID, OrderListCondition condition);
	
	public ArrayList<OrderVO> filterHotelOrderList(String hotelID, OrderListCondition condition);
	
	//获取预订过的酒店的历史订单列表
	public ArrayList<OrderVO> filterSpecificUserHotelOrderList(String userID, String hotelId);
	
	
}
