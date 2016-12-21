package logicService.user;

import vo.HotelManagerVO;

/**
 * 酒店工作人员基本信息处理的接口
 * @author Mark.W
 *
 */
public interface HotelManagerService {

	/**
	 * 获取酒店管理人员信息
	 * @param hotel_ID
	 * @return
	 */
	public HotelManagerVO getHotelManagerInfo(String hotel_ID);
	
}

