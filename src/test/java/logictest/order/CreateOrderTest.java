package logictest.order;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Message.RoomType;
import logic.order.CreateOrder;
import vo.OrderVO;
import vo.RoomVO;

public class CreateOrderTest {

	private CreateOrder createOrder;
	
	@Before
	public void setUp() {
		this.createOrder = new CreateOrder();
	}
	
	@Test
	public void testCreateOrder() {
		ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
		rooms.add(new RoomVO("00005", "1109", RoomType.SINGLE_ROOM, 400, false, null));
		
		OrderVO vo = new OrderVO("20161225000051234", "2016-12-25 12:00:00", "2016-12-26 12;00:00",
				"00005", rooms, 1, false, 400);
		
		vo = this.createOrder.createOrder(vo);
		
		assertEquals(vo.afterPrice, 320.0, 0);
		
		assertEquals(vo.promotions.get(0).promotionName, "全网折扣");
		
	}
	
}
