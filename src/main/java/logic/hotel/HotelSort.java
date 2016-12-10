package logic.hotel;

import java.util.ArrayList;

import Message.HotelSearchCondition;
import vo.HotelVO;

public interface HotelSort {
	public ArrayList<HotelVO> getSortedList(HotelSearchCondition condition, ArrayList<HotelVO> hotels);
}
