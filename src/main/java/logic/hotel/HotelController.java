package logic.hotel;

import java.util.ArrayList;

import Message.ResultMessage;
import logicService.HotelService;
import vo.EvaluationVO;
import vo.HotelSearchVO;
import vo.HotelVO;
import vo.RoomVO;

/**
 * Hotel的Controller
 * @author d
 *
 */
public class HotelController implements HotelService{
	Hotel hotel;
	SearchHotel searchhotel;
	
	public ResultMessage updateRoom(RoomVO room){
		return hotel.updateRoom(room);
	}
	
	public ArrayList<EvaluationVO> getHotelInfo(String hotelName){
		return hotel.getHotelInfo(hotelName);
	}
	
	public HotelVO getHotelItemInfo(String hotel_id){
		return hotel.getHotelItemInfo(hotel_id);
	}
	
	public ArrayList<String> getTradingArea(String location){
		return searchhotel.getTradingArea(location);
	}
	
	public ArrayList<HotelVO> getInitialHotelList(String location,String tradingArea ){
		return searchhotel.getInitialHotelList(location, tradingArea);
	}
	
	public ArrayList<HotelVO> getSortedList(){
		return searchhotel.getSortedList();
	}
	
	public ArrayList< HotelVO >getBookedHotelList(String user_id){
		return searchhotel.getBookedHotelList(user_id);
	}
	
	public HotelVO search(HotelSearchVO search){
		return searchhotel.search(search);
	}
}
