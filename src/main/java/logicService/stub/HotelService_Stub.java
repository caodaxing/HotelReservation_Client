package logicService.stub;

import java.util.ArrayList;

import Message.HotelSearchCondition;
import Message.ResultMessage;
import logicService.hotel.CheckHotelService;
import logicService.hotel.SearchHotelService;
import logicService.hotel.UpdateHotelService;
import vo.EvaluationVO;
import vo.HotelSearchVO;
import vo.HotelVO;
import vo.RoomVO;

public class HotelService_Stub implements UpdateHotelService,SearchHotelService,CheckHotelService {

	public ResultMessage hotelIDExits(String hotelID){
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage hotelHasManager(String hotelID){
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage addHotel(HotelVO hotelVO){
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage updateHotelInfo(HotelVO hotelVO){
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage updateRoom(RoomVO roomVO){
		return ResultMessage.SUCCESS;
	}

	@Override
	public HotelVO getHotelnfo(String hotel_id) {
		
		return new HotelVO("12345","如家","南京","","栖霞区","仙林大道163号",3.3,3,"如家酒店","独立卫浴",null,null,"");
	}

	@Override
	public ArrayList<EvaluationVO> getHotelEvaluations(String hotelId) {

		return null;
	}

	@Override
	public ResultMessage hotelIDExist(String hotelID) {

		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<String> getTradingArea(String location) {

		return null;
	}

	@Override
	public ArrayList<HotelVO> getSortedList(HotelSearchCondition condition, ArrayList<HotelVO> hotels) {
		return null;
	}

	@Override
	public ArrayList<HotelVO> getBookedHotelList(String user_id) {

		return null;
	}

	@Override
	public ArrayList<HotelVO> search(HotelSearchVO search) {

		return null;
	}
	
}
