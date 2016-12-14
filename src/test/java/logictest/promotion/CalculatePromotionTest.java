package logictest.promotion;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Message.RoomType;
import logic.promotion.CalculatePromotion;
import vo.OrderVO;
import vo.RoomVO;

public class CalculatePromotionTest {

	private CalculatePromotion calculatePromotion;
	
	@Before
	public void setUp() {
		this.calculatePromotion = new CalculatePromotion();
	}
	
	//HotelBirthday + WebVipLevel + WebTradingArea + Web11 + Hotel11
	@Test
	public void testCalculatePromotion1() {
		OrderVO vo = new OrderVO("wyy", RoomType.STANDARD_ROOM, 1, "2016-11-11 12:00:00", "2016-11-12 12:00:00", "00001",  2, false);
		vo.beforePrice = 400;
		
		OrderVO order = this.calculatePromotion.calculatePromotion(vo);
		
		assertEquals("11111", order.promotion.promotionID);
		
		assertEquals(280, order.afterPrice, 0.00);
	}
	
	
	//HotelBirthday + WebVipLevel + WebTradingArea + HotelThreeRooms
	@Test
	public void testCalculatePromotion2() {
		ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
		OrderVO vo = new OrderVO("wyy",RoomType.STANDARD_ROOM, 3, "2016-11-30 12:00:00", "2016-11-31 12:00:00", "00001",4, false);
		vo.beforePrice = 1200;
		OrderVO order = this.calculatePromotion.calculatePromotion(vo);
		
		assertEquals("11111", order.promotion.promotionID);
		
		assertEquals(280, order.afterPrice, 0.00);	
	}
	
	//HotelBirthday + WebVipLevel + WebTradingArea + HotelThreeRooms
	@Test
	public void testCalculatePromotion3() {
		OrderVO vo = new OrderVO("wyy",RoomType.STANDARD_ROOM, 4,  "2016-11-30 12:00:00", "2016-11-31 12:00:00", "00001", 4, false);
		vo.beforePrice = 1500;
		OrderVO order = this.calculatePromotion.calculatePromotion(vo);
		
		assertEquals("11111", order.promotion.promotionID);
		
		assertEquals(280, order.afterPrice, 0.00);	
		
	}
	
	//HotelBusiness + WebVipLevel + WebTradingArea
	@Test
	public void testCalculatePromotion4() {
		OrderVO vo = new OrderVO("bcy",RoomType.STANDARD_ROOM,1, "2015-11-11 12:00:00", "2015-11-12 12:00:00", "00001",2, false);
		vo.beforePrice = 400;
		OrderVO order = this.calculatePromotion.calculatePromotion(vo);
		
		assertEquals("11111", order.promotion.promotionID);
		
		assertEquals(280, order.afterPrice, 0.00);	
	}
	
	//Web11 + Hotel11
	@Test
	public void testCalculatePromotion5() {
		OrderVO vo = new OrderVO("zdy", RoomType.STANDARD_ROOM, 1,"2016-11-11 12:00:00", "2016-11-12 12:00:00", "00001",2, false);
		vo.beforePrice = 400;
		OrderVO order = this.calculatePromotion.calculatePromotion(vo);
		
		assertEquals("11111", order.promotion.promotionID);
		
		assertEquals(280, order.afterPrice, 0.00);	
		
		assertEquals(400, order.beforePrice, 0);
		
	}
	
	//不使用任何prmotion
	@Test
	public void testCalculatePromotion6() {
		ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
		rooms.add(new RoomVO("00001", "1101", RoomType.STANDARD_ROOM, 400));
		OrderVO vo = new OrderVO("zdy",RoomType.STANDARD_ROOM, 1, "2015-11-11 12:00:00", "2015-11-12 12:00:00", "00001", 2, false);
		vo.beforePrice = 400;
		OrderVO order = this.calculatePromotion.calculatePromotion(vo);
		
		assertEquals(null, order.promotion);
		
		assertEquals(400, order.beforePrice, 0);
	}

}
