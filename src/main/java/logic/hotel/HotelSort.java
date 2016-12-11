package logic.hotel;

import java.util.ArrayList;

import Message.HotelSearchCondition;
import vo.HotelVO;

public interface HotelSort {
	public ArrayList<HotelVO> getSortedList(ArrayList<HotelVO> hotels);
	
	public ArrayList<HotelVO> getSpecificSectionHotelList(double start, double end,ArrayList<HotelVO> hotels);
}
