package logic.hotel;

import java.util.ArrayList;

import logic.order.Order;
import logic.promotion.HotelPromotion;
import logic.room.Room;
import message.ResultMessage;
import vo.EvaluationVO;
import vo.HotelInfoVO;
import vo.RoomVO;

/**
 * 酒店信息，提供更新房间、酒店信息，获取评价，获取促销策略方法
 * @author all
 *
 */
public class Hotel implements HotelItem{
	HotelItem hotelitem;
	Room r;
	HotelPromotion hotelpro;
	Order o;
	
	/**
	 * 更新房间信息
	 * @param roomVO 传入的VO信息
	 * @return ResultMessage 返回是否更新成功（成功/失败）
	 * @author all
	 */
	public ResultMessage updateRoom (RoomVO roomVO){
		return r.updateRoomInfo(roomVO);
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
	public ResultMessage updateHotelInfo (HotelInfoVO hotelVO){
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 获取促销策略
	 * @param hotel_id 传入的酒店id
	 * @return String 返回酒店的促销策略
	 * @author all
	 */
	public String getPromotion(String hotel_id){
		return hotelpro.getPromotion(hotel_id);
	}
	
	/**
	 * 给order提供的获取酒店信息的接口
	 * @param hotel_id 传入的酒店id
	 * @return HotelInfoVO 返回部分酒店信息
	 * @author all
	 */
	public HotelInfoVO getHotelItemInfo(String hotel_id) {
		return null;
	}
}
