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
	
	//替换MockCalculatePromotion之前
//	@Test
//	public void testCreateOrder1() {
//		ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
//		rooms.add(new RoomVO("00005", "1109", RoomType.SINGLE_ROOM, 400, false, null));
//		
//		OrderVO vo = new OrderVO("20161225000051234", "2016-12-25 12:00:00", "2016-12-26 12;00:00",
//				"00005", rooms, 1, false, 400);
//		
//		vo = this.createOrder.createOrder(vo);
//		
//		assertEquals(vo.afterPrice, 320.0, 0);
//		
//		assertEquals(vo.promotions.get(0).promotionName, "全网折扣");
//		
//	}

	//替换MockCalculatePromotion之后
	@Test
	public void testCreateOrder2() {
		OrderVO vo = new OrderVO("wyy", RoomType.STANDARD_ROOM, 1, "2016-11-11 12:00:00", "2016-11-12 12:00:00", "00001",  2, false);
		
		OrderVO order = this.createOrder.createOrder(vo);
		
		assertEquals("55555", order.promotion.promotionID);
		
		assertEquals(350,  order.afterPrice, 0);
	}
	
	@Test
	public void testCreateOrder3() {
		OrderVO vo = new OrderVO("wyy", RoomType.STANDARD_ROOM, 1, "2016-12-25 12:00:00", "2016-12-26 12:00:00", "00002",  2, false);
		
		OrderVO order = this.createOrder.createOrder(vo);
		
		assertEquals("20161225001889", order.orderId);
		
		assertEquals("66666", order.promotion.promotionID);
		
		assertEquals(320, order.afterPrice, 0);
		
	}
	
	
	//替换MockCalculatePromotion和MockCreditInfo之后
	@Test
	public void testCreateOrder4() {
		assertEquals(false, this.createOrder.judgeCreditCanCreateOrder("zdy"));
		
		assertEquals(true, this.createOrder.judgeCreditCanCreateOrder("wyy"));
	}
	
	
	
}
