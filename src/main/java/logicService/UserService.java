package logicService;

import java.util.ArrayList;

import Message.Identity;
import Message.ResultMessage;
import vo.AccountVO;
import vo.HotelInfoVO;
import vo.HotelManagerVO;
import vo.UserVO;
import vo.VIPInfoVO;
import vo.WebBusinessVO;

public interface UserService {
	
	public UserVO getUserInfo(String user_ID);
	
	public ResultMessage updateUserInfo(UserVO new_userInfo , String user_ID);
	
	public ResultMessage setVIP(VIPInfoVO VIPInfo , String user_ID);
	
	public VIPInfoVO getVIPInfo (String user_ID);
	
	public ArrayList<HotelInfoVO> getHistoryHotelInfo(String user_ID);
	
	public ResultMessage addHotelManagerInfo(HotelManagerVO hotelManager ,String hotel_ID);
	
	public HotelManagerVO getHotelManagerInfo(String hotel_ID);
	
	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo , String hotel_ID);
	
	public ResultMessage addWebBusiness(WebBusinessVO  webBusinessInfo);
	
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID);
	
	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo , String webBusiness_ID);
	
	public Identity getAccountIdentity(AccountVO accountVO);
	
}
