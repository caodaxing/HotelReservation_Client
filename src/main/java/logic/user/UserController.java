package logic.user;


import Message.ResultMessage;
import logic.account.Account;
import logic.account.AccountInfo;
import logicService.UserService;
import vo.ClientVO;
import vo.HotelManagerVO;
import vo.HotelVO;
import vo.VipVO;
import vo.WebBusinessVO;

public class UserController implements UserService{
	
	private Client client;
	private HotelManager hotelManager;
	private WebBusiness webBusiness;
	private WebManager webManager;
	
	public UserController() {
		client = new Client();
		hotelManager = new HotelManager();
		webBusiness = new WebBusiness();
		webManager = new WebManager();
	}
	
	//client
	@Override
	public ClientVO getClientInfo(String user_ID){
		return client.getClientInfo(user_ID);
	}
	
	public ResultMessage updateClientInfo(ClientVO new_userInfo){
		return client.updateClientInfo(new_userInfo);
	}
	
	public ResultMessage registerVIP(VipVO VIPInfo){
		return client.registerVIP(VIPInfo);
	}
	
	@Override
	public boolean isVIP(String userID) {
		return client.isVIP(userID);
	}
	
	//webManager
	public ResultMessage addHotel(HotelVO hotelVO){
		return webManager.addHotel(hotelVO);
	}
	
	public ResultMessage addHotelManager(HotelManagerVO hotelManager){
		return webManager.addHotelManager(hotelManager);
	}
	
	public ResultMessage addWebBusiness(WebBusinessVO  webBusinessVO){
		return webManager.addWebBusiness(webBusinessVO);
	}
	
	
	//hotelManager
	public HotelManagerVO getHotelManagerInfo(String hotel_ID){
		return hotelManager.getHotelManagerInfo(hotel_ID);
	}
	
	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo){
		return hotelManager.updateHotelManagerInfo(hotelManagerInfo);
	}
	
	//webBusiness
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID){
		return webBusiness.getWebBusinessInfo(webBusiness_ID);
	}
	
	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo){
		return webBusiness.updateWebBusinessInfo(webBusinessInfo);
	}

	
}
