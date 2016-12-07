package logic.hotel;

import java.util.ArrayList;

import vo.HotelVO;

/**
 * 按星级排序
 * @author all
 *
 */
public class StarSort {
	/**
	 * 将酒店按星级排序
	 * @param startStar 最低星级
	 * @param endStar 最高星级
	 * @return ArrayList<HotelVO> 返回按星级排序好的酒店名称列表
	 * @author all
	 */
	public ArrayList<HotelVO> getSortedList(double starStar,double endStar,ArrayList<HotelVO> hotels){
		if (hotels==null || starStar>=endStar) {
			return null;
		}
		ArrayList<HotelVO> sortedHotels = new ArrayList<>();
		ArrayList<HotelVO> temp = new ArrayList<>();
		for (HotelVO hotelVO : temp) {
			if (hotelVO.levelOfHotel>=starStar&&hotelVO.levelOfHotel<=endStar) {
				temp.add(hotelVO);
			}
		}
		return null;
	}
}
