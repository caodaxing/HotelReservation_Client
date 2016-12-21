package logictest.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Message.ResultMessage;
import logic.user.HotelManager;
import vo.HotelManagerVO;

public class HotelManagerTest {
	
	private HotelManager hotelManager;
	
	@Before
	public void setUp() {
		this.hotelManager = new HotelManager();
	}
	
	@Test
	public void testGetHotelManagerInfo() {
		assertEquals(this.hotelManager.getHotelManagerInfo("00001").trueName, "abc");
		assertEquals("3203221", this.hotelManager.getHotelManagerInfo("00002").numberOfIdentityCard);
	}
	
	@Test
	public void testUpdateHotelManagerInfo() {
		HotelManagerVO vo = new HotelManagerVO("00002", "33333333333", "def","32032222222");
		assertEquals(this.hotelManager.updateHotelManagerInfo(vo), ResultMessage.SUCCESS);
	}

}
