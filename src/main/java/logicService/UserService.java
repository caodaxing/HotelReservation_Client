package logicService;

import java.util.ArrayList;

import Message.Identity;
import vo.AccountVO;
import vo.HotelInfoVO;
import vo.HotelManagerVO;
import vo.UserVO;
import vo.VIPInfoVO;
import vo.WebBusinessVO;

public interface UserService {
	
	public UserVO getUserInfo(String user_ID);
	
	public boolean updateUserInfo(UserVO new_userInfo , String user_ID);
	
	public boolean setVIP(VIPInfoVO VIPInfo , String user_ID);
	
	public VIPInfoVO getVIPInfo (String user_ID);
	
	public ArrayList<HotelInfoVO> getHistoryHotelInfo(String user_ID);
	
	public boolean addHotelManagerInfo(HotelManagerVO hotelManager ,String hotel_ID);
	
	public HotelManagerVO getHotelManagerInfo(String hotel_ID);
	
	public boolean updateHotelManagerInfo(HotelManagerVO hotelManagerInfo , String hotel_ID);
	
	public boolean addWebBusiness(WebBusinessVO  webBusinessInfo);
	
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID);
	
	public boolean updateWebBusinessInfo(WebBusinessVO webBusinessInfo , String webBusiness_ID);
	
	public Identity getAccountIdentity(AccountVO accountVO);
	
}
