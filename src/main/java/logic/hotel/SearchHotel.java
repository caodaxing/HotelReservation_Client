package logic.hotel;

import java.util.ArrayList;

import vo.HotelSearchVO;
import vo.HotelVO;

/**
 * 搜索酒店
 * @author all
 *
 */
public class SearchHotel {
	/**
	 * 获取酒店所在商圈
	 * @param location 传入酒店地址
	 * @return ArrayList<String> 返回商圈列表
	 * @author all
	 */
	public ArrayList<String> getTradingArea (String location){
		return null;
	}
	
	/**
	 * 获取指定地址指定商圈符合条件的酒店列表
	 * @param location 传入酒店地址
	 * @param tradingArea 传入商圈
	 * @return ArrayList<HotelInfoVO> 返回酒店列表
	 * @author all
	 */
	public ArrayList<HotelVO> getInitialHotelList (String location,String tradingArea ){
		return null;
	}
	
	/**
	 * 获取按一定方式排序的酒店列表
	 * @return ArrayList<HotelInfoVO> 返回按一定方式排序的酒店列表
	 * @author all
	 */
	public ArrayList<HotelVO> getSortedList(){
		return null;
	}
	
	/**
	 * 获取用户预定过的酒店列表
	 * @param user_id 传入用户id
	 * @return ArrayList<HotelInfoVO> 返回用户预定过的酒店列表
	 * @author all
	 */
	public ArrayList<HotelVO> getBookedHotelList (String user_id){
		return null;
	}
	
	/**
	 * 返回指定的酒店信息
	 * @param search 传入的VO信息
	 * @return HotelInfoVO 返回指定的酒店信息
	 * @author all
	 */
	public HotelVO search(HotelSearchVO search){
		return null;
	}
}
