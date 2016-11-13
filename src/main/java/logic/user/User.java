package logic.user;

import java.util.*;

import vo.UserVO;
import vo.VIPInfoVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.AccountVO;
import logic.credit.*;
import logic.order.*;
import logic.account.*;
import Message.Identity;

public class User {
	String user_ID;
	UserVO userVO ;
	
	Order order = new Order();
	Credit credit = new Credit();
	Account account = new Account();
	AccountVO accountVO ;
	
	public User(UserVO userVO){
		this.userVO = userVO;
	}
	
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
	
	public int getCredit(){
		return credit.getCredit(user_ID);
	}
	
	public OrderVO getOrderInfo(){
		return order.getOrderInfo(user_ID);
	}
	
	public int getVIPCredit(){
		return credit.getVIPCredit();
	}
	
	public Identity getAccountIdentity(){
		return account.getIdentity(accountVO);
	}
	
}
