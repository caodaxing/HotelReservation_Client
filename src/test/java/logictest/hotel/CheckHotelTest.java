package logictest.hotel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import logic.hotel.Hotel;
import vo.HotelVO;

public class CheckHotelTest {

	private Hotel hotel;
	
	@Before
	public void setUp() {
		this.hotel = new Hotel();
	}
	
	@Test
	public void testGetHotelnfo(){
		HotelVO hotelVO = hotel.getHotelnfo("123");
		assertEquals(hotelVO,new HotelVO("123", "123", "南京", "栖霞区", "仙林中心", "仙林中心", 0, "", "", null, null, null));
	}
}
