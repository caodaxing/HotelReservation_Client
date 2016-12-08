package logic.hotel;

import java.util.ArrayList;

import Message.HotelSearchCondition;
import vo.HotelVO;

/**
 * 按星级排序
 * @author all
 *
 */
public class StarSort {
	
	/**
	 * 根据酒店星级进行排序
	 * @param condition
	 * @param hotels
	 * @return
	 */
	public ArrayList<HotelVO> getSortedList(HotelSearchCondition condition ,ArrayList<HotelVO> hotels){
		if (hotels==null || condition!=HotelSearchCondition.STAR_UP || condition!=HotelSearchCondition.STAT_DOWN) {
			System.out.println("logic.hotel.starSort.getSortedList参数异常");
			return null;
		}
		ArrayList<HotelVO> sortedHotels = new ArrayList<>();
		//对符合排序条件的酒店进行排序
		HotelVO[] hotelArray = new HotelVO[hotels.size()];
		for (int i = 0; i < hotels.size(); i++) {
			hotelArray[i] = hotels.get(i);
		}
		if (condition==HotelSearchCondition.STAR_UP) {								//升序
			for (int i = hotelArray.length - 1; i > 0; --i){
				for (int j = 0; j < i; ++j){
					if (hotelArray[j].levelOfHotel<=hotelArray[j+1].levelOfHotel) {
						HotelVO temp = hotelArray[j];
						hotelArray[j] = hotelArray[j+1];
						hotelArray[j+1] = temp;
					}
				}
			}
		}else {																		//降序
			for (int i = hotelArray.length - 1; i > 0; --i){
				for (int j = 0; j < i; ++j){
					if (hotelArray[j].levelOfHotel<=hotelArray[j+1].levelOfHotel) {
						HotelVO temp = hotelArray[j];
						hotelArray[j] = hotelArray[j+1];
						hotelArray[j+1] = temp;
					}
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
	public ArrayList<HotelVO> getSortedList(double starStar,double endStar,HotelSearchCondition condition ,ArrayList<HotelVO> hotels){
		if (hotels==null || starStar>endStar ||condition!=HotelSearchCondition.STAR_UP || condition!=HotelSearchCondition.STAT_DOWN) {
			System.out.println("logic.hotel.starSort.getSortedList参数异常");
			return null;
		}
		ArrayList<HotelVO> sortedHotels = new ArrayList<>();
		//获取符合排序条件的酒店列表
		ArrayList<HotelVO> hotelList = new ArrayList<>();
		for (HotelVO hotelVO : hotelList) {
			if (hotelVO.levelOfHotel>=starStar&&hotelVO.levelOfHotel<=endStar) {
				hotelList.add(hotelVO);
			}
		}
		//对符合排序条件的酒店进行排序
		HotelVO[] hotelArray = new HotelVO[hotelList.size()];
		for (int i = 0; i < hotelList.size(); i++) {
			hotelArray[i] = hotelList.get(i);
		}
		if (condition==HotelSearchCondition.STAR_UP) {								//升序
			for (int i = hotelArray.length - 1; i > 0; --i){
				for (int j = 0; j < i; ++j){
					if (hotelArray[j].levelOfHotel<=hotelArray[j+1].levelOfHotel) {
						HotelVO temp = hotelArray[j];
						hotelArray[j] = hotelArray[j+1];
						hotelArray[j+1] = temp;
					}
				}
			}
		}else {																		//降序
			for (int i = hotelArray.length - 1; i > 0; --i){
				for (int j = 0; j < i; ++j){
					if (hotelArray[j].levelOfHotel<=hotelArray[j+1].levelOfHotel) {
						HotelVO temp = hotelArray[j];
						hotelArray[j] = hotelArray[j+1];
						hotelArray[j+1] = temp;
					}
				}
			}
		}
		
		for (HotelVO hotelVO : hotelArray) {
			sortedHotels.add(hotelVO);
		}
		return sortedHotels;
	}
}
