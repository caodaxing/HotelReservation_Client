package logic.hotel;

import java.util.ArrayList;

import Message.HotelSearchCondition;
import dataDao.HotelDao;
import dataDao.stub.HotelDao_Stub;
import logic.utility.HotelTransform;
import logicService.hotel.SearchHotelService;
import po.HotelPO;
import vo.HotelSearchVO;
import vo.HotelVO;

/**
 * 搜索酒店
 * @author all
 *
 */
public class SearchHotel implements SearchHotelService{
	
	HotelDao hotelDao;
	
	public SearchHotel() {
		hotelDao = new HotelDao_Stub();
	}
	
	/**
	 * 获取酒店所在商圈
	 * @param location 传入酒店地址
	 * @return ArrayList<String> 返回商圈列表
	 * @author all
	 */
	public ArrayList<String> getTradingArea (String location){
		hotelDao = new HotelDao_Stub();
		return hotelDao.getTradingAreas(location);
	}
	
	/**
	 * 获取指定地址指定商圈符合条件的酒店列表
	 * @param city 传入酒店所属城市
	 * @param distract 传入酒店所属行政区
	 * @param tradingArea 传入商圈
	 * @return ArrayList<HotelInfoVO> 返回酒店列表
	 * @author all
	 */
	public ArrayList<HotelVO> getInitialHotelList (String city,String distract,String tradingArea ){
		ArrayList<HotelPO> hotelPOList = hotelDao.SearchHotelList(city,distract,tradingArea);
		ArrayList<HotelVO> hotelVOList = new ArrayList<>();
		for (HotelPO hotelPO : hotelPOList) {
			hotelVOList.add(HotelTransform.hotelTransToVO(hotelPO));
		}
		return hotelVOList;
	}
	
	/**
	 * 将搜索到的酒店按一定方式排列
	 * @param HotelSerchCondition 传入需要排序的标准
	 * @param ArrayList<HotelVO> 传入需要排序的酒店列表
	 * @return ArrayList<HotelInfoVO> 返回按一定方式排序的酒店列表
	 * @author all
	 */
	public ArrayList<HotelVO> getSortedList(HotelSearchCondition condition , ArrayList<HotelVO> hotels){
		PriceSort priceSort = new PriceSort();
		GradeSort gradeSort = new GradeSort();
		StarSort starSort = new StarSort();
		if (condition==null||hotels==null) {
			System.out.println("logic.hotel.SearchHotel.getSortedList参数错误");
			return null;
		}
		if (hotels.size()==1) {
			return hotels;
		}
		switch (condition) {
		case PRICE_DOWN:
			return priceSort.getSortedList(condition, hotels);
		case PRICE_UP:
			return priceSort.getSortedList(condition, hotels);
		case GRADE_DOWN:
			return gradeSort.getSortedList(condition, hotels);
		case GRADE_UP:
			return gradeSort.getSortedList(condition, hotels);
		case STAT_DOWN:
			return starSort.getSortedList(condition, hotels);
		case STAR_UP:
			return starSort.getSortedList(condition, hotels);
		default:
			System.out.println("logic.hotel.SearchHotel.getSortedList参数错误");
			break;
		}
		return null;
	}
	
	/**
	 * 获取用户预定过的酒店列表
	 * @param userID 传入用户id
	 * @return ArrayList<HotelInfoVO> 返回用户预定过的酒店列表
	 * @author all
	 */
	public ArrayList<HotelVO> getBookedHotelList (String userID){
		ArrayList<String> hotelNames = hotelDao.getBookedHotelID(userID);
		ArrayList<HotelVO> bookedHotelList = new ArrayList<>();
		for (String string : hotelNames) {
			bookedHotelList.add(HotelTransform.hotelTransToVO(hotelDao.getHotelInfoByHotelID(string)));
		}
		return bookedHotelList;
	}

	/**
	 * 返回指定的酒店信息
	 * @param search 传入的VO信息
	 * @return HotelInfoVO 返回指定的酒店信息
	 * @author all
	 */
	@Override
	public ArrayList<HotelVO> search(HotelSearchVO search) {
		if (search==null||search.city==null) {
			System.out.println("logic.hotel.SearchHotel.search参数错误");
			return null;
		}
		ArrayList<HotelPO> hotelPOList = hotelDao.SearchHotelList(search.city, search.distract,search.tradingArea, search.hotelName);
		if (hotelPOList==null) {
			return null;
		}else {
			ArrayList<HotelVO> hotelList = new ArrayList<>();
			for (HotelPO hotelPO : hotelPOList) {
				hotelList.add(HotelTransform.hotelTransToVO(hotelPO));
			}
			return  hotelList;
		}
	}

}
