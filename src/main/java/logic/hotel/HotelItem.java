package logic.hotel;

import vo.HotelVO;

/**
 * 给order提供的获取酒店信息的接口
 * @author all
 *
 */
public interface HotelItem {
	public HotelVO getHotelItemInfo (String hotel_id);
}
