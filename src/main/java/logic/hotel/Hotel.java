package logic.hotel;

import java.util.ArrayList;

import Message.ResultMessage;
import logic.order.Order;
import logic.promotion.HotelPromotion;
import logic.room.Room;
import vo.EvaluationVO;
import vo.HotelInfoVO;
import vo.RoomVO;

public class Hotel implements HotelItem{
	HotelItem hotelitem;
	Room r;
	HotelPromotion hotelpro;
	Order o;
	
	public ResultMessage updateRoom (RoomVO room){
		return r.updateRoomInfo(room);
	}
	public ArrayList<EvaluationVO> getHotelInfo (String hotelName){
		String orderlist = null;
		return o.getEvaluation(orderlist);
		
	}
	
	public ResultMessage updateHotelInfo (HotelInfoVO hotel){
		return ResultMessage.SUCCESS;
	}
	
	public String getPromotion(String hotelid){
		return hotelpro.getPromotion(hotelid);
	}
	
	public HotelInfoVO getHotelItemInfo(String hotel_id) {
		return null;
	}
}
