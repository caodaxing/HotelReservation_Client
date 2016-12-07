package logic.hotel;

import java.util.ArrayList;

import vo.HotelVO;

/**
 * 按价格排序
 * @author all
 *
 */
public class PriceSort {
	/**
	 * 讲酒店按价格排序
	 * @param startPrice 最低价格
	 * @param endPrice 最高价格
	 * @return ArrayList<HotelVO> 返回按价格排序好的酒店名称列表
	 * @author all
	 */
	public ArrayList<HotelVO> getSortedList(double startPrice,double endPrice,ArrayList<HotelVO> hotels){
		if (hotels==null || startPrice>=endPrice) {
			return null;
		}
		ArrayList<HotelVO> sortedHotels = new ArrayList<>();
		ArrayList<HotelVO> temp = new ArrayList<>();
		for (HotelVO hotelVO : temp) {
		}
		return null;
	}
}
