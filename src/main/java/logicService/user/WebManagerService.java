package logicService.user;

import Message.ResultMessage;
import vo.HotelManagerVO;
import vo.WebBusinessVO;

/**
 * 有关网站管理人员基本信息以及对其他用户基本信息管理的接口
 * @author Mark.W
 *
 */
public interface WebManagerService {
	
	/**
	 * 获取酒店管理人员信息
	 * @param hotel_ID
	 * @return
	 */
	public HotelManagerVO getHotelManagerInfo(String hotel_ID);
	
	/**
	 * 添加酒店管理人员
	 * @param hotelManager
	 * @return
	 */
	public ResultMessage addHotelManager(HotelManagerVO hotelManager);
	
	/**
	 * 更新酒店管理人员的信息
	 * @param hotelManagerInfo
	 * @return
	 */
	public ResultMessage updateHotelManagerInfo(HotelManagerVO hotelManagerInfo);
	
	/**
	 * 添加网站营销人员
	 * @param webBusinessInfo
	 * @return
	 */
	public ResultMessage addWebBusiness(WebBusinessVO webBusinessInfo);
	
	/**
	 * 获取网站管理人员的信息
	 * @param webBusiness_ID
	 * @return
	 */
	public WebBusinessVO getWebBusinessInfo(String webBusiness_ID);
	
	/**
	 * 更新网站营销人员的信息
	 * @param webBusinessInfo
	 * @return
	 */
	public ResultMessage updateWebBusinessInfo(WebBusinessVO webBusinessInfo);
		
}
