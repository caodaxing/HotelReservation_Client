package logictest.utility;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Message.OrderState;
import Message.RoomType;
import logic.utility.OrderTransform;
import po.OrderPO;
import vo.OrderVO;
import vo.PromotionVO;
import vo.RoomVO;

public class OrderTransformTest {

	private OrderTransform orderTransform;
	
	@Before
	public void setUp() {
		orderTransform = new OrderTransform();
	}
	
	@Test
	public void testOrderListTransToVO() {
		
		OrderPO po1 = new OrderPO("wyy", "20161212000041122", "green", "2016-09-09 12:00:00", 
				"2016-09-10 12:00:00", null, 1, 1, false, 2, 0, 400, 320, "ppp", 
				null, null, null, null, null);
		
		String[] rooms = {"1109"};
		OrderPO po2 = new OrderPO("wyy", "20161214000041122", "green", "2016-12-13 12:00:00", 
				"2016-12-14 12:00:00", rooms, 1, 2, false, 2, 0, 300, 240, "ppp", 
				null, null, null, null, null);
		
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		pos.add(po1);
		pos.add(po2);
		
		ArrayList<OrderVO> vos = this.orderTransform.orderListTransToVO(pos);
		
		assertEquals(vos.get(0).promotion.promotionID, "ppp");
		
	}
	
	@Test
	public void testOrderTransToVO() {
		
		String[] rooms = {"115"};
		OrderPO po = new OrderPO("wyy", "20161212000041122", "green", "2016-09-09 12:00:00", 
				"2016-09-10 12:00:00",rooms,  1, 3, false, 2, 0, 400, 320, "ppp", 
				null, null, null, null, null);
		
		OrderVO vo = this.orderTransform.orderTransToVO(po);
		
		assertEquals(vo.promotion.promotionID, "ppp");
		
		assertEquals(vo.roomIDs[0], "115");
		
	}
	
	@Test
	public void testOrderTransToPO() {
		
		PromotionVO promotion = new PromotionVO("ppp", " 全网折扣", 0.8, "2016-01-01 12:00:00", "2016-12-12 12:00:00");
		String[] rooms = {"119"};
		
		OrderVO vo = new OrderVO("wyy", "20161212000041122", RoomType.STANDARD_ROOM, rooms, 1, "2016-09-10 12:00:00", "2016-10-10 12:00:00",
				"green",  OrderState.UNEXECUTED, 2, false, 400, 320, promotion, null, null, null, null, null);
		
		OrderPO po = this.orderTransform.orderTransToPO(vo);
		
		assertEquals(po.getPromotionID(), "ppp");
		assertEquals(po.getRoomIDs()[0], "119");
		
	}

}
