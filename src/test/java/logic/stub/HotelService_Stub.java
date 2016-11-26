package logic.stub;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import Message.ResultMessage;
import logicService.HotelService;
import vo.EvaluationVO;
import vo.HotelSearchVO;
import vo.HotelVO;
import vo.RoomVO;

public class HotelService_Stub implements HotelService{
	
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

	public HotelVO getHotelItemInfo(String hotel_id) {
		// TODO Auto-generated method stub
		
		ArrayList<Image> list = new ArrayList<Image>();
		Image image1 = Toolkit.getDefaultToolkit().createImage("index.jpg");
		Image image2 = Toolkit.getDefaultToolkit().createImage("index1.jpg");
		list.add(image1);
		list.add(image2);
		
		return new HotelVO("朗诗酒店", "江苏省南京市珠江路88号", "提供各式标准间，预定赠早餐券，三星级酒店完美体验"
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

	public ArrayList<HotelVO> getInitialHotelList(String location, String tradingArea) {
		// TODO Auto-generated method stub
		
		ArrayList<Image> list1 = new ArrayList<Image>();
		Image image1 = Toolkit.getDefaultToolkit().createImage("index.jpg");
		Image image2 = Toolkit.getDefaultToolkit().createImage("index1.jpg");
		list1.add(image1);
		list1.add(image2);
		HotelVO info1 = new HotelVO("朗诗酒店", "江苏省南京市珠江路88号", "提供各式标准间，预定赠早餐券，三星级酒店完美体验"
				, "288", "房间整洁，好评！", list1);
		
		ArrayList<Image> list2 = new ArrayList<Image>();
		Image image3 = Toolkit.getDefaultToolkit().createImage("index2.jpg");
		Image image4 = Toolkit.getDefaultToolkit().createImage("index3.jpg");
		list2.add(image3);
		list2.add(image4);
		HotelVO info2 = new HotelVO("雅阁酒店", "江苏省无锡市中山路12号", "提供各式标准间，预定赠早餐券，四星级酒店完美体验"
				, "388", "房间整洁，好评！", list2);
		
		ArrayList<HotelVO> List = new ArrayList<HotelVO>();
		List.add(info1);
		List.add(info2);
		
		return List;
	}

	public ArrayList<HotelVO> getSortedList() {
		// TODO Auto-generated method stub
		
		ArrayList<Image> list1 = new ArrayList<Image>();
		Image image1 = Toolkit.getDefaultToolkit().createImage("index.jpg");
		Image image2 = Toolkit.getDefaultToolkit().createImage("index1.jpg");
		list1.add(image1);
		list1.add(image2);
		HotelVO info1 = new HotelVO("朗诗酒店", "江苏省南京市珠江路88号", "提供各式标准间，预定赠早餐券，三星级酒店完美体验"
				, "288", "房间整洁，好评！", list1);
		
		ArrayList<HotelVO> List = new ArrayList<HotelVO>();
		List.add(info1);
		
		return List;
	}

	public ArrayList<HotelVO> getBookedHotelList(String user_id) {
		ArrayList<Image> list2 = new ArrayList<Image>();
		Image image3 = Toolkit.getDefaultToolkit().createImage("index2.jpg");
		Image image4 = Toolkit.getDefaultToolkit().createImage("index3.jpg");
		list2.add(image3);
		list2.add(image4);
		HotelVO info2 = new HotelVO("雅阁酒店", "江苏省无锡市中山路12号", "提供各式标准间，预定赠早餐券，四星级酒店完美体验"
				, "388", "房间整洁，好评！", list2);
		
		ArrayList<HotelVO> List = new ArrayList<HotelVO>();
		List.add(info2);
		
		return List;
	}

	public HotelVO search(HotelSearchVO search) {
		// TODO Auto-generated method stub
		
		ArrayList<Image> list = new ArrayList<Image>();
		Image image1 = Toolkit.getDefaultToolkit().createImage("index.jpg");
		Image image2 = Toolkit.getDefaultToolkit().createImage("index1.jpg");
		list.add(image1);
		list.add(image2);
		
		return  new HotelVO("朗诗酒店", "江苏省南京市珠江路88号", "提供各式标准间，预定赠早餐券，三星级酒店完美体验"
				, "288", "房间整洁，好评！", list);
	}
}
