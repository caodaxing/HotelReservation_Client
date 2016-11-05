package logic.user;

import java.util.*;

import vo.UserVO;
import vo.HotelManagerVO;
import vo.VIPInfoVO;
import vo.HotelInfoVO;
import vo.WebBusinessVO;

public class UserController {
	
	User user = new User();
	HotelManager hm = new HotelManager();
	WebBusiness webBusiness = new WebBusiness();
	WebManager webManager = new WebManager();
	
	public UserVO getUserInfo(String user_ID){
		return user.getUserInfo(user_ID);
	}
	
	public boolean updateUserInfo(UserVO new_userInfo , String user_ID){
		return user.updateUserInfo(new_userInfo);
	}
	
	public boolean setVIP(VIPInfoVO VIPInfo , String user_ID){
		return user.setVIP(VIPInfo, user_ID);
	}
	
	public VIPInfoVO getVIPInfo (String user_ID){
		return user.getVIPInfo(user_ID);
	}
	
	public ArrayList<HotelInfoVO> getHistoryHotelInfo(String user_ID){
		return user.getHistoryHotelInfo(user_ID);
	}
	
	public boolean addHotelManagerInfo(HotelManagerVO hotelManager ,String hotel_ID){
		return hm.addHotelManagerInfo(hotelManager , hotel_ID);
	}
	
	public HotelManagerVO getHotelManagerInfo(String hotel_ID){
		return hm.getHotelManagerInfo(hotel_ID);
	}
	
	public boolean updateHotelManagerInfo(HotelManagerVO hotelManagerInfo , String hotel_ID){
		return hm.updateHotelManagerInfo(hotelManagerInfo, hotel_ID);
	}
	
	public boolean addWebBusiness(WebBusinessVO  webBusinessInfo){
		return webBusiness.addWebBusiness(webBusinessInfo);
	}
	
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID){
		return webBusiness.getWebBusinessInfo(webBusiness_ID);
	}
	
	public boolean updateWebBusinessInfo(WebBusinessVO webBusinessInfo , String webBusiness_ID){
		return webBusiness.updateWebBusinessInfo(webBusinessInfo, webBusiness_ID);
	}
	
}
