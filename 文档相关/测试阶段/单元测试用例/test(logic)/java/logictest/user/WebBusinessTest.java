package logictest.user;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Message.ResultMessage;
import logic.user.WebBusiness;
import vo.WebBusinessVO;

public class WebBusinessTest {

	private WebBusiness webBusiness;
	
	@Before
	public void setUp() {
		webBusiness = new WebBusiness();
	}
	
	@Test
	public void testGetWebBusinessInfo() {
		assertEquals("11", this.webBusiness.getWebBusinessInfo("mdzz").numberOfIdentityCard);
	}
	
	@Test
	public void testUpdateWebBusinessInfo() {
		WebBusinessVO vo = new WebBusinessVO("mdzz", "王雪", "1333", "22");
		assertEquals(this.webBusiness.updateWebBusinessInfo(vo), ResultMessage.SUCCESS);
	}

}
