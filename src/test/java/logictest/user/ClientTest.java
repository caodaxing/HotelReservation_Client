package logictest.user;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		client = new Client();
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
	public void testGetVipInfo1() {
		assertEquals(client.isVIP("wyy"), true);
		
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String t =format.format(new Date());
		
		assertEquals(t, client.getVipInfo("wyy").info);
	}
	
	@Test
	public void testGetVipInfo2() {
		assertEquals(false, client.isVIP("zdy"));
		
		assertEquals(null, client.getVipInfo("zdy"));
	}
	
	@Test
	public void testRegisterVIP() {
		assertEquals(ResultMessage.FAILURE, client.registerVIP(new VipVO("bcy", VipType.BIRTHDAY_VIP, 0, "20160101")));
		
		assertEquals(ResultMessage.SUCCESS, client.registerVIP(new VipVO("zdy", VipType.BIRTHDAY_VIP, 0, "20160101")));
	}

}
