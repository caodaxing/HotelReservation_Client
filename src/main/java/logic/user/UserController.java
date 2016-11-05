package logic.user;

import java.util.*;

import vo.UserVO;
import vo.HotelManagerVO;
import vo.VIPInfoVO;
import vo.HotelInfoVO;
import vo.WebBusinessVO;

public class UserController {
	
	public UserVO getUserInfo(String user_ID){
		return null;
	}
	
	public boolean updateUserInfo(UserVO new_userInfo , String user_ID){
		return false;
	}
	
	public boolean setVIP(UserVO VIPInfo , String user_ID){
		return false;
	}
	
	public VIPInfoVO getVIPInfo (String user_ID){
		return null;
	}
	
	public ArrayList<HotelInfoVO> getHistoryHotelInfo(String user_ID){
		return null;
	}
	
	public boolean addHotelManagerInfo(HotelManagerVO hotelManager ,String hotel_ID){
		return false;
	}
	
	public HotelManagerVO getHotelManagerInfo(String hotel_ID){
		return null;
	}
	
	public boolean updateHotelManagerInfo(HotelManagerVO hotelManagerInfo , String hotel_ID){
		return false;
	}
	
	public boolean addWebBusiness(WebBusinessVO  webBusinessInfo){
		return false;
	}
	
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID){
		return null;
	}
	
	public boolean updateWebBusinessInfo(WebBusinessVO webBusinessInfo , String webBusiness_ID){
		return false;
	}
	
}
