package logicService;

import Message.ResultMessage;
import vo.HotelManagerVO;
import vo.HotelVO;
import vo.WebBusinessVO;

public interface WebManagerService {
	
	public ResultMessage addHotel(HotelVO hotelVO);
	
	public HotelManagerVO getHotelManagerInfo(String hotel_ID);
	
	public ResultMessage addHotelManager(HotelManagerVO hotelManager);
	
	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo);
	
	public ResultMessage addWebBusiness(WebBusinessVO webBusinessInfo);
	
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID);
	
	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo);
		
}
