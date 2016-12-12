package logic.hotel;

import java.util.ArrayList;

import vo.HotelVO;

/**
 * 按星级排序
 * 默认是星级从高到低
 * @author all
 *
 */
public class StarSort implements HotelSort{

	private  UpOrDownSort sort;
	
	public StarSort() {
		this.sort = new Down();
	}

	public StarSort(UpOrDownSort sort) {
		this.sort = sort;
	}
	
	/**
	 * 根据酒店星级进行排序
	 * @param condition
	 * @param hotels
	 * @return
	 */
	public ArrayList<HotelVO> getSortedList(ArrayList<HotelVO> hotels) {
		if (hotels == null || hotels.size() == 0) {
			System.out.println("logic.hotel.starSort.getSortedList参数异常");
			return null;
		}
		
		if(hotels.size() == 1) {
			return hotels;
		}
		
		ArrayList<HotelVO> sortedHotels = new ArrayList<>();
		// 对符合排序条件的酒店进行排序
		HotelVO[] hotelArray = new HotelVO[hotels.size()];
		for (int i = 0; i < hotels.size(); i++) {
			hotelArray[i] = hotels.get(i);
		}
		
		for (int i = hotelArray.length - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (sort.compare(hotelArray[j].levelOfHotel, hotelArray[j + 1].levelOfHotel)) {
					HotelVO temp = hotelArray[j];
					hotelArray[j] = hotelArray[j + 1];
					hotelArray[j + 1] = temp;
				}
			}
		}
	

		for (HotelVO hotelVO : hotelArray) {
			sortedHotels.add(hotelVO);
		}
		return sortedHotels;

	}

	/**
	 * 将酒店按星级排序
	 * @param startStar 最低星级
	 * @param endStar 最高星级
	 * @return ArrayList<HotelVO> 返回按星级排序好的酒店名称列表
	 * @author all
	 */
	public ArrayList<HotelVO> getSpecificSectionHotelList(double startStar, double endStar, ArrayList<HotelVO> hotels) {
		if (hotels == null || startStar > endStar ) {
System.out.println("logic.hotel.starSort.getSortedList参数异常");
			return null;
		}
		
		// 获取符合排序条件的酒店列表
		ArrayList<HotelVO> hotelList = new ArrayList<HotelVO>();
		for (int i=0; i<hotels.size(); ++i) { 
			HotelVO hotelVO = hotels.get(i);
			if ((double)hotelVO.levelOfHotel >= startStar && (double)hotelVO.levelOfHotel <= endStar) {
				hotelList.add(hotelVO);
			}
		}
		
		return this.getSortedList(hotelList);
	}
}
