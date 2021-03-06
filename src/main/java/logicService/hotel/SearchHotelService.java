package logicService.hotel;

import java.util.ArrayList;

import Message.HotelSearchCondition;
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
	 * @param city 传入酒店城市
	 * @return ArrayList<String> 返回商圈列表
	 * @author all
	 */
	public ArrayList<String> getTradingArea (String city);
	
	/**
	 * 获取所有商圈
	 * @author all
	 */
	public ArrayList<String> getCities();
	
	/**
	 * 将搜索到的酒店按一定方式排列
	 * @param HotelSerchCondition 传入需要排序的标准
	 * @param ArrayList<HotelVO> 传入需要排序的酒店列表
	 * @return ArrayList<HotelInfoVO> 返回按一定方式排序的酒店列表
	 * @author all
	 */
	public ArrayList<HotelVO> getSortedList(HotelSearchCondition condition, ArrayList<HotelVO> hotels);
	
	/**
	 * 获取用户预定过的酒店列表a
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
	public ArrayList<HotelVO> search(HotelSearchVO search);
}
