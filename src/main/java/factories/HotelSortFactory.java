package factories;

import Message.HotelSearchCondition;
import logic.hotel.Down;
import logic.hotel.GradeSort;
import logic.hotel.HotelSort;
import logic.hotel.PriceSort;
import logic.hotel.StarSort;
import logic.hotel.Up;

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
			sort = new PriceSort(new Down());
			break;
		case PRICE_UP:
			sort = new PriceSort(new Up());
			break;
		case GRADE_DOWN:
			sort = new GradeSort(new Down());
			break;
		case GRADE_UP:
			sort = new GradeSort(new Up());
			break;
		case STAR_DOWN:
			sort = new StarSort(new Down());
			break;
		case STAR_UP:
			sort = new StarSort(new Up());
			break;
		default:
			System.out.println("logic.factory.HotelSortFactory.createHotelSort参数错误");
			break;
		}
		
		return sort;
	}
}
