package logic.stub;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Message.ResultMessage;
import logicService.HotelService;
import vo.EvaluationVO;
import vo.HotelInfoVO;
import vo.HotelSearchVO;
import vo.RoomVO;

public class HotelService_Stub implements HotelService{
	
//	ArrayList<String> hotellist;
//	ArrayList<String> historylist;
//	ImageIcon image;
//	
//	public ArrayList<String> searchHotel(String tradingarea , String level , int pricefloor , int priceceiling){
//		return hotellist;
//	}
//	
//	public HotelInfoVO viewHotel (String hotelName){
//		return new HotelInfoVO("��껾Ƶ�","����ʡ��������ɽ·89��","�۸����У������ܵ�","158����388","kkdki:���Ǻ���",image);
//	}
//	
//	public ArrayList<String> hotelHistory(ResultMessage userstate , String username){
//		return historylist;
//	}
//	
//	public HotelInfoVO addHotel(String hotelid){
//		return new HotelInfoVO("��ʫ�Ƶ�","����ʡ��������ɽ·9��","�۸����У������ܵ�","138����388","ddedd:���Ǻ���",image);
//	}
//	
//	public HotelInfoVO updateHotel(String hotelid){
//		return new HotelInfoVO("��ʫ�Ƶ�","����ʡ��������ɽ·9��","�۸����У������ܵ�","188����368","ddedd:���Ǻ���",image);
//	}

	public ResultMessage updateRoom(RoomVO room) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<EvaluationVO> getHotelInfo(String hotelName) {
		// TODO Auto-generated method stub
		return null;
	}

	public HotelInfoVO getHotelItemInfo(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getTradingArea(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<HotelInfoVO> getInitialHotelList(String location, String tradingArea) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<HotelInfoVO> getSortedList() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<HotelInfoVO> getBookedHotelList(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public HotelInfoVO search(HotelSearchVO search) {
		// TODO Auto-generated method stub
		return null;
	}
}
