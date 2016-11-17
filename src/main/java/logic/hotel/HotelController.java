package logic.hotel;

import java.util.ArrayList;

import Message.ResultMessage;
import vo.EvaluationVO;
import vo.HotelInfoVO;
import vo.HotelSearchVO;
import vo.RoomVO;

/**
 * Hotel的Controller
 * @author d
 *
 */
public class HotelController {
	Hotel hotel;
	SearchHotel searchhotel;
	
	public ResultMessage updateRoom(RoomVO room){
		return hotel.updateRoom(room);
	}
	
	public ArrayList<EvaluationVO> getHotelInfo(String hotelName){
		return hotel.getHotelInfo(hotelName);
	}
	
	public HotelInfoVO getHotelItemInfo(String hotel_id){
		return hotel.getHotelItemInfo(hotel_id);
	}
	
	public ArrayList<String> getTradingArea(String location){
		return searchhotel.getTradingArea(location);
	}
	
	public ArrayList<HotelInfoVO>getInitialHotelList(String location,String tradingArea ){
		return searchhotel.getInitialHotelList(location, tradingArea);
	}
	
	public ArrayList<HotelInfoVO>getSortedList(){
		return searchhotel.getSortedList();
	}
	
	public ArrayList< HotelInfoVO >getBookedHotelList(String user_id){
		return searchhotel.getBookedHotelList(user_id);
	}
	
	public HotelInfoVO search (HotelSearchVO search){
		return searchhotel.search(search);
	}
}
