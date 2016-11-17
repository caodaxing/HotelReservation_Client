package logicService;

import java.util.ArrayList;

import Message.ResultMessage;
import vo.EvaluationVO;
import vo.HotelInfoVO;
import vo.HotelSearchVO;
import vo.RoomVO;

public interface HotelService {

	public ResultMessage updateRoom(RoomVO room);
	
	public ArrayList<EvaluationVO> getHotelInfo(String hotelName);
	
	public HotelInfoVO getHotelItemInfo(String hotel_id);
	
	public ArrayList<String> getTradingArea(String location);
	
	public ArrayList<HotelInfoVO> getInitialHotelList(String location,String tradingArea);
	
	public ArrayList<HotelInfoVO> getSortedList();
	
	public ArrayList<HotelInfoVO> getBookedHotelList(String user_id);
	
	public HotelInfoVO search(HotelSearchVO search);
}
