package logic.order;

import Message.ResultMessage;
import logic.hotel.HotelUpdateRoom;
import logic.room.Room;
import logicService.order.ExecuteOrderService;

/**
 * 执行订单
 * @author Mark.W
 *
 */
public class ExecuteOrder implements ExecuteOrderService{
	

	@Override
	public ResultMessage normalExecute(String order_id) {
		return null;
	}

	@Override
	public ResultMessage autoSetUnnormal(String order_id) {
		return null;
	}

	@Override
	public ResultMessage supplyOrder(String order_id) {
		return null;
	}
	
	
}
