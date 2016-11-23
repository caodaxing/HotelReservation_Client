package logic.stub;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

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
		
		return ResultMessage.FAILURE;
	}

	public ArrayList<EvaluationVO> getHotelInfo(String hotelName) {
		// TODO Auto-generated method stub
		
		ArrayList<EvaluationVO> List = new ArrayList<EvaluationVO>();
		EvaluationVO evaluation1 = new EvaluationVO("房间很乱，差评！！", "00102", "161222001021033", 0);
		EvaluationVO evaluation2 = new EvaluationVO("房间整洁，好评！", "01729", "161127017290403", 3);
		List.add(evaluation1);
		List.add(evaluation2);
		
		return List;
	}

	public HotelInfoVO getHotelItemInfo(String hotel_id) {
		// TODO Auto-generated method stub
		
		ArrayList<Image> list = new ArrayList<Image>();
		Image image1 = Toolkit.getDefaultToolkit().createImage("index.jpg");
		Image image2 = Toolkit.getDefaultToolkit().createImage("index1.jpg");
		list.add(image1);
		list.add(image2);
		
		return new HotelInfoVO("朗诗酒店", "江苏省南京市珠江路88号", "提供各式标准间，预定赠早餐券，三星级酒店完美体验"
				, "288", "房间整洁，好评！", list);
	}

	public ArrayList<String> getTradingArea(String location) {
		// TODO Auto-generated method stub
		
		ArrayList<String> list = new ArrayList<String>();
		String location1 = "玄武区";
		String location2 = "栖霞区";
		String location3 = "鼓楼区";
		list.add(location1);
		list.add(location2);
		list.add(location3);
		
		return list;
	}

	public ArrayList<HotelInfoVO> getInitialHotelList(String location, String tradingArea) {
		// TODO Auto-generated method stub
		
		ArrayList<Image> list1 = new ArrayList<Image>();
		Image image1 = Toolkit.getDefaultToolkit().createImage("index.jpg");
		Image image2 = Toolkit.getDefaultToolkit().createImage("index1.jpg");
		list1.add(image1);
		list1.add(image2);
		HotelInfoVO info1 = new HotelInfoVO("朗诗酒店", "江苏省南京市珠江路88号", "提供各式标准间，预定赠早餐券，三星级酒店完美体验"
				, "288", "房间整洁，好评！", list1);
		
		ArrayList<Image> list2 = new ArrayList<Image>();
		Image image3 = Toolkit.getDefaultToolkit().createImage("index2.jpg");
		Image image4 = Toolkit.getDefaultToolkit().createImage("index3.jpg");
		list2.add(image3);
		list2.add(image4);
		HotelInfoVO info2 = new HotelInfoVO("雅阁酒店", "江苏省无锡市中山路12号", "提供各式标准间，预定赠早餐券，四星级酒店完美体验"
				, "388", "房间整洁，好评！", list2);
		
		ArrayList<HotelInfoVO> List = new ArrayList<HotelInfoVO>();
		List.add(info1);
		List.add(info2);
		
		return List;
	}

	public ArrayList<HotelInfoVO> getSortedList() {
		// TODO Auto-generated method stub
		
		ArrayList<Image> list1 = new ArrayList<Image>();
		Image image1 = Toolkit.getDefaultToolkit().createImage("index.jpg");
		Image image2 = Toolkit.getDefaultToolkit().createImage("index1.jpg");
		list1.add(image1);
		list1.add(image2);
		HotelInfoVO info1 = new HotelInfoVO("朗诗酒店", "江苏省南京市珠江路88号", "提供各式标准间，预定赠早餐券，三星级酒店完美体验"
				, "288", "房间整洁，好评！", list1);
		
		ArrayList<HotelInfoVO> List = new ArrayList<HotelInfoVO>();
		List.add(info1);
		
		return List;
	}

	public ArrayList<HotelInfoVO> getBookedHotelList(String user_id) {
		// TODO Auto-generated method stub
		
		ArrayList<Image> list2 = new ArrayList<Image>();
		Image image3 = Toolkit.getDefaultToolkit().createImage("index2.jpg");
		Image image4 = Toolkit.getDefaultToolkit().createImage("index3.jpg");
		list2.add(image3);
		list2.add(image4);
		HotelInfoVO info2 = new HotelInfoVO("雅阁酒店", "江苏省无锡市中山路12号", "提供各式标准间，预定赠早餐券，四星级酒店完美体验"
				, "388", "房间整洁，好评！", list2);
		
		ArrayList<HotelInfoVO> List = new ArrayList<HotelInfoVO>();
		List.add(info2);
		
		return List;
	}

	public HotelInfoVO search(HotelSearchVO search) {
		// TODO Auto-generated method stub
		
		ArrayList<Image> list = new ArrayList<Image>();
		Image image1 = Toolkit.getDefaultToolkit().createImage("index.jpg");
		Image image2 = Toolkit.getDefaultToolkit().createImage("index1.jpg");
		list.add(image1);
		list.add(image2);
		
		return  new HotelInfoVO("朗诗酒店", "江苏省南京市珠江路88号", "提供各式标准间，预定赠早餐券，三星级酒店完美体验"
				, "288", "房间整洁，好评！", list);
	}
}
