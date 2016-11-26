package logicService;

import java.util.ArrayList;

import Message.Identity;
import Message.ResultMessage;
import vo.AccountVO;
import vo.ClientVO;
import vo.HotelManagerVO;
import vo.HotelVO;
import vo.VIPInfoVO;
import vo.WebBusinessVO;

public interface UserService {
	
	//客户
	public ClientVO getClientInfo(String user_ID);
	
	public ResultMessage updateClientInfo(ClientVO new_userInfo);
	
	public ResultMessage setVIP(VIPInfoVO VIPInfo);
	
	public VIPInfoVO getVIPInfo (String user_ID);
	
	public ArrayList<HotelVO> getHistoryHotels(String user_ID);
	
	
	//网站管理人员
	public ResultMessage addHotel(HotelVO hotelVO);
	
	public ResultMessage addHotelManager(HotelManagerVO hotelManager);
	
	
	public HotelManagerVO getHotelManagerInfo(String hotel_ID);
	
	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo);
	
	public ResultMessage addWebBusiness(WebBusinessVO webBusinessInfo);
	
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID);
	
	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo);
	
	public Identity getAccountIdentity(AccountVO accountVO);
	
}
