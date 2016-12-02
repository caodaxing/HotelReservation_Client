package logictest.user;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Message.ResultMessage;
import logic.user.WebManager;
import vo.HotelManagerVO;
import vo.HotelVO;

public class WebManagerTest {

	private WebManager webManager;
	
	@Before
	public void setUp() {
		this.webManager = new WebManager("zz");
	}
	
	@Test
	public void testAddHotel1() {
		HotelVO vo = null;
		assertEquals(this.webManager.addHotel(vo), ResultMessage.FAILURE);
	}
	
	@Test
	public void testAddHotel2() {
		HotelVO vo = new HotelVO("green", "Green", "nj", "gulou", "nju", 3, null, null, null, null, "nju");
		assertEquals(this.webManager.addHotel(vo), ResultMessage.SUCCESS);
	}

	@Test
	public void testAddHotelManager() {
		HotelManagerVO vo = new HotelManagerVO("mdzzz", "green", "1222", "bcy", "111222");
		assertEquals(this.webManager.addHotelManager(vo), ResultMessage.SUCCESS);
	}
}
