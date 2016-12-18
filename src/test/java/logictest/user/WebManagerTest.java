package logictest.user;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Message.ResultMessage;
import logic.user.WebManager;
import vo.HotelManagerVO;

public class WebManagerTest {

	private WebManager webManager;
	
	@Before
	public void setUp() {
		this.webManager = new WebManager();
	}
	
	@Test
	public void testAddHotelManager() {
		HotelManagerVO vo = new HotelManagerVO("mdzzz", "green", "1222","111222");
		assertEquals(this.webManager.addHotelManager(vo), ResultMessage.SUCCESS);
	}
}
