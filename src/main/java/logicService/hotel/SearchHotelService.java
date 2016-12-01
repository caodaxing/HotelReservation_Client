package logicService.hotel;

import java.util.ArrayList;

import vo.HotelSearchVO;
import vo.HotelVO;

/**
 * 有关搜索酒店服务的接口
 * @author Mark.W
 *
 */
public interface SearchHotelService {
	
	/**
	 * 获取酒店所在商圈
	 * @param location 传入酒店地址
	 * @return ArrayList<String> 返回商圈列表
	 * @author all
	 */
	public ArrayList<String> getTradingArea (String location);
	
	/**
	 * 获取按一定方式排序的酒店列表
	 * @return ArrayList<HotelInfoVO> 返回按一定方式排序的酒店列表
	 * @author all
	 */
	public ArrayList<HotelVO> getSortedList();
	
	/**
	 * 获取用户预定过的酒店列表
	 * @param user_id 传入用户id
	 * @return ArrayList<HotelInfoVO> 返回用户预定过的酒店列表
	 * @author all
	 */
	public ArrayList<HotelVO> getBookedHotelList(String user_id);
	
	/**
	 * 返回指定的酒店信息
	 * @param search 传入的VO信息
	 * @return HotelInfoVO 返回指定的酒店信息
	 * @author all
	 */
	public HotelVO search(HotelSearchVO search);
}
