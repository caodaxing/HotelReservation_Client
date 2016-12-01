package logicService.user;

import Message.ResultMessage;
import vo.HotelManagerVO;
import vo.HotelVO;
import vo.WebBusinessVO;

/**
 * 有关网站管理人员基本信息以及对其他用户基本信息管理的接口
 * @author Mark.W
 *
 */
public interface WebManagerService {
	
	public ResultMessage addHotel(HotelVO hotelVO);
	
	public HotelManagerVO getHotelManagerInfo(String hotel_ID);
	
	public ResultMessage addHotelManager(HotelManagerVO hotelManager);
	
	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo);
	
	public ResultMessage addWebBusiness(WebBusinessVO webBusinessInfo);
	
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID);
	
	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo);
		
}
