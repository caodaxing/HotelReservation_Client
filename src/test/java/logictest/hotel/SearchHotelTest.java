package logictest.hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import logic.hotel.SearchHotel;
import vo.HotelVO;

public class SearchHotelTest {

	private SearchHotel searchHotel ;
	
	@Before
	public void setUp() {
		this.searchHotel = new SearchHotel();
	}
	
	@Test
	public void testGetTradingArea(){
		ArrayList<String> tradingAreas = searchHotel.getTradingArea("栖霞区");
		ArrayList<String> trueTradingAreas = new ArrayList<>();
		trueTradingAreas.add("尧化门");
		assertEquals(tradingAreas,trueTradingAreas);
	}
	
	@Test
	public void testGetInitialHotelList(){
		ArrayList<HotelVO> hotels = searchHotel.getInitialHotelList("123",  "123");
		ArrayList<HotelVO> trueHotels = new ArrayList<>();
		System.out.println(hotels.get(0).hoteID);
		HotelVO hotelVO=new HotelVO("123", "汉庭", "123", "123", "123", 1, "", null, null, null, null);
		trueHotels.add(new HotelVO("123", "汉庭", "123", "123", "123", 1, "", null, null, null, null));
		assertEquals(hotels.get(0), hotelVO);
	}
	
	@Test
	public void testGetSortedList(){
	}
}
