package logicService.order;

import java.util.ArrayList;

import Message.OrderListCondition;
import vo.OrderVO;

public interface OrderListService {
	
	public ArrayList<OrderVO> filterUserOrderList(String userID, OrderListCondition conditon);
	
	public ArrayList<OrderVO> filterHotelOrderList(String hotelID, OrderListCondition conditon);
	
	//获取预订过的酒店的历史订单列表
	public ArrayList<OrderVO> filterOrderList(String userID, String hotelId);
}
