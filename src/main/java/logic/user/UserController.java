package logic.user;

import java.util.ArrayList;

import Message.Identity;
import Message.ResultMessage;
import logic.account.Account;
import logic.account.AccountInfo;
import logicService.UserService;
import vo.AccountVO;
import vo.ClientVO;
import vo.HotelManagerVO;
import vo.HotelVO;
import vo.VIPInfoVO;
import vo.WebBusinessVO;

public class UserController implements UserService{
	
	private Client client;
	private HotelManager hotelManager;
	private WebBusiness webBusiness;
	private WebManager webManager;
	private AccountInfo account;
	
	public UserController() {
		client = new Client();
		hotelManager = new HotelManager();
		webBusiness = new WebBusiness();
		webManager = new WebManager();
		account = new Account();
	}
	
	@Override
	public ClientVO getClientInfo(String user_ID){
		return client.getClientInfo(user_ID);
	}
	
	public ResultMessage updateClientInfo(ClientVO new_userInfo){
		return client.updateUserInfo(new_userInfo);
	}
	
	public ResultMessage setVIP(VIPInfoVO VIPInfo ){
		return client.setVIP(VIPInfo);
	}
	
	public VIPInfoVO getVIPInfo (String user_ID){
		return client.getVIPInfo(user_ID);
	}
	
	public ArrayList<HotelVO> getHistoryHotels(String user_ID){
		return client.getHistoryHotels(user_ID);
	}
	
	public ResultMessage addHotel(HotelVO hotelVO){
		return webManager.addHotel(hotelVO);
	}
	
	public ResultMessage addHotelManager(HotelManagerVO hotelManager){
		return webManager.addHotelManager(hotelManager);
	}
	
	public ResultMessage addWebBusiness(WebBusinessVO  webBusinessVO){
		return webManager.addWebBusiness(webBusinessVO);
	}
	
	
	
	public HotelManagerVO getHotelManagerInfo(String hotel_ID){
		return hotelManager.getHotelManagerInfo(hotel_ID);
	}
	
	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo){
		return hotelManager.updateHotelManagerInfo(hotelManagerInfo);
	}
	
	
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID){
		return webBusiness.getWebBusinessInfo(webBusiness_ID);
	}
	
	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo){
		return webBusiness.updateWebBusinessInfo(webBusinessInfo);
	}
	
	public Identity getAccountIdentity(AccountVO accountVO){
		return account.getIdentity(accountVO);
	}

}
