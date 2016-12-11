package logic.hotel;

import java.util.ArrayList;

import Message.HotelSearchCondition;
import dataDao.hotel.HotelDao;
import dataDao.stub.HotelDao_Stub;
import factories.HotelSortFactory;
import logic.mockObject.MockOrderHotelInfo;
import logic.order.OrderHotelInfo;
import logic.utility.HotelTransform;
import logicService.hotel.SearchHotelService;
import po.HotelPO;
import vo.HotelSearchVO;
import vo.HotelVO;

/**
 * 搜索酒店
 * 
 * @author all
 *
 */
public class SearchHotel implements SearchHotelService {

	private HotelDao hotelDao;
	private OrderHotelInfo getBookedHotelList;
	private HotelSort hotelSort;

	public SearchHotel() {
		hotelDao = new HotelDao_Stub();
		
		getBookedHotelList = new MockOrderHotelInfo();
	}

	/**
	 * 获取酒店所在商圈
	 * @param distract   传入酒店所属行政区
	 * @return ArrayList<String> 返回商圈列表
	 * @author all
	 */
	public ArrayList<String> getTradingArea(String distract) {
		hotelDao = new HotelDao_Stub();
		return hotelDao.getTradingAreas(distract);
	}

	/**
	 * 获取指定地址指定商圈符合条件的酒店列表
	 * @param city 传入酒店所属城市
	 * @param distract 传入酒店所属行政区
	 * @param tradingArea  传入商圈
	 * @return ArrayList<HotelInfoVO> 返回酒店列表
	 * @author all
	 */
	public ArrayList<HotelVO> getInitialHotelList(String city, String distract, String tradingArea) {
		ArrayList<HotelPO> hotelPOList = hotelDao.SearchHotelList(city, distract, tradingArea);
		
		ArrayList<HotelVO> hotelVOList = new ArrayList<HotelVO>();
		
		for (HotelPO hotelPO : hotelPOList) {
			hotelVOList.add(HotelTransform.hotelTransToVO(hotelPO));
		}
		
		return hotelVOList;
	}

	/**
	 * 将搜索到的酒店按一定方式排列
	 * @param HotelSerchCondition   传入需要排序的标准
	 * @param ArrayList<HotelVO>   传入需要排序的酒店列表
	 * @return ArrayList<HotelInfoVO> 返回按一定方式排序的酒店列表
	 * @author all
	 */
	public ArrayList<HotelVO> getSortedList(HotelSearchCondition condition, ArrayList<HotelVO> hotels) {
		
		if (condition == null || hotels == null) {
			System.out.println("logic.hotel.SearchHotel.getSortedList参数错误");
			return null;
		}
		
		if (hotels.size() == 1) {
			return hotels;
		}
		
		this.hotelSort = HotelSortFactory.getInstance().createHotelSort(condition);
		
		return this.hotelSort.getSortedList(condition, hotels);
		
//		PriceSort priceSort = new PriceSort();
//		GradeSort gradeSort = new GradeSort();
//		StarSort starSort = new StarSort();
//		if (condition == null || hotels == null) {
//			System.out.println("logic.hotel.SearchHotel.getSortedList参数错误");
//			return null;
//		}
//		
//		if (hotels.size() == 1) {
//			return hotels;
//		}
//		
//		switch (condition) {
//		case PRICE_DOWN:
//			return priceSort.getSortedList(condition, hotels);
//		case PRICE_UP:
//			return priceSort.getSortedList(condition, hotels);
//		case GRADE_DOWN:
//			return gradeSort.getSortedList(condition, hotels);
//		case GRADE_UP:
//			return gradeSort.getSortedList(condition, hotels);
//		case STAT_DOWN:
//			return starSort.getSortedList(condition, hotels);
//		case STAR_UP:
//			return starSort.getSortedList(condition, hotels);
//		default:
//			System.out.println("logic.hotel.SearchHotel.getSortedList参数错误");
//			break;
//		}
//		return null;
	}

	/**
	 * 获取用户预定过的酒店列表
	 * @param userID   传入用户id
	 * @return ArrayList<HotelInfoVO> 返回用户预定过的酒店列表
	 * @author all
	 */
	public ArrayList<HotelVO> getBookedHotelList(String userID) {
		ArrayList<String> hotelIds = getBookedHotelList.getBookedHotelList(userID);
		
		ArrayList<HotelVO> bookedHotelList = new ArrayList<>();
		
		for (String hotelId : hotelIds) {
			bookedHotelList.add(HotelTransform.hotelTransToVO(hotelDao.getHotelInfoByHotelID(hotelId)));
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
		
		if (search == null || search.city == null || search.city == "" || search.starLow > search.starHigh
				|| search.commentLow > search.commentHigh || search.priceLow > search.priceHigh) {
			System.out.println("logic.hotel.SearchHotel.search参数错误");
			return null;
		}
		
		ArrayList<HotelVO> hotelList = getInitialHotelList(search.city, search.distract, search.tradingArea);
		if (hotelList == null) {
			return null;
		}
		
		if (search.hotelName != null || search.hotelName != "") {
			for (HotelVO hotelVO : hotelList) {
				if (hotelVO.hotelName != search.hotelName) {
					hotelList.remove(hotelVO);
				}
			}
		}
		
		if (search.starLow >= 0 && search.starHigh <= 5 && search.starHigh >= 0 && search.starHigh <= 5) {
			StarSort starSort = new StarSort();
			hotelList = starSort.getSortedList(search.starLow, search.starLow, HotelSearchCondition.STAT_DOWN,
					hotelList);
		}
		
		if (search.priceLow != -1) {
			PriceSort priceSort = new PriceSort();
			priceSort.getSortedList(search.priceLow, search.priceHigh, HotelSearchCondition.PRICE_UP, hotelList);
		}
		
		if (search.commentLow >= 0 && search.commentLow < 5 || search.commentHigh > 0 && search.commentHigh <= 5) {
			GradeSort gradeSort = new GradeSort();
			gradeSort.getSortedList(search.commentLow, search.commentHigh, HotelSearchCondition.GRADE_DOWN, hotelList);
		}
		
		return hotelList;
	}

}
