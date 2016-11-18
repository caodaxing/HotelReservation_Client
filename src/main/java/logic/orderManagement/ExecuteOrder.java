package logic.orderManagement;

import Message.ResultMessage;
import logic.hotel.HotelUpdateRoom;
import logic.order.OrderInfo;
import logic.room.Room;

/**
 * 执行订单
 * @author Mark.W
 *
 */
public class ExecuteOrder {
	
	HotelUpdateRoom hotelUpdateRoom;
	OrderInfo orderInfo;
	
	public ExecuteOrder(HotelUpdateRoom updateRoom, OrderInfo orderInfo) {
		this.hotelUpdateRoom = updateRoom;
		this.orderInfo = orderInfo;
	}
	
	public ResultMessage updateRoom(Room room) {
		return hotelUpdateRoom.updateRoom(room);
	}
	
	/**
	 * 执行正常订单
	 * @param order_id 订单id
	 * @return ResultMessage
	 */
	public ResultMessage normalExecute(String order_id){
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 自动设置成异常订单
	 * @param order_id 订单id
	 * @return ResultMessage
	 */
	public ResultMessage autoSetUnnormal(String order_id){
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 客户在最晚执行订单时间后入住，补登记订单
	 * @param order_id 订单id
	 * @return ResultMessage
	 */
	public ResultMessage supplyOrder(String order_id){
		return ResultMessage.SUCCESS;
	}
}
