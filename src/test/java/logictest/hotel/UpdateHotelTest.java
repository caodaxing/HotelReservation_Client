package logictest.hotel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Message.ResultMessage;
import logic.hotel.UpdateHotel;
import vo.HotelVO;

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

	@Test
	public void testUpdateHotelInfo(){
		assertEquals(ResultMessage.SUCCESS, updateHotel.updateHotelInfo(new HotelVO("00001", "rujia", "南京", "仙林中心", 
				"仙林大道163号", 4.9, 3, "introduction", "facilites",null, null, "nju")));
	}
}
