package logic.stub;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import Message.ResultMessage;
import logicService.UserService;
import vo.ClientVO;
import vo.HotelManagerVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.VipVO;
import vo.WebBusinessVO;

public class UserBLService_Stub implements UserService {
	
	public ClientVO getClientInfo(String user_ID) {
		
		ArrayList<OrderVO> List = new ArrayList<OrderVO>();
		OrderVO order1 = new OrderVO("161124000021109", "161124", new RoomVO(0, 288, 0, "1109"), "161125", 0, 2, false, 288);
		OrderVO order2 = new OrderVO("161225005540304", "161225", new RoomVO(0, 388, 0, "0304"), "161226", 1, 2, true, 388);
		List.add(order1);
		List.add(order2);
		
		return new ClientVO("27873shkj", "13333333333", "王友运", 100, 0, 0, null);
	}

	public ResultMessage updateClientInfo(ClientVO new_userInfo) {
		
		return ResultMessage.FAILURE;
	}

	public ResultMessage registerVIP(VipVO VIPInfo) {
		
		return ResultMessage.SUCCESS;
	}
	
	@Override
	public boolean isVIP(String userID) {
		return false;
	}


	public VipVO getVIPInfo(String user_ID) {
		
		return new VipVO("27873shkj", 1, 1, "20160101");
	}

	public ArrayList<HotelVO> getHistoryHotels(String user_ID) {
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

	public ResultMessage addHotel(HotelVO hotelVO) {
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage addHotelManager(HotelManagerVO hotelManager) {
		return ResultMessage.SUCCESS;
	}

	public HotelManagerVO getHotelManagerInfo(String hotel_ID) {
		return new HotelManagerVO("00072", "扁纯元", "18288380909");
	}

	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo) {
		return ResultMessage.FAILURE;
	}

	public ResultMessage addWebBusiness(WebBusinessVO webBusinessInfo) {
		return ResultMessage.SUCCESS;
	}

	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID) {
		return new WebBusinessVO("732938zhdk", "王雪", "18837468876");
	}

	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo) {
		return ResultMessage.FAILURE;
	}

}