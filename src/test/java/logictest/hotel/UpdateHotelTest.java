package logictest.hotel;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import logic.hotel.UpdateHotel;

public class UpdateHotelTest {

	private UpdateHotel updateHotel;
	
	@Before
	public void setUp(){
		updateHotel = new UpdateHotel();
	}
	
	@Test
	public void testAddHotel(){
		assertEquals(null, updateHotel.addHotel(null));
	}
}
