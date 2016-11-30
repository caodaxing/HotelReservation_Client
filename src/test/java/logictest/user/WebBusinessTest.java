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
		webBusiness = new WebBusiness("mdzz");
	}
	
	@Test
	public void testGetWebBusinessInfo() {
		assertEquals(this.webBusiness.getWebBusinessInfo(this.webBusiness.getWebBusinessID()).numberOfIdentityCard,
				"11");
	}
	
	@Test
	public void testUpdateWebBusinessInfo() {
		WebBusinessVO vo = new WebBusinessVO("mdzz", "王雪", "1333", "22");
		assertEquals(this.webBusiness.updateWebBusinessInfo(vo), ResultMessage.SUCCESS);
		assertEquals(this.webBusiness.getWebBusinessPO().getNumberOfIdentityCard(), "22");
	}

}
