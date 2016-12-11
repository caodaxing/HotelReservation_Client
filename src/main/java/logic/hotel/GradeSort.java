package logic.hotel;

import java.util.ArrayList;

import Message.HotelSearchCondition;
import vo.HotelVO;

/**
 * 按评分排序
 * 
 * @author all
 *
 */
public class GradeSort implements HotelSort{
	
	private  UpOrDownSort sort;

	public GradeSort() {
		this.sort = new Down();
	}
	
	public GradeSort(UpOrDownSort sort) {
		this.sort = sort;
	}

	/**
	 * 根据酒店评价等级进行排序
	 * @param condition
	 * @param hotels
	 * @return
	 */
	public ArrayList<HotelVO> getSortedList(ArrayList<HotelVO> hotels) {
		if (hotels == null ) {
			System.out.println("logic.hotel.GradeSort.getSortedList参数异常");
			return null;
		}
		ArrayList<HotelVO> sortedHotels = new ArrayList<>();
		// 对符合排序条件的酒店进行排序
		HotelVO[] hotelArray = new HotelVO[hotels.size()];
		for (int i = 0; i < hotels.size(); i++) {
			hotelArray[i] = hotels.get(i);
		}
		
		for (int i = hotelArray.length - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (sort.compare(hotelArray[j].evaluationGrades, hotelArray[j + 1].evaluationGrades)) {
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
	 * 将酒店按评分排序
	 * @param startGrade 最低评分
	 * @param endGrade 最高评分
	 * @param ArrayList<HotelVO> 需要排序的酒店列表
	 * @return ArrayList<HotelVO> 返回按评分排序好的酒店名称列表
	 * @author all
	 */
	public ArrayList<HotelVO> getSpecificSectionHotelList(double startGrade, double endGrade, ArrayList<HotelVO> hotels) {
		if (hotels == null || startGrade > endGrade) {
			return null;
		}
		// 获取符合条件的酒店列表
		ArrayList<HotelVO> hotelList = new ArrayList<>();
		for (HotelVO hotelVO : hotelList) {
			if (hotelVO.evaluationGrades >= startGrade && hotelVO.evaluationGrades <= endGrade) {
				hotelList.add(hotelVO);
			}
		}
		return this.getSortedList(hotelList);
	}
}
