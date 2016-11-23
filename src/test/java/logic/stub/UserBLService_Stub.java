package logic.stub;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import Message.Identity;
import Message.ResultMessage;
import logicService.UserService;
import vo.AccountVO;
import vo.HotelInfoVO;
import vo.HotelManagerVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.ClientVO;
import vo.VIPInfoVO;
import vo.WebBusinessVO;

public class UserBLService_Stub implements UserService {
	
	public ClientVO getUserInfo(String user_ID) {
		// TODO Auto-generated method stub
		
		ArrayList<OrderVO> List = new ArrayList<OrderVO>();
		OrderVO order1 = new OrderVO("161124000021109", "161124", new RoomVO(0, 288, 0, "1109"), "161125", 0, 2, false, 288);
		OrderVO order2 = new OrderVO("161225005540304", "161225", new RoomVO(0, 388, 0, "0304"), "161226", 1, 2, true, 388);
		List.add(order1);
		List.add(order2);
		
		return new ClientVO("27873shkj", "王友运", "18378474456", 0,List);
	}

	public ResultMessage updateUserInfo(ClientVO new_userInfo, String user_ID) {
		// TODO Auto-generated method stub
		
		return ResultMessage.FAILURE;
	}

	public ResultMessage setVIP(VIPInfoVO VIPInfo, String user_ID) {
		// TODO Auto-generated method stub
		
		return ResultMessage.SUCCESS;
	}

	public VIPInfoVO getVIPInfo(String user_ID) {
		// TODO Auto-generated method stub
		
		return new VIPInfoVO("普通会员", "3");
	}

	public ArrayList<HotelInfoVO> getHistoryHotelInfo(String user_ID) {
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

	public ResultMessage addHotelManagerInfo(HotelManagerVO hotelManager, String hotel_ID) {
		// TODO Auto-generated method stub
		
		return ResultMessage.SUCCESS;
	}

	public HotelManagerVO getHotelManagerInfo(String hotel_ID) {
		// TODO Auto-generated method stub
		
		return new HotelManagerVO("00072", "扁纯元", "18288380909");
	}

	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo, String hotel_ID) {
		// TODO Auto-generated method stub
		
		return ResultMessage.FAILURE;
	}

	public ResultMessage addWebBusiness(WebBusinessVO webBusinessInfo) {
		// TODO Auto-generated method stub
		
		return ResultMessage.SUCCESS;
	}

	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID) {
		// TODO Auto-generated method stub
		
		return new WebBusinessVO("732938zhdk", "王雪", "18837468876");
	}

	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo, String webBusiness_ID) {
		// TODO Auto-generated method stub
		
		return ResultMessage.FAILURE;
	}

	public Identity getAccountIdentity(AccountVO accountVO) {
		// TODO Auto-generated method stub
		
		return Identity.HOTELMANAGER;
	}
}
