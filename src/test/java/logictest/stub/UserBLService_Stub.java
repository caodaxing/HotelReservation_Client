package logictest.stub;

import java.util.ArrayList;

import Message.Identity;
import Message.ResultMessage;
import logicService.UserService;
import vo.AccountVO;
import vo.HotelInfoVO;
import vo.HotelManagerVO;
import vo.UserVO;
import vo.VIPInfoVO;
import vo.WebBusinessVO;

public class UserBLService_Stub implements UserService {
	
//	public UserVO getUserInfo(long id) {
//		ArrayList<OrderVO> orders = new ArrayList<OrderVO>();
//		orders.add(new OrderVO("124523", "20160930", new RoomVO(1, 299, 0, 1123), "20161001", 1, 2, false));
//		return new UserVO(id, "mark", "13338021124", 1000, orders);
//	} 
//	
//	public ResultMessage deleteUserInfo(long id, String infoType){
//		return ResultMessage.SUCCESS;
//	}
//	
//	public ResultMessage updateUserInfo(long id, String infoType,String info){
//		return ResultMessage.SUCCESS;
//	}
//	
//	public ResultMessage addUserInfo(long id, String infoType, String info){
//		return ResultMessage.SUCCESS;
//	}
//	
//	public ResultMessage updateHotelManager (HotelManagerVO hotelManager, String hotelId) {
//		return ResultMessage.SUCCESS;
//	}
//	
//	public ResultMessage changeVIPLevel (int userId){
//		return ResultMessage.SUCCESS;
//	}

	public UserVO getUserInfo(String user_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateUserInfo(UserVO new_userInfo, String user_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage setVIP(VIPInfoVO VIPInfo, String user_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public VIPInfoVO getVIPInfo(String user_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<HotelInfoVO> getHistoryHotelInfo(String user_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addHotelManagerInfo(HotelManagerVO hotelManager, String hotel_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public HotelManagerVO getHotelManagerInfo(String hotel_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo, String hotel_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addWebBusiness(WebBusinessVO webBusinessInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo, String webBusiness_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public Identity getAccountIdentity(AccountVO accountVO) {
		// TODO Auto-generated method stub
		return null;
	}
}
