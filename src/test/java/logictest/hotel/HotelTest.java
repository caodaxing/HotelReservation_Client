package logictest.hotel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import logic.hotel.CheckHotel;
import vo.HotelVO;

public class HotelTest {

	private CheckHotel hotel;
	
	@Before
	public void setUp() {
		this.hotel = new CheckHotel();
	}
	
	@Test
	public void testGetHotelnfo1(){
		assertEquals("南京大学", hotel.getHotelnfo("00001").bussiness);
	}
	
	@Test
	public void testGetHotelnfo2(){
		assertEquals("酒店介绍2", hotel.getHotelnfo("00002").introduction);
	}

	@Test
	public void testGetHotelEvaluations(){
		assertEquals(2, hotel.getHotelEvaluations("00001").size());
		
		assertEquals("爽", hotel.getHotelEvaluations("00001").get(0).evaluationContent);
	}
}
