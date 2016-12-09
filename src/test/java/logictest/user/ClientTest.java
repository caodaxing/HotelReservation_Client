package logictest.user;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Message.ResultMessage;
import Message.VipType;
import logic.user.Client;
import po.ClientPO;
import vo.ClientVO;
import vo.VipVO;

public class ClientTest {

	private Client client;
	
	@Before
	public void setUp() {
		client = new Client("wyy");
	}
	
	@Test
	public void testInitClientPO() {
		assertEquals(client.getClientID(), "wyy");
		assertEquals(client.getClientPO().getPhoneNumber(), "13338031126");
	}
	
	@Test
	public void testGetClientInfo() {
		assertEquals(client.getClientInfo("wyy").trueName, "王友运");
	}
	
	@Test
	public void testUpdateClientInfo1() {
		ClientVO vo = null;
		assertEquals(client.updateClientInfo(vo), ResultMessage.FAILURE);
	}
	
	@Test
	public void testUpdateClientInfo2() {
		ClientVO vo = new ClientVO("wyy", "13338031126", "王友运", "3203221111111111", 1000, "image/wyy.jpg");
		assertEquals(client.updateClientInfo(vo), ResultMessage.SUCCESS);
		//data层写好了才能测试
//		assertEquals(client.getClientPO().getVipInfo(), "nju");
	}
	
	@Test
	public void testGetVipInfo() {
		assertEquals(client.getVipInfo("wyy").info, "南京大学");
	}
	
	@Test
	public void testRegisterVIP1() {
		assertEquals(client.isVIP(client.getClientPO().getUserID()), true);
	}
	
	@Test
	public void testRegisterVIP2() {
		client.setClientPO(new ClientPO("wyy", "13338031126", "王友运", "3203221111111111", "image/wyy.jpg", 0, 0, null));
		assertEquals(client.registerVIP(new VipVO("wyy", VipType.BIRTHDAY_VIP, 0, "20160101")), ResultMessage.SUCCESS);
		assertEquals(client.getClientPO().getVipType(), 1);
	}

}
