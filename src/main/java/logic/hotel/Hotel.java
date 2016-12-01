package logic.hotel;

import java.util.ArrayList;

import Message.ResultMessage;
import logic.order.Order;
import logic.promotion.HotelPromotion;
import logic.room.Room;
import logicService.hotel.CheckHotelService;
import vo.EvaluationVO;
import vo.HotelVO;
import vo.RoomVO;

/**
 * 酒店信息，提供更新房间、酒店信息，获取评价，获取促销策略方法
 * @author all
 *
 */
public class Hotel implements CheckHotelService, HotelItemInfo, HotelUpdateRoom{
	
	private String hotelID;
	private ArrayList<Room> rooms;
	private HotelPromotion hotelPromotion;
	private ArrayList<Order> hotelOrders;
	
	public Hotel(String hotelID){
		this.hotelID = hotelID;
	}
	
	/**
	 * 以酒店促销策略构造酒店
	 * @param hotelPromotion 酒店促销策略
	 * @author Mark.W
	 */
	public Hotel(HotelPromotion hotelPromotion) {
		this.hotelPromotion = hotelPromotion;
	}
	
	/**
	 * 订单执行时调用，更新房间信息
	 * @param room 传入的room对象信息
	 * @return ResultMessage 返回是否更新成功（成功/失败）
	 * @author Mark.W
	 */
	public ResultMessage updateRoom(Room room) {
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 酒店工作人员更新房间信息，从界面调用
	 * @param roomVO 传入的VO信息
	 * @return ResultMessage 返回是否更新成功（成功/失败）
	 * @author all
	 */
	public ResultMessage updateRoom(RoomVO roomVO){
		return rooms.get(0).updateRoomInfo(roomVO);
	}
	
	/**
	 * 获取酒店评价信息
	 * @param hotel_id 传入的酒店id
	 * @return ArrayList<EvaluationVO> 返回评价的列表
	 * @author all
	 */
	public ArrayList<EvaluationVO> getHotelInfo (String hotel_id){
		//获取酒店所属订单后，由订单获取评价
		return null;
		
	}
	
	/**
	 * 更新酒店信息
	 * @param hotelVO 传入的VO信息
	 * @return ResultMessage 返回是否更新成功（成功/失败）
	 * @author all
	 */
	public ResultMessage updateHotelInfo (HotelVO hotelVO){
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 获取促销策略
	 * @param hotel_id 传入的酒店id
	 * @return String 返回酒店的促销策略
	 * @author all
	 */
	public String getPromotion(String hotel_id){
		return hotelPromotion.getPromotion(hotel_id);
	}
	
	/**
	 * 给order提供的获取酒店信息的接口
	 * @param hotel_id 传入的酒店id
	 * @return HotelVO 返回部分酒店信息
	 * @author all
	 */
	public HotelVO getHotelItemInfo(String hotel_id) {
		return null;
	}

	@Override
	public HotelVO getHotelnfo(String hotel_id) {
		return null;
	}

	@Override
	public ArrayList<EvaluationVO> getHotelEvaluations(String hotelid) {
		return null;
	}
}
