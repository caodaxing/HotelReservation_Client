package logicService;

import java.util.ArrayList;

import Message.ResultMessage;
import vo.EvaluationVO;
import vo.HotelSearchVO;
import vo.HotelVO;
import vo.RoomVO;

public interface HotelService {

	public ResultMessage updateRoom(RoomVO room);
	
	public ArrayList<EvaluationVO> getHotelInfo(String hotelName);
	
	public HotelVO getHotelItemInfo(String hotel_id);
	
	public ArrayList<String> getTradingArea(String location);
	
	public ArrayList<HotelVO> getInitialHotelList(String location,String tradingArea);
	
	public ArrayList<HotelVO> getSortedList();
	
	public ArrayList<HotelVO> getBookedHotelList(String user_id);
	
	public HotelVO search(HotelSearchVO search);
}
