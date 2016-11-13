package logic.hotel;

import java.util.ArrayList;

import Message.ResultMessage;
import logic.order.Order;
import logic.promotion.HotelPromotion;
import logic.room.Room;
import vo.EvaluationVO;
import vo.HotelInfoVO;
import vo.RoomVO;

public class Hotel {
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
	public HotelInfoVO getHotelItemInfo (String hotel_id){
		return hotelitem.getHotelItemInfo(hotel_id);
	}
	public ResultMessage updateHotelInfo (HotelInfoVO hotel){
		return ResultMessage.SUCCESS;
	}
	public String getPromotion(String hotelid){
		return hotelpro.getromotion(hotelid);
	}
}
