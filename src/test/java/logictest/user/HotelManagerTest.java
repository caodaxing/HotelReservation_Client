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
		this.hotelManager = new HotelManager("rujia");
	}
	
	@Test
	public void testGetHotelManagerInfo() {
		assertEquals(this.hotelManager.getHotelManagerInfo("rujia").trueName, "卞纯源");
		assertEquals(this.hotelManager.getHotelManagerPO().getNumberOfIdentityCard(), "3203222");
	}
	
	@Test
	public void testUpdateHotelManagerInfo() {
		HotelManagerVO vo = new HotelManagerVO("rujia", "如家酒店", "111111","卞纯源", "32032222222");
		assertEquals(this.hotelManager.updateHotelManagerInfo(vo), ResultMessage.SUCCESS);
		assertEquals(this.hotelManager.getHotelManagerPO().getPhoneNumber(), "111111");
	}

}
