package logic.hotel;

import vo.HotelInfoVO;

/**
 * 给order提供的获取酒店信息的接口
 * @author all
 *
 */
public interface HotelItem {
	public HotelInfoVO getHotelItemInfo (String hotel_id);
}
