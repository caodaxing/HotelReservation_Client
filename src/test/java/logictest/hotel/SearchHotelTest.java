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
	public void testSearch1(){
		HotelSearchVO vo = new HotelSearchVO("南京", "仙林中心", "如家", RoomType.STANDARD_ROOM, "2017-01-07 12:00:00", "2017-01-08 12:00:00", 0, 600, 4, 5, 2, 5);
		
		ArrayList<HotelVO> vos = this.searchHotel.search(vo);
		assertEquals(1, vos.size());
		assertEquals("00001", vos.get(0).hoteID);
	}
	
	@Test
	public void testSearch2(){
		HotelSearchVO vo = new HotelSearchVO("南京", "仙林中心", null, RoomType.STANDARD_ROOM, "2017-01-07 12:00:00", "2017-01-08 12:00:00", 0, 600, 4, 5, 2, 5);
		
		ArrayList<HotelVO> vos = this.searchHotel.search(vo);
		assertEquals(2, vos.size());
	}
	
	//测试评分和不设置房间类型作用
	@Test
	public void testSearch3(){
		HotelSearchVO vo = new HotelSearchVO("南京", "仙林中心", null, null, "2017-01-07 12:00:00", "2017-01-08 12:00:00", 0, 600, 4.7, 5, 2, 5);
		
		ArrayList<HotelVO> vos = this.searchHotel.search(vo);
		assertEquals(2, vos.size());
		assertEquals("00002", vos.get(0).hoteID);
		assertEquals("00001", vos.get(1).hoteID);
	}
	
	//测试酒店星级搜索作用
	@Test
	public void testSearch4(){
		HotelSearchVO vo = new HotelSearchVO("南京", "仙林中心", null, null, "2017-01-07 12:00:00", "2017-01-08 12:00:00", 0, 600, 4.7, 5, 3, 5);
		
		ArrayList<HotelVO> vos = this.searchHotel.search(vo);
		
		assertEquals(1, vos.size());
	}
	
	//测试价格和评分搜索作用
	@Test
	public void testSearch5(){
		HotelSearchVO vo = new HotelSearchVO("南京", "仙林中心", null, null, "2016-11-07 12:00:00", "2016-11-08 12:00:00", 260, 600, 4.7, 5, 2, 5);
		
		ArrayList<HotelVO> vos = this.searchHotel.search(vo);
		assertEquals(null, vos);
	}
	
	//测试空房时间和价格搜索作用
	@Test
	public void testSearch6(){
		HotelSearchVO vo = new HotelSearchVO("南京", "仙林中心", null, null, "2017-01-07 12:00:00", "2017-01-08 12:00:00", 260, 600, 4, 5, 2, 5);
		
		ArrayList<HotelVO> vos = this.searchHotel.search(vo);
		assertEquals(null, vos);
	}
	
	//测试酒店名称作用
	@Test
	public void testSearch7(){
		HotelSearchVO vo = new HotelSearchVO("南京", "仙林中心", "green", RoomType.STANDARD_ROOM, "2017-01-07 12:00:00", "2017-01-08 12:00:00", 0, 600, 4, 5, 2, 5);
		
		ArrayList<HotelVO> vos = this.searchHotel.search(vo);
		assertEquals(1, vos.size());
		assertEquals("00002", vos.get(0).hoteID);
	}
}
