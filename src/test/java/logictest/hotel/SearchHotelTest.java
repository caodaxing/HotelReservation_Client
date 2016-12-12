package logictest.hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Message.HotelSearchCondition;
import Message.RoomType;
import logic.hotel.SearchHotel;
import vo.HotelSearchVO;
import vo.HotelVO;

public class SearchHotelTest {

	private SearchHotel searchHotel ;
	
	@Before
	public void setUp() {
		this.searchHotel = new SearchHotel();
	}
	
	@Test
	public void testGetTradingArea(){
		assertEquals(5, this.searchHotel.getTradingArea("南京").size());
	}
	
	@Test
	public void testGetInitialHotelList(){
		ArrayList<HotelVO> vos = this.searchHotel.getInitialHotelList("南京", "仙林中心");
		
		assertEquals(3,vos.size());
		
		assertEquals("00001", vos.get(0).hoteID);
		assertEquals("00002", vos.get(1).hoteID);
		assertEquals("00003", vos.get(2).hoteID);
	}
	
	@Test
	public void testGetSortedList1(){
		ArrayList<HotelVO> v = this.searchHotel.getInitialHotelList("南京", "仙林中心");
		
		ArrayList<HotelVO> vos = this.searchHotel.getSortedList(HotelSearchCondition.GRADE_UP, v);
		
		assertEquals(3, vos.size());
		assertEquals(4.5, 0, vos.get(0).evaluationGrades);
		assertEquals("00003", vos.get(0).hoteID);
		assertEquals(4.7, 0, vos.get(1).evaluationGrades);
		assertEquals("00001", vos.get(1).hoteID);
		assertEquals(4.8, 0, vos.get(2).evaluationGrades);
		assertEquals("00002", vos.get(2).hoteID);
	}
	
	@Test
	public void testGetSortedList2(){
		ArrayList<HotelVO> vos = this.searchHotel.getSortedList(HotelSearchCondition.GRADE_DOWN, 
				this.searchHotel.getInitialHotelList("南京", "仙林中心"));
		
		assertEquals(3, vos.size());
		assertEquals(4.8, 0, vos.get(0).evaluationGrades);
		assertEquals(4.7, 0, vos.get(1).evaluationGrades);
		assertEquals(4.5, 0, vos.get(2).evaluationGrades);
	}
	
	@Test
	public void testGetSortedList3(){
		ArrayList<HotelVO> vos = this.searchHotel.getSortedList(HotelSearchCondition.STAR_UP, 
				this.searchHotel.getInitialHotelList("南京", "仙林中心"));
		
		assertEquals(3, vos.size());
		assertEquals(2, vos.get(0).levelOfHotel);
		assertEquals(3, vos.get(1).levelOfHotel);
		assertEquals(4, vos.get(2).levelOfHotel);
	}
	
	@Test
	public void testGetSortedList4(){
		ArrayList<HotelVO> vos = this.searchHotel.getSortedList(HotelSearchCondition.STAR_DOWN, 
				this.searchHotel.getInitialHotelList("南京", "仙林中心"));
		
		assertEquals(3, vos.size());
		assertEquals(4, vos.get(0).levelOfHotel);
		assertEquals(3, vos.get(1).levelOfHotel);
		assertEquals(2, vos.get(2).levelOfHotel);
	}
	
	@Test
	public void testGetSortedList5(){
		ArrayList<HotelVO> vos = this.searchHotel.getSortedList(HotelSearchCondition.PRICE_UP, 
				this.searchHotel.getInitialHotelList("南京", "仙林中心"));
		
		assertEquals(3, vos.size());
		assertEquals("00002", vos.get(0).hoteID);
		assertEquals("00001", vos.get(1).hoteID);
		assertEquals("00003", vos.get(2).hoteID);
	}
	
	@Test
	public void testGetSortedList6(){
		ArrayList<HotelVO> vos = this.searchHotel.getSortedList(HotelSearchCondition.PRICE_DOWN, 
				this.searchHotel.getInitialHotelList("南京", "仙林中心"));
		
		assertEquals(3, vos.size());
		assertEquals("00003", vos.get(0).hoteID);
		assertEquals("00001", vos.get(1).hoteID);
		assertEquals("00002", vos.get(2).hoteID);
	}
	
	@Test
	public void testGetBookedHotelList(){
		ArrayList<HotelVO> vos = this.searchHotel.getBookedHotelList("wyy");
		
		assertEquals(2, vos.size());
		
		assertEquals("00001", vos.get(0).hoteID);
		assertEquals("新华书店", vos.get(1).bussiness);
	}
	

	@Test
	public void testSearch(){
//		HotelSearchVO vo = new HotelSearchVO("南京", "仙林中心", "如家", RoomType.STANDARD_ROOM, 10, 500, 4.8, 5, 2, 5);
//		
//		assertEquals(1, this.searchHotel.search(vo).size());
//		assertEquals("00002", this.searchHotel.search(vo).get(0).hoteID);
	}
}
