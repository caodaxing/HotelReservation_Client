package logicService.user;

import vo.HotelManagerVO;

/**
 * 酒店工作人员基本信息处理的接口
 * @author Mark.W
 *
 */
public interface HotelManagerService {

	public HotelManagerVO getHotelManagerInfo(String hotel_ID);
	
}

