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

	/**
	 * 根据酒店评价等级进行排序
	 * @param condition
	 * @param hotels
	 * @return
	 */
	public ArrayList<HotelVO> getSortedList(HotelSearchCondition condition, ArrayList<HotelVO> hotels) {
		if (hotels == null || condition != HotelSearchCondition.GRADE_DOWN
				|| condition != HotelSearchCondition.GRADE_UP) {
			System.out.println("logic.hotel.GradeSort.getSortedList参数异常");
			return null;
		}
		ArrayList<HotelVO> sortedHotels = new ArrayList<>();
		// 对符合排序条件的酒店进行排序
		HotelVO[] hotelArray = new HotelVO[hotels.size()];
		for (int i = 0; i < hotels.size(); i++) {
			hotelArray[i] = hotels.get(i);
		}
		if (condition == HotelSearchCondition.GRADE_UP) { // 升序
			for (int i = hotelArray.length - 1; i > 0; --i) {
				for (int j = 0; j < i; ++j) {
					if (hotelArray[j].evaluationGrades <= hotelArray[j + 1].evaluationGrades) {
						HotelVO temp = hotelArray[j];
						hotelArray[j] = hotelArray[j + 1];
						hotelArray[j + 1] = temp;
					}
				}
			}
		} else { // 降序
			for (int i = hotelArray.length - 1; i > 0; --i) {
				for (int j = 0; j < i; ++j) {
					if (hotelArray[j].evaluationGrades >= hotelArray[j + 1].evaluationGrades) {
						HotelVO temp = hotelArray[j];
						hotelArray[j] = hotelArray[j + 1];
						hotelArray[j + 1] = temp;
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
	 * 将酒店按评分排序
	 * @param startGrade 最低评分
	 * @param endGrade 最高评分
	 * @param ArrayList<HotelVO> 需要排序的酒店列表
	 * @return ArrayList<HotelVO> 返回按评分排序好的酒店名称列表
	 * @author all
	 */
	public ArrayList<HotelVO> getSortedList(double startGrade, double endGrade, HotelSearchCondition condition,
			ArrayList<HotelVO> hotels) {
		if (hotels == null || startGrade > endGrade) {
			return null;
		}
		ArrayList<HotelVO> sortedHotels = new ArrayList<>();
		// 获取符合排序条件的酒店列表
		ArrayList<HotelVO> hotelList = new ArrayList<>();
		for (HotelVO hotelVO : hotelList) {
			if (hotelVO.evaluationGrades >= startGrade && hotelVO.evaluationGrades <= endGrade) {
				hotelList.add(hotelVO);
			}
		}
		// 对符合排序条件的酒店进行排序
		HotelVO[] hotelArray = new HotelVO[hotelList.size()];
		for (int i = 0; i < hotelList.size(); i++) {
			hotelArray[i] = hotelList.get(i);
		}
		if (condition == HotelSearchCondition.GRADE_UP) { // 升序
			for (int i = hotelArray.length - 1; i > 0; --i) {
				for (int j = 0; j < i; ++j) {
					if (hotelArray[j].evaluationGrades <= hotelArray[j + 1].evaluationGrades) {
						HotelVO temp = hotelArray[j];
						hotelArray[j] = hotelArray[j + 1];
						hotelArray[j + 1] = temp;
					}
				}
			}
		} else { // 降序
			for (int i = hotelArray.length - 1; i > 0; --i) {
				for (int j = 0; j < i; ++j) {
					if (hotelArray[j].evaluationGrades >= hotelArray[j + 1].evaluationGrades) {
						HotelVO temp = hotelArray[j];
						hotelArray[j] = hotelArray[j + 1];
						hotelArray[j + 1] = temp;
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
