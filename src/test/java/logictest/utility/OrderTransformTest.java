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
		ArrayList<String> roomIDs1 = new ArrayList<String>();
		roomIDs1.add("1109");
		
		ArrayList<String> promotionIDs1 = new ArrayList<String>();
		promotionIDs1.add("ppp");
		
		OrderPO po1 = new OrderPO("wyy", "20161212000041122", "green", "2016-09-09 12:00:00", 
				"2016-09-10 12:00:00", 1, roomIDs1, false, 2, 0, 400, 320, 1, promotionIDs1, 
				null, null, null, null);
		
		ArrayList<String> roomIDs2 = new ArrayList<String>();
		roomIDs2.add("1223");
		
		ArrayList<String> promotionIDs2 = new ArrayList<String>();
		promotionIDs2.add("ppp");
		
		OrderPO po2 = new OrderPO("wyy", "20161214000041122", "green", "2016-12-13 12:00:00", 
				"2016-12-14 12:00:00", 1, roomIDs2, false, 2, 0, 300, 240, 1, promotionIDs2, 
				null, null, null, null);
		
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		pos.add(po1);
		pos.add(po2);
		
		ArrayList<OrderVO> vos = this.orderTransform.orderListTransToVO(pos);
		
		assertEquals(vos.get(0).promotions.get(0).promotionID, "ppp");
		
		assertEquals("00001", vos.get(1).rooms.get(0).hotelId);
	}
	
	@Test
	public void testOrderTransToVO() {
		ArrayList<String> roomIDs = new ArrayList<String>();
		roomIDs.add("1109");
		
		ArrayList<String> promotionIDs = new ArrayList<String>();
		promotionIDs.add("ppp");
		
		OrderPO po = new OrderPO("wyy", "20161212000041122", "green", "2016-09-09 12:00:00", 
				"2016-09-10 12:00:00", 1, roomIDs, false, 2, 0, 400, 320, 1, promotionIDs, 
				null, null, null, null);
		
		OrderVO vo = this.orderTransform.orderTransToVO(po);
		
		assertEquals(vo.promotions.get(0).promotionID, "ppp");
		
	}
	
	@Test
	public void testOrderTransToPO() {
		ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
		rooms.add(new RoomVO("green", "1109", RoomType.STANDARD_ROOM, 400));
		
		ArrayList<PromotionVO> promotions = new ArrayList<PromotionVO>();
		promotions.add(new PromotionVO("ppp", " 全网折扣", 0.8, "2016-01-01 12:00:00", "2016-12-12 12:00:00"));
		
		OrderVO vo = new OrderVO("wyy", "20161212000041122", "2016-09-10 12:00:00", "2016-10-10 12:00:00",
				"green", rooms, OrderState.UNEXECUTED, 2, false, 400, 320, promotions, null, null, null, null);
		
		OrderPO po = this.orderTransform.orderTransToPO(vo);
		
		assertEquals(po.getPromotionIDs().get(0), "ppp");
		
		assertEquals(po.getRoomIDs().get(0), "1109");
	}

}
