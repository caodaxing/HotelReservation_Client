package factories;

import Message.HotelSearchCondition;
import logic.hotel.GradeSort;
import logic.hotel.HotelSort;
import logic.hotel.PriceSort;
import logic.hotel.StarSort;

public class HotelSortFactory {
private static HotelSortFactory hotelSortFactory;
	
	public static HotelSortFactory getInstance() {
		if(hotelSortFactory == null) {
			hotelSortFactory = new HotelSortFactory();
		}
		return hotelSortFactory;
	}
	
	public HotelSort createHotelSort(HotelSearchCondition condition) {
		HotelSort sort = null;
		
		switch (condition) {
		case PRICE_DOWN:
			sort = new PriceSort();
			break;
		case PRICE_UP:
			sort = new PriceSort();
			break;
		case GRADE_DOWN:
			sort = new GradeSort();
			break;
		case GRADE_UP:
			sort = new GradeSort();
			break;
		case STAT_DOWN:
			sort = new StarSort();
			break;
		case STAR_UP:
			sort = new StarSort();
			break;
		default:
			System.out.println("logic.hotel.SearchHotel.getSortedList参数错误");
			break;
		}
		
		return sort;
	}
}
