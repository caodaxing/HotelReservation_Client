package logic.user;

import java.util.*;

import vo.UserVO;
import vo.VIPInfoVO;
import vo.HotelInfoVO;
import logic.credit.*;

public class User {
	
	public UserVO getUserInfo (String user_ID){
		return null;
	}
	
	public boolean updateUserInfo(UserVO new_userInfo){
		return false;
	}
	
	public boolean setVIP(VIPInfoVO VIPInfo , String user_ID){
		return false;
	}
	
	public VIPInfoVO getVIPInfo(String user_ID){
		return null;
	}
	
	public ArrayList<HotelInfoVO> getHistoryHotelInfo(String user_ID){
		return null;
	}
	
}
