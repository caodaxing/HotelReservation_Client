package logic.user;

import Message.ResultMessage;
import dataDao.WebManagerDao;
import vo.HotelManagerVO;
import vo.HotelVO;
import vo.WebBusinessVO;

/**
 * 管理网站管理人员信息的类
 * @author Xue.W
 */
public class WebManager{
	
	WebManagerDao webManagerDao;
	
	public WebManager(){}

	public ResultMessage addHotel(HotelVO hotelVO){
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage addHotelManager(HotelManagerVO hotelManager){
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage addWebBusiness(WebBusinessVO  webBusinessVO){
		return ResultMessage.SUCCESS;
	}
	
}
