package logic.user;

import java.util.*;

import Message.Identity;
import Message.ResultMessage;
import logic.account.Account;
import vo.ClientVO;
import vo.HotelManagerVO;
import vo.VIPInfoVO;
import vo.AccountVO;
import vo.HotelInfoVO;
import vo.WebBusinessVO;

/**
 * UserController
 * @author Xue.W
 */
public class UserController {
	
	Client client;
	HotelManager hm;
	WebBusiness webBusiness;
	WebManager webManager;
	Account account;
	
	public UserController() {
		client = new Client();
		hm = new HotelManager();
		webBusiness = new WebBusiness();
		webManager = new WebManager();
		account = new Account();
	}
	
	public ClientVO getUserInfo(String user_ID){
		return client.getUserInfo(user_ID);
	}
	
	public ResultMessage updateUserInfo(ClientVO new_userInfo , String user_ID){
		return client.updateUserInfo(new_userInfo);
	}
	
	public ResultMessage setVIP(VIPInfoVO VIPInfo , String user_ID){
		return client.setVIP(VIPInfo, user_ID);
	}
	
	public VIPInfoVO getVIPInfo (String user_ID){
		return client.getVIPInfo(user_ID);
	}
	
	public ArrayList<HotelInfoVO> getHistoryHotelInfo(String user_ID){
		return client.getHistoryHotelInfo(user_ID);
	}
	
	public ResultMessage addHotelManagerInfo(HotelManagerVO hotelManager ,String hotel_ID){
		return hm.addHotelManagerInfo(hotelManager , hotel_ID);
	}
	
	public HotelManagerVO getHotelManagerInfo(String hotel_ID){
		return hm.getHotelManagerInfo(hotel_ID);
	}
	
	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo , String hotel_ID){
		return hm.updateHotelManagerInfo(hotelManagerInfo, hotel_ID);
	}
	
	public ResultMessage addWebBusiness(WebBusinessVO  webBusinessInfo){
		return webBusiness.addWebBusiness(webBusinessInfo);
	}
	
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID){
		return webBusiness.getWebBusinessInfo(webBusiness_ID);
	}
	
	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo , String webBusiness_ID){
		return webBusiness.updateWebBusinessInfo(webBusinessInfo, webBusiness_ID);
	}
	
	/**
	 * 获得用户种类
	 * @param accountVO 传入的账户信息
	 * @return 返回用户类型
	 * @author Xue.W
	 */
	public Identity getAccountIdentity(AccountVO accountVO){
		return account.getIdentity(accountVO);
	}
	
}
